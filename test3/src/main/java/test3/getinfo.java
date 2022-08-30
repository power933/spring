package test3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class getinfo implements Controller{
	
	/*
	 mapping을 사용하는 이유는 컨트롤러를 통합하여
	 별도의 view가 필요없이 사용할 때 이용하게 됩니다.
	 view 1개 + 컨트롤러 1개 -> 다수의  class파일들 
	 */

//	@GetMapping("/data") //GET 데이터를 
	@RequestMapping(value="/t1", method = RequestMethod.GET)
	public String test01_get() {
		return "getinfo/t1";
	}
//	@GetMapping("/data")	//post 데이터를 받음
	@RequestMapping(value="/t1", method = RequestMethod.POST)
	public String test02_post() {
		return "getinfo/t1";
	}
	@Override	//view에 값을 던져주는 역할
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getinfo.jsp");
		
		return mv;
	}
}
