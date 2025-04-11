package ru.razumoff.monitoringsample.monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MonitoringMethodType {
    EXAMPLE_METHOD(
            "Example: /api/getExample"
    ),
    EXAMPLE_METHOD_WITH_DELAY(
            "Example with delay: /api/getExample/withDelay/{delay}"
    ),
    EXAMPLE_METHOD_WITH_ERROR(
            "Example return error: /api/getExample/error"
    );

    private final String description;

}
