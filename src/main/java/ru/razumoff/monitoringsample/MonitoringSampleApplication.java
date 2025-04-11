package ru.razumoff.monitoringsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class MonitoringSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringSampleApplication.class, args);
    }

}
