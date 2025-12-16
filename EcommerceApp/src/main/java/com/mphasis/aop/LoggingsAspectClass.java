package com.mphasis.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingsAspectClass {
	private static final Logger logger=LoggerFactory.getLogger(LoggingsAspectClass.class);
	
	@Pointcut("execution(* com.mphasis.controller.*.*(..))")
	public void controllerLayer() {}
	
	@Pointcut("execution(* com.mphasis.service.*.*(..))")
	public void serviceLayer() {}
	
	@Pointcut("execution(* com.mphasis.dao.*.*(..))")
	public void daoLayer() {}
	
	@Pointcut("execution(* com.mphasis.exceptions.*.*(..))")
	public void exceptionLayer() {}
	
	@Pointcut("execution(* com.mphasis.repository.*.*(..))")
	public void repositoryLayer() {}
	
	@Before("controllerLayer() || serviceLayer() || daoLayer()" )
	public void beforeEachMethod(JoinPoint joinPoint)
	{
		logger.info("Start -> {}",joinPoint.getSignature());
	}
	
	
//	@Before("execution(* com.mphasis.*.*.*(..))" )
//	public void beforeEachMethod(JoinPoint joinPoint)
//	{
//		logger.info("Start -> {}",joinPoint.getSignature());
//	}

	@After("controllerLayer() || serviceLayer() || daoLayer()")
	public void afterEachMethod(JoinPoint joinPoint)
	{
		logger.info("End -> {}",joinPoint.getSignature().getName());
	}
	
	
	@AfterReturning(pointcut="controllerLayer() || serviceLayer() || daoLayer() || repositoryLayer()",returning="result")
	public void afterReturningEachMethod(JoinPoint joinPoint,Object result)
	{
		logger.info("Result -> {}",result);
	}
	
	@AfterThrowing(pointcut="controllerLayer() || serviceLayer() || daoLayer() ||exceptionLayer() ||repositoryLayer()",throwing ="ex")
	public void afterExceptionThrown(JoinPoint joinPoint, Exception ex)
	{
		logger.error("ERROR-> {}",joinPoint.getSignature()+"Exception -> {}",ex.getMessage());
	}
}
