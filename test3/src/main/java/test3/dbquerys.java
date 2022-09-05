package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dbquerys {
//	DI : (dependency injection) - web.xml
	//ioc : (객체에 따른 의존성 메소드 호출) - bean과 연계
	//DAO(data access object) 객체생성(게터,세터) : CRUD
	//DTO(data transfer object) 계층간 데이터교환 : 읽기
	
	@Autowired	//ioc에 등록된 bean에 대한 id값을 가져와서 사용하는 형태
	BasicDataSource dataSource;
	Connection con = null;
	PreparedStatement ps = null;
	tools t = new tools();
	
	@RequestMapping("/insert.do")
	public String dbinsert(Model m) throws Exception {
//		con = dataSource.getConnection();
//		String sql = "insert into test3 values('0',?,?,?,?,?)";
//		String msg = "error";
//		
//		ps = con.prepareStatement(sql);
//		ps.setString(1, "park");
//		ps.setString(2, "c1234567");
//		ps.setString(3, "박찬호");
//		ps.setString(4, "01012345678");
//		ps.setString(5, "35");
//		int x = ps.executeUpdate();
//		if(x>0) {
//			msg = "ok";
//		}
//		m.addAttribute("result",msg);
		return "view/insert";
	}
	
	@RequestMapping("/select.do")
	public String db_select(Model m){
		ArrayList<model_dao> list = new ArrayList<model_dao>();
		try {
			con = dataSource.getConnection();
			String sql = "select * from test3";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Map<String,Object>> pso = new ArrayList<Map<String,Object>>();
			int i = 0;
			while(rs.next()) {
				Map<String,Object> mp = new HashMap<String, Object>();
				mp.put("midx", rs.getString("midx"));
				mp.put("mid", rs.getString("mid"));
				mp.put("mpw", rs.getString("mpw"));
				mp.put("mnm", rs.getString("mnm"));
				pso.add(mp);
			}
			m.addAttribute("list",pso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return "view/select";
	}
	
}









