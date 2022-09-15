package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop_test {
	@RequestMapping("atest.do")
	public void name() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("MEB-INF/test.xml");
		aop_classt ac1 = (aop_classt)ac.getBean("aa");
		ac1.setName("김옥자");
		ac1.setPrice(2500);
		System.out.print(ac1.getName()+"님의 포인트는"+ac1.getPrice()+"입니다.");
	}
}
