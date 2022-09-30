package payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
	
	@RequestMapping("test.do")
	public String login(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		
		String mid = "kim";
		String mname = "김유신";
		session.setAttribute("mid", mid);
		session.setAttribute("mname", mname);
		
		return "test";
	}
	
}
