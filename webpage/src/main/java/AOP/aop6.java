package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop6 {

	ApplicationContext ac = new ClassPathXmlApplicationContext("aop1.xml");
	
	@RequestMapping("member_insert.do")
	public void member_insert() throws Exception{
		aop_class6 ac6 = ac.getBean("member",aop_class6.class);
		long start = System.currentTimeMillis();
		Thread.sleep(3000);
		ac6.memberdel();
		long end = System.currentTimeMillis();
		ac6.memberin();
		ac6.memberinfo();
		ac6.memberlogin();
		ac6.memberupdate();
		System.out.println(end-start);
	}
	
}
