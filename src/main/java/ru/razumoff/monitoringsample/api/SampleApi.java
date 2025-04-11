package ru.razumoff.monitoringsample.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getExample/withDelay/{delay}")
    public String getExampleWithDelay(@PathVariable int delay) {
        return sampleService.getExampleWithDelay(delay);
    }

    @GetMapping("/getExample/error")
    public String getExampleError() {
        return sampleService.getExampleError();
    }
}
