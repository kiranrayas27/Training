package com.msedcl.main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

//@Component
@Aspect
public class LoggingAspect {
	@Pointcut("execution(void com.msedcl.main.service.UserService.createUser(String))")
	public void logging() {
	}
	
	@Before("logging()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("[Before] advice called for method :: "+joinPoint.getSignature().getName());
	}
	
	@After("execution(void com.msedcl.main.service.UserService.createUser(String))")
	public void logAfter() {
		System.out.println("[After advice called]");
	}
	
	@Around("logging()")
	public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		proceedingJoinPoint.proceed();
		System.out.println("[Around] advice called for method execution ");
	}
}
