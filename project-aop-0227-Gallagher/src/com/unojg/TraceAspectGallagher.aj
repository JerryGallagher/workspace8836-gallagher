package com.unojg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public aspect TraceAspectGallagher {
	@Before("call(* com.unojg.*App.getName(..))")
  	public void logSourceLocation(JoinPoint thisJoinPoint) {
		System.out.println("[BGN]" + thisJoinPoint.getSignature() + ", "+ thisJoinPoint.getSourceLocation().getLine());
		//System.out.println(thisJoinPoint + " -> " + thisJoinPoint.getSignature());
		//System.out.println(thisJoinPoint + " -> " + thisJoinPoint.getSourceLocation().getLine());
    
  	}
	@AfterReturning("execution(* com.unojg.*App.*(..))")
	public void afterSuccesfulReturn(JoinPoint thisJoinPoint) {
		System.out.println("[END]" + thisJoinPoint.getSourceLocation().getFileName());
		//System.out.println(thisJoinPoint + " -> " + thisJoinPoint.getSourceLocation().getFileName());
	}
}
	
