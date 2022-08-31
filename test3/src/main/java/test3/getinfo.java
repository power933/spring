package test3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class getinfo{
	//@RequestMapping : url에 메소드를 연결시켜주는 어노테이션
	@RequestMapping("/userinfo")
	public String abc(Model model) {
		//modelandview : 배열 키값이 있는 형태로 저장하는 방식
		//model : 서버 메모리에 자료를 저장하는 방식
		String user = "홍길동";
		model.addAttribute("username",user);
		return "view/info";
		//info : prefix + info + suffix 로 잡은 경로로 보내버림
	}
}

