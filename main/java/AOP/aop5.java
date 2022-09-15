package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop5 {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean3.xml");
	
	@RequestMapping("/aop5.do")
	public void aop5_method() {
		aop_class5 a = ac.getBean("test1", aop_class5.class);
		aop_class5 b = ac.getBean("test2", aop_class5.class);
		aop_class5 c = ac.getBean("test2", aop_class5.class);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
