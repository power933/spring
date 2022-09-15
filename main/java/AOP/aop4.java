package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop4 {
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
	aop_person ap = (aop_person)ac.getBean("person");
	aop_class4 ap4 = ac.getBean("aop4",aop_class4.class);

	@RequestMapping("/aop4.do")
	public void qwe() {
		System.out.println(ap4.getListdata().get(ap.getLevel()));
		
	}
}
