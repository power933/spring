package aop_master;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop_controller {
	ApplicationContext ac = new ClassPathXmlApplicationContext("aopmaster.xml");
	aop_service as = ac.getBean("service_class1",aop_service.class);
	
	@Autowired
	private BasicDataSource dataSource;
	
	@RequestMapping("/aop11.do")
	public void aop() {

		
		System.out.println("웹 프로그램 실행1");
		try {
			Connection con = dataSource.getConnection();
			String sql = as.insertdb("./review/aop.jpg");
			
			PreparedStatement ps = con.prepareStatement(sql);
			as.modify();
			System.out.println("웹 프로그램 실행2");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
