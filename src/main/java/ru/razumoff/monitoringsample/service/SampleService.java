package ru.razumoff.monitoringsample.service;

import org.springframework.stereotype.Service;
import ru.razumoff.monitoringsample.aspect.Monitoring;

@Service
public class SampleService {

    @Monitoring(name = "get example")
    public String getExample(){
        return "Sample Service";
    }

    @Monitoring(name = "get example with delay 1000")
    public String getExampleWithDelay1000() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Delayed response (1 seconds)";
    }

    @Monitoring(name = "get example with delay 3000")
    public String getExampleWithDelay3000() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Delayed response (3 seconds)";
    }

    @Monitoring(name = "get example with error")
    public String getExampleError() {
        throw new RuntimeException("Sample Service");
    }
}
