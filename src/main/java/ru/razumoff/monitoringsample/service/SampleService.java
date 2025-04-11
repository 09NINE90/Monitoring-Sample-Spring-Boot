package ru.razumoff.monitoringsample.service;

import org.springframework.stereotype.Service;
import ru.razumoff.monitoringsample.monitoring.Monitoring;
import ru.razumoff.monitoringsample.monitoring.MonitoringMethodType;

@Service
public class SampleService {

    @Monitoring(name = MonitoringMethodType.EXAMPLE_METHOD)
    public String getExample(){
        return "Sample Service";
    }

    @Monitoring(name = MonitoringMethodType.EXAMPLE_METHOD_WITH_DELAY)
    public String getExampleWithDelay(int delay) {
        try {
            Thread.sleep(delay * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return String.format("Delayed response (%d seconds)", delay);
    }

    @Monitoring(name = MonitoringMethodType.EXAMPLE_METHOD_WITH_ERROR)
    public String getExampleError() {
        throw new RuntimeException("Sample Service");
    }
}
