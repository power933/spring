package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop7 {
	@RequestMapping("aop7.do")
	public void aop7_method() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop7.xml");
		aop_class7 aa = ac.getBean("core",aop_class7.class);
		aa.aop_test(5);
		aa.aop_test(-5);
		System.out.println("데이터입력완");
		
	}
}
