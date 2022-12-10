package com.blog.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {


    @Pointcut("@annotation(com.blog.annotation.SystemLog)")
    public void pt(){

    }
}
