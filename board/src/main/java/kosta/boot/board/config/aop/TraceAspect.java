package kosta.boot.board.config.aop;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.config.trace.LogTrace;
import kosta.boot.board.config.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class TraceAspect {

    private final LogTrace logTrace;

//
//    @Before("@annotation(kosta.boot.board.config.annotation.Trace)")
//    public void doTrace(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        log.info("[trace] {} args={}", joinPoint.getSignature(), args);
//    }




    @Around("@annotation(kosta.boot.board.config.annotation.Trace)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;
        Object result = null;

        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);

            result = joinPoint.proceed();
            logTrace.end(result, status);
            return result;
        } catch (Exception e) {
            logTrace.exception(result, status, e);
            throw e;
        }

    }
}
