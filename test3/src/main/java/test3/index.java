package test3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class index implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		dbservice ds = new dbservice("hong", "a123456", "이순신", "01022224444", "25");
		listdb lb = new listdb();
		
		mv.addObject("msg",lb.insert(ds));
		mv.setViewName("index.jsp");
		
		return mv;
	}
	
}
