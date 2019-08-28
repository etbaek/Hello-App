package com.lsis.HelloApp;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ActionCounterAspect {
    private final Counter actionCounter;

    public ActionCounterAspect(MeterRegistry meterRegistry) {
        this.actionCounter = meterRegistry.counter("hello.actionCounter");
    }

    @Before("@annotation(IncrementCounter)")
    public void IncrementActionCounter(JoinPoint joinPoint) {
        actionCounter.increment();
    }
}
