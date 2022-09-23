package com.memely.memely.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailNotifications {

    @After("execution(* com.memely.memely.service.AuthService.createUserDetails(..))")
    public void logBeforeAllMethodCall(JoinPoint joinPoint) throws Throwable {
        System.out.println("*** Just Joined In " + joinPoint.getSignature().getName()+ " ***"); 
    }
    
}
