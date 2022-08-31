package test3;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class api {

//	@RequestMapping("/check_page.do")
//	public void postck(Model m,@ModelAttribute ck ck, HttpServletResponse resp) {
//		//HttpServletResponse : 외부서버에 값을 전달하기 위해 사용
//		String result="";
//		if(ck.getSecurity().equals("a123456")) {
//			result = "ok";
//		}
//		else {
//			result = "cancel";
//		}
//		m.addAttribute("result",result);
//		String url = "http://192.168.100.209:8080/test3/result.jsp?result="+result;
//		try {
//			resp.sendRedirect(url);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	//@requestparam : 받는 변수값을 다른 변수명으로 변환할 때 사용
	@RequestMapping("dataload.do")
	public String da(Model m, @RequestParam("users") String users2) {
		String callsign = users2;
		String call="";
		if(callsign.equals("hong")) {
			call = "ok";
		}
		else {
			call="no";
		}
		m.addAttribute("call",call);
		return "view/result";
	}
	
}








