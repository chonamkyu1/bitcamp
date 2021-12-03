package com.spring.biz.common;

import org.aspectj.lang.annotation.Pointcut;
// 실습 AOP 관련 어노테이션 설정
// @Aspect, @Pointcut, @After
public class AfterAdvice {
	public void afterLog() {
		System.out.println("[후처리 - AgterAdvice.afterLog] 실행 후 로그(무조건, 언제나)");
	}
	
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {
	}

	@Pointcut("execution(* com.spring.biz..get*Impl.*(..))")
	public void getPointcut() {
	}
	
	
}
