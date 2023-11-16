package com.gmail.merikbest.ecommerce.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerAspect {

    @Pointcut(value = "execution(* com.gmail.merikbest.ecommerce.controller.*.*(..))")
    public void executeLogging(){
    }

    @Around("executeLogging()")
    public Object loggingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        String clasName = "CLASS: [" + joinPoint.getTarget().getClass().getSimpleName() + "],";
        String methodName = "METHOD: [" + joinPoint.getSignature().getName() + "()],";
        System.out.print(clasName + methodName + "REQUEST: ");
        if(joinPoint.getArgs().length > 0){
            Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        }else {
            System.out.println("[]");
        }
        System.out.println(clasName + methodName + " RESPONSE: " + proceed.toString());
        return proceed;
    }
}
