package ru.razumoff.monitoringsample.aspect;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {

    private final MeterRegistry meterRegistry;

    public MonitoringAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Around("@annotation(monitoring)")
    public Object monitor(ProceedingJoinPoint pjp, Monitoring monitoring) throws Throwable {
        Timer.Sample sample = Timer.start(meterRegistry);

        String status = "success";
        String exceptionName = "none";

        try {
            return pjp.proceed();
        } catch (Exception e) {
            status = "error";
            exceptionName = e.getClass().getSimpleName();
            throw e;
        } finally {
            sample.stop(Timer.builder(monitoring.name())
                    .description("Time spent in method")
                    .tag("class", pjp.getTarget().getClass().getSimpleName())
                    .tag("method", pjp.getSignature().getName())
                    .tag("status", status)
                    .tag("exception", exceptionName)
                    .register(meterRegistry));
        }

    }
}