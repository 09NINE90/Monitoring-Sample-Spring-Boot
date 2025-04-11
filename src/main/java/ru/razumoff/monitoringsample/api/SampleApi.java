package ru.razumoff.monitoringsample.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.razumoff.monitoringsample.service.SampleService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleApi {

    private final SampleService sampleService;

    @GetMapping("/getExample")
    public String getExample() {
        return sampleService.getExample();
    }

    @GetMapping("/getExample/withDelay/1000")
    public String getExampleWithDelay1000() {
        return sampleService.getExampleWithDelay1000();
    }

    @GetMapping("/getExample/withDelay/3000")
    public String getExampleWithDelay3000() {
        return sampleService.getExampleWithDelay3000();
    }

    @GetMapping("/getExample/error")
    public String getExampleError() {
        return sampleService.getExampleError();
    }
}
