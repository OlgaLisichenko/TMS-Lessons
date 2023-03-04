package org.tms.racing_bets.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("@annotation(org.tms.racing_bets.aop.MyBenchmark)")
    public void pointCutForBenchmark() {}

    @Around("pointCutForBenchmark()")
    public void runAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("\n-----------Start time: " + startTime + "-----------");

        joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("-----------End time: " + startTime + "-----------");
        int duration = (int) ((endTime - startTime) / 1000);
        System.out.println("------------Duration: " + duration + " seconds-------------");
    }
}