package ru.razumoff.monitoringsample.monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MonitoringMethodType {
    EXAMPLE_METHOD(
            "Example: /api/getExample"
    ),
    EXAMPLE_METHOD_WITH_DELAY_1000(
            "Example with delay 1 second: /api/getExample/withDelay/1000"
    ),
    EXAMPLE_METHOD_WITH_DELAY_3000(
            "Example with delay 3 seconds: /api/getExample/withDelay/3000"
    ),
    EXAMPLE_METHOD_WITH_ERROR(
            "Example return error: /api/getExample/error"
    );

    private final String description;

}
