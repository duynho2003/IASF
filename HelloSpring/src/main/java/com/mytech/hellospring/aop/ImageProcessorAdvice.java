package com.mytech.hellospring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ImageProcessorAdvice {

	@Pointcut("execution(void com.mytech.hellospring.services.ImageProcessor.rendering())")
	public void renderImageExecution() {
	}
	
	@Pointcut("execution(* com.mytech.hellospring.services.ImageProcessor.*(..))")
	public void processImageExecution() {
	}

	@Before("renderImageExecution()")
	public void simpleLogAdvice(JoinPoint joinPoint) {
		System.out.println("ImageProcessorAdvice:simpleLogAdvice before pointcut");
		System.out.println("JointPoint: " + joinPoint.getSignature().getDeclaringTypeName() + "--"
				+ joinPoint.getSignature().getName());
	}

	@After("processImageExecution()")
	public void closeImageAdvice(JoinPoint joinPoint) {
		System.out.println("ImageProcessorAdvice:closeImageAdvice after pointcut");
		System.out.println("JointPoint: " + joinPoint.getSignature().getDeclaringTypeName() + "--"
				+ joinPoint.getSignature().getName());
	}
}
