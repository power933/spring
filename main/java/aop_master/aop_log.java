package aop_master;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.Setter;

@Setter
public class aop_log{
	String jdbcurl;
	String url;
	String username;
	String password;
	
	public Object times(ProceedingJoinPoint jp) throws Throwable {
		long start = 0;
		long end = 0;
		System.out.println(jdbcurl);
		
		try {
			
			start = System.currentTimeMillis();
			Object ob = jp.proceed();
			System.out.println(jp.getTarget().getClass().getName());
			return ob;
					
		} catch (Exception e) {
			
			throw e;
		}
		finally {
			end = System.currentTimeMillis();
			System.out.println("총 지연시간 : " + (end-start));
		}
	}
}
