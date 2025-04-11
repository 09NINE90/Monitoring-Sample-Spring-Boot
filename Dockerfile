FROM openjdk:21
WORKDIR /app
COPY /build/libs/MonitoringSample-0.0.1-SNAPSHOT.jar app.jar
COPY . .
EXPOSE 8989
ENTRYPOINT ["java", "-jar", "app.jar"]