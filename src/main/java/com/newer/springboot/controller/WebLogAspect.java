package com.newer.springboot.controller;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect//定义成一个切面bean
@Component
@Order(5)//有多个切面时 切面执行的顺序 前置通知数字越小，越先执行，但是后置越后执行
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    //用来记录开始时间
    ThreadLocal<Long>startTime = new ThreadLocal<>();

    @Pointcut("execution(* com.*.*.controller.*.*(..))")
    public void weblog(){

    }

    @Before("weblog()")
    public void before(JoinPoint joinPoint){
        logger.info("WebLogAspect.before");
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL"+request.getRequestURI());
        logger.info("HTTP_METHOD"+request.getMethod());
        logger.info("IP"+request.getMethod());
        logger.info("CLASS_TYPE"+joinPoint.getSignature().getDeclaringType()+""+joinPoint.getSignature().getName());//调用controller中的方法花费了多少时间
        logger.info("Parameter"+Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "weblog()")
    public void after(Object ret){
        logger.info("WebLogAspect.after");
        logger.info("RETURING:"+ret);
        //logger.info("CLASS_TYPE"+joinPoint.getSignature().getDeclaringType()+""+joinPoint.getSignature().getName());//调用controller中的方法花费了多少时间
        logger.info("SPEND TIME"+(System.currentTimeMillis()-startTime.get()));
    }
}
