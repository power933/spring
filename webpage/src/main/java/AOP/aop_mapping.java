package AOP;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//web 실행부분
@Controller
public class aop_mapping {
	String url = "";
	ApplicationContext ac = new ClassPathXmlApplicationContext("aop_logo.xml");
	@RequestMapping("/memberin.do")
	public void memberin(HttpServletRequest request)  {
		url = request.getRequestURL().toString();
		aop_query aq = ac.getBean("querys",aop_query.class);
		aop_info ai = ac.getBean("aop_info",aop_info.class);
		ai.url = url;
		try {
			aq.insert();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@RequestMapping("/memberdel.do")
	public void memberdel()  {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}









