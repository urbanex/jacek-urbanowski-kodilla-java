package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderFacadeWatcher {
    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEventBefore() {
        OrderFacade.getLOGGER().info("PROCESSING ORDER IN PROGRESS...");
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
            OrderFacade.getLOGGER().info("ORDER SUCCEEDED!");
        } catch (Throwable throwable) {
            OrderFacade.getLOGGER().error("ORDER FAILED: " + throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
