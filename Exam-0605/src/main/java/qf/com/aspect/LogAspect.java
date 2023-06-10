package qf.com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger("ssm-book");


    /**
     * 返回通知
     */
    /*@AfterReturning(pointcut = "execution(* io.ukoko.controller.*.*(..))",returning = "obj")
    public void logAdvice(Object obj, JoinPoint joinPoint){
        LOGGER.info("方法名称为:{}-->> 方法入参为:{} --> 方法返回值为:{}",joinPoint.getSignature().getName(), joinPoint.getArgs()==null?"无参": Arrays.asList(joinPoint.getArgs()),obj);
    }*/

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* qf.com.controler.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        LOGGER.info("方法名称为:{}-->> 方法入参为:{} --> 方法返回值为:{}",joinPoint.getSignature().getName(), joinPoint.getArgs()==null?"无参": Arrays.asList(joinPoint.getArgs()),proceed);
        return proceed;
    }

}
