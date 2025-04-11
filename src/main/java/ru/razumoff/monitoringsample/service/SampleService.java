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

    @Monitoring(name = MonitoringMethodType.EXAMPLE_METHOD_WITH_DELAY_1000)
    public String getExampleWithDelay1000() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Delayed response (1 seconds)";
    }

    @Monitoring(name = MonitoringMethodType.EXAMPLE_METHOD_WITH_DELAY_3000)
    public String getExampleWithDelay3000() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Delayed response (3 seconds)";
    }

    @Monitoring(name = MonitoringMethodType.EXAMPLE_METHOD_WITH_ERROR)
    public String getExampleError() {
        throw new RuntimeException("Sample Service");
    }
}
