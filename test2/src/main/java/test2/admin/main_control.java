//test2라는 패키지에 admin이라는 패키지를 포함시킴
//실제 view 파트와 동일한 디렉토리를 가지게 됩니다.
package test2.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class main_control implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView("admin/main");
		//ModelAndView(로드할 view파일명 및 디렉토리 설정)
		//class명과 view이름이 다를 때 사용
		return mv;
	}
}
