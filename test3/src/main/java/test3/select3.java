package test3;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class select3 {

	@RequestMapping("select3.do")
	public String lombok(Model m) {
		lombok_dao ld = new lombok_dao();
		ld.setUsername("홍길동");
		ld.setUserid("홍길동");
		ld.setUserage("홍길동");
		m.addAttribute("mname",ld.getUsername());
		m.addAttribute("userid",ld.getUserid());
		m.addAttribute("userage",ld.getUserage());
		
		
		return "/view/select3";
	}
}
