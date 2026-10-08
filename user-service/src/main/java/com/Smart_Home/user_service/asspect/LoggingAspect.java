package com.Smart_Home.user_service.asspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(*com.sudhanshu.user_service.service.*.*(..))")
    public void serviceMethod(){}

    @Before("serviceMethod()")
    public void logBefore(JoinPoint jointPoint){
      log.info("Called service method: {} with argument: {}",
              jointPoint.getSignature().getName(),jointPoint.getArgs());
    }

    @AfterReturning(pointcut = "serviceMethods()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        log.info("Service method: {} , returned: {}",joinPoint.getSignature().getName(),result);
    }

}
