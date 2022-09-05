package test3;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class select4 {
	Connection con = null;
	@Inject
//	private DataSource dataSource;
	private SqlSessionFactory sqlFactory;
	
	
	@RequestMapping("/select4.do")
	public String homepage(Model m) {
		try {
//			con = dataSource.getConnection();
			SqlSession session = sqlFactory.openSession();
			System.out.println("연결완");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "view/select4";
	}
}
