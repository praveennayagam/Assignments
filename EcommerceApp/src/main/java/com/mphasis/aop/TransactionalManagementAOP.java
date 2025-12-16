package com.mphasis.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class TransactionalManagementAOP {

	@Around("@annotation(org.springframework.transaction.annotation.Transactional)")
	public Object transactionAdvice(ProceedingJoinPoint pjp)throws Throwable {
		
		//beginTransactiaon();
		
		Object result=new Object();
		
		try {
			result =pjp.proceed();
			//commitTransaction();
		} catch (Throwable e) {
			
			//rollbackTransaction();
			e.printStackTrace();
		}
		return result;
		
	}
}
