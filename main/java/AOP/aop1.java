package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop1 {

	@RequestMapping("/aop1.do")
	public String aop(Model m) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		aop_class1 z =(aop_class1)ac.getBean("aa");
		String zresult = z.test();

		m.addAttribute("result",zresult);
		return "aop1";
	}
}



