package ru.razumoff.monitoringsample.monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MonitoringMethodType {
    EXAMPLE_METHOD(
            "example method",
            "Пример метода: /api/getExample"
    ),
    EXAMPLE_METHOD_WITH_DELAY(
            "example method with delay",
            "Метод с задержкой: /api/getExample/withDelay/{delay}"
    ),
    EXAMPLE_METHOD_WITH_ERROR(
            "example method with error",
            "Метод возвращает ошибку: /api/getExample/error"
    );

    private final String name;
    private final String description;

}
