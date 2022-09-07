package webpage;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//view와 controller 형태를 같이 사용하는 사항

@Controller
public class controller1 {
	//responseBody : Controller에서 mapping을 사용하더라도 해당 자바에서 웹페이지로 결과값을 바로 출력
	@ResponseBody	
	@GetMapping("controller")
	public String test1() {
		
		return "ok";
	}
	@GetMapping("controller_web")
	public String test2() {
		
		return "ok";
	}
}
//rest : 배열, 각종 정보를 출력하는 아키텍쳐 형태로 구현하는 웹 서비스
@RestController
class controller2{
	@GetMapping(value="/controller2", produces = "application/json; charset=utf8")
	public String test2() {
		//JSONObject : 배열 라이브러리 클래스
		JSONObject jb = new JSONObject();
		//데이터 DI 
		jb.put("idx", 1);
		jb.put("name", "한산");
		jb.put("person", "이순신");
		jb.put("person2", "거북선");
		//해당 값을 배열로 생성하게 됨
		String json_parsing = jb.toString();
		
		return json_parsing;	//생성된값을 아키텍쳐 웹에 출력
	}
}