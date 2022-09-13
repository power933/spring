package AOP;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class aop_class1 {
	public String test() {
		String data = "홍길동";
		return data;
	}
	
	public int testbox() {
		
		int data = 10;
		
		return data;
	}
}
