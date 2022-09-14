package AOP;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class aop_info {
	@Autowired
	BasicDataSource dataSource;
	Connection con = null;
	PreparedStatement ps = null;
	String url = "";
	
		public void log_indata(){
			try {
				tools t = new tools();
				System.out.println("로그");
				aop_mapping am = new aop_mapping();
				
				System.out.println(url + "1");
				
				con = t.dbcon();
				
				String sqls = "insert into logodata values('0',?)";
				ps = con.prepareStatement(sqls);
				ps.setString(1, url);
				int n = ps.executeUpdate();
				if(n>0) System.out.println("로그성공");
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
}
