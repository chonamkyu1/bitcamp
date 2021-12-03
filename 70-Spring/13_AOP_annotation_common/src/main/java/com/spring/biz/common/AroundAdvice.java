package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;


// (실습) AOP 관련 어노테이션 설정
// @Aspect, @Pointcut, @Around
public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[Around BEFORE] 실행전 로그");
		Object returnObj =  pjp.proceed();
		System.out.println("[Around AFTER] 실행후 로그");
		
		return returnObj;
	}
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {
	}

	@Pointcut("execution(* com.spring.biz..get*Impl.*(..))")
	public void getPointcut() {
	}
	
	
}
