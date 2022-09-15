package AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class aop7_aspect {
	
//	@Before("within(AOP.aop_class7)")
//	public void beforlog() {
//		System.out.println("AOP BEFORE 실행");
//	}
//	
//	//throwable : exception과 동일한 예외처리이며 최상위 클래스
//	@After("within(AOP.aop_class7)")
//	public void afterlog(){
//		System.out.println("AOP AFTER 실행");
//		
//	}
	
	@Around("within(AOP.aop_class7)")
	public Object aroundlog(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP 어라운드 실행");
		return jp.proceed();
	}
}
