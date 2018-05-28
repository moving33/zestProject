package com.zest.web.client.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;


@Aspect
@Component
public class AopAdvice {

	private Logger logger = LoggerFactory.getLogger(AopAdvice.class);
	
	//시작 전
	@Pointcut("execution( * com.zest.web.controller.*.*(*))")
	public void test() {}
	
	@Before("test()")
	public void beforeLog(JoinPoint joinPoint) {		
		
		//처리하는 클래스 이름 
		String className = joinPoint.getSignature().getClass().getName();
		//실행하는 메서드
		String method = joinPoint.getSignature().getName();		
		logger.info("[Class] : "+className+"/n"+"[Method] : "+method);
		System.out.println("aaaaaaaaaa");
	}

	public AopAdvice() {
		super();			
	}	
	
	
}
