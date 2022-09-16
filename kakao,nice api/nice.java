package webpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class nice {

	private String username= "";
	private String usertel = "";
	
	@RequestMapping(value="/nice_joinok.do" ,produces = "text/html;charset=utf-8", method=RequestMethod.POST)
	public String nice_method(Model m,String username, String usertel) {
		
		this.username = username;
		this.usertel = usertel;
		
		m.addAttribute("username",this.username);
		m.addAttribute("usertel",this.usertel);
		
		return "nice_check";
	}
}
