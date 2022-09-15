package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop2 {
	@RequestMapping("aop2.do")
	public void aopbox() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		aop_class2 ac2 = ac.getBean("bb",aop_class2.class);
		System.out.println(ac2.getBox1());
	}
}
