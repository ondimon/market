package ru.dimon.market.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dimon.market.config.AopConfig;
import ru.dimon.market.services.MethodCallLoggerService;
import ru.dimon.market.utils.MethodCallLogger;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LogManager.getLogger(LogAspect.class.getName());
    private final MethodCallLoggerService methodCallLoggerService;

    @Autowired
    public LogAspect(MethodCallLoggerService methodCallLoggerService) {
        this.methodCallLoggerService = methodCallLoggerService;
    }

    @Pointcut("execution(public * ru.dimon.market.controllers..*.*(..))")
    private void anyPublicMethod(){
    }

    @After("anyPublicMethod()")
    public void logAfter(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodCallLogger log = new MethodCallLogger(new Date(), signature.getDeclaringTypeName(), signature.getName());
        methodCallLoggerService.save(log);

        LOGGER.info(joinPoint.getSignature().getName());
        LOGGER.info(joinPoint.getSignature().getDeclaringTypeName());
    }

}
