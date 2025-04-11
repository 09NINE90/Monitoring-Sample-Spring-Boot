# Sample Monitoring SpringBoot

**RU:** Этот проект демонстрирует интеграцию Spring Boot с мониторингом с использованием Prometheus и Grafana для сбора метрик и визуализации данных.

**EN:** This project demonstrates the integration of Spring Boot with monitoring using Prometheus and Grafana to collect metrics and visualize data.

---

### Конфигурация (Configuration)

**RU:** Все файлы настроек для Prometheus, Grafana, Loki, а также JSON-файл для построения дашборда в Grafana находятся в папке `monitoring-settings`.

**EN:** All settings files for Prometheus, Grafana, Loki, as well as a JSON file for building a dashboard in Grafana are located in the `monitoring-settings` folder.

---

### Запуск с Docker и Docker Compose (Launching with Dokker and Dokker Compose)

**RU:** Для удобства развертывания проекта, вы можете использовать Docker и Docker Compose. 
- В проекте уже есть конфигурации для их использования.
- В проекте присутствует `Dockerfile` для создания Docker-образа
- Используйте `docker-compose.yml` для одновременного запуска всех сервисов, включая ваше Spring Boot приложение, Prometheus и Grafana

**EN:** For the convenience of deploying a project, you can use Docker and Docker Compose.
- The project already has configurations for their use.
- The project has a `Dockerfile` for creating a Docker image
- Use `docker-compose.yml` for simultaneous launch of all services, including your Spring Boot application, Prometheus and Grafana

---

### Запуск приложения (Launching the app)

**RU:** Чтобы запустить приложение и все необходимые сервисы, выполните следующие шаги:

**EN:** To launch the app and all the necessary services, follow these steps:

1. **Соберите приложение с помощью Gradle (Build the app using Gradle):** 
    ```bash
    ./gradlew build
    ```

2. **Запустите Docker Compose (Launch Docker Compose):**
   
   В корне проекта выполните команду (At the root of the project, run the command):
    ```bash
    docker-compose up --build
    ```

3. **RU:** После успешного запуска вы сможете получить доступ к вашему приложению, Prometheus и Grafana через следующие порты:
    - Приложение: `http://localhost:8989`
    - Prometheus: `http://localhost:9090`
    - Grafana: `http://localhost:3000` (логин: `admin`, пароль: `admin`)

   **EN:** After successful launch, you will be able to access your app, Prometheus, and Grafana via the following ports:
    - Application: `http://localhost:8989 `
    - Prometheus: `http://localhost:9090 `
    - Grafana: `http://localhost:3000 ` (login: `admin', password: `admin`)

---

### Примечания (Notes)

**RU:**
- Убедитесь, что файлы конфигурации для Prometheus и Grafana корректно настроены для вашего окружения.
- В папке `monitoring-settings` находятся все необходимые настройки для подключения к Prometheus и Grafana, а также JSON-файлы для создания дашбордов в Grafana.

**EN:**
- Make sure that the configuration files for Prometheus and Grafana are configured correctly for your environment.
- The `monitoring-settings` folder contains all the necessary settings for connecting to Prometheus and Grafana, as well as JSON files for creating dashboards in Grafana.

---

## Нагрузочное тестирование с ab (Apache benchmark):

```
ab -k -c 5 -n 20000 'http://localhost:8989/api/getExample' & \
ab -k -c 5 -n 2000 ' http://localhost:8989/api/getExample/error' & \
ab -k -c 50 -n 5000 'http://localhost:8989/api/getExample/withDelay/1000' & \
ab -k -c 50 -n 2000 'http://localhost:8989/api/getExample/withDelay/3000'
```