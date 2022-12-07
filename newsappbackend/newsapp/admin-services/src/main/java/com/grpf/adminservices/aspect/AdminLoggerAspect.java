package com.grpf.adminservices.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
@Component
public class AdminLoggerAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before(value="execution(* com.grpf.adminservices.controller..*(..)))")
	public void beforeAllMethods(JoinPoint joinPoint) throws Throwable
	{
		joinPoint.getSignature().getName();
		logger.info("{} returned with value {}", joinPoint);
	}

	@After("execution(* com.grpf.adminservices.controller..*(..)))")
	public void afterAllMethods(JoinPoint joinPoint) throws Throwable
	{
		joinPoint.getSignature().getName();
		logger.info("after execution of {}", joinPoint);
	}

	@AfterReturning(value="execution(* com.grpf.adminservices.controller..*(..)))", returning = "result")
	public void afterReturningAllMethods(JoinPoint joinPoint, Object result) throws Throwable
	{
		joinPoint.getSignature().getName();
		logger.info("{} returned with value {}", joinPoint, result);
	}

	@AfterThrowing("execution(* com.cgi.userservice.controller..*(..)))")
	public void afterThrowingAllMethods(JoinPoint joinPoint) throws Throwable
	{
		joinPoint.getSignature().getName();
	}

}
