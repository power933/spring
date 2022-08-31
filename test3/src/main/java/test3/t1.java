package test3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class t1 {
	@RequestMapping("/notice")
	public String n(HttpServletRequest req) {	//servlet 형태로 mapping
		String msg = "게시판 공지사항 내용 출력";
		req.setAttribute("msg", msg);
		
		return "view/dataview";
	}
	@RequestMapping("/notice_write")	//model 형태로 mapping
	public String x(Model model) {
		String msg = "게시판 글쓰기 페이지";
		model.addAttribute("msg",msg);
		return "view/dataview";
	}
	@RequestMapping("/sum")
	public String sums(Model model, int a, int b) {
		//해당 파라미터가 없을 경우 오류 발생
		int data1 = a+b;
		model.addAttribute("msg",data1);
		
		return "view/dataview";
	}
	
	@RequestMapping("/login.do")
	public String indata() {	//view만 사용(model X)
		return "view/indata";
	}
	//아이디 찾기 mapping 및 class 주소
	//ModelAttribute : 값이 전송이 되면 object 형태로 매핑하게 해줌
	//매핑 형태는 해당 class를 로드한 후 변수값과 전송된 값을 비교하여 자동으로 매칭시켜 줍니다
	//SessionAttribute : Session
	@RequestMapping("/loginok.do")
	public String searchid(Model m, @ModelAttribute login login) {
		String userid = "";
		if(login.getUsernm().equals("홍길동")&&login.getUseremail().equals("hong@nate.com")) {
			userid = "hong123";
		}
		else {
			userid="해당 아이디는 찾을 수 없습니다";
		}
		m.addAttribute("userid", userid);
		m.addAttribute("useremail", login.getUseremail());
		m.addAttribute("usernm", login.getUsernm());
		return "view/result";
	}
	
}








