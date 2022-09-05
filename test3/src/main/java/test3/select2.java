package test3;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class select2 {
	
	@Autowired
	BasicDataSource dataSource;
	//생략가능
	public void setdb(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@RequestMapping("/select2.do")
	public String dbselect2(Model m) {
		//model_dao(DAO class를 호출하면서 db정보를 DI해주는 방식
		model_dao da = new model_dao(dataSource);
		m.addAttribute("count",da.d_select());
		return "view/select2";
	}
}
