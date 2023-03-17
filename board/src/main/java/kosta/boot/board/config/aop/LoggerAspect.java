package kosta.boot.board.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* kosta.boot..controller.*Controller.*(..)) || execution(* kosta.boot..service.*Impl.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();


        if (name.contains("Controller") == true) {
            type = "Controller ===> ";
        } else if (name.contains("Service") == true) {
            type = "ServiceImpl ===> ";
        } else if (name.contains("Mapper") == true) {
            type = "Mapper ===> ";
        }
        log.info(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }


}




