package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class listdb {
	
	Connection con = null;
	
	public String insert(dbservice dbservice) throws SQLException, ClassNotFoundException {
		String result = "";
		String mid = dbservice.mid;
		String mpw = dbservice.mpw;
		String usernm = dbservice.usernm;
		String tel = dbservice.tel;
		String age = dbservice.age;
		String sql = "insert into test3 values('0',?,?,?,?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://umj7-009.cafe24.com/power933","power933","so9332650!@");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mid);
		ps.setString(2, mpw);
		ps.setString(3, usernm);
		ps.setString(4, tel);
		ps.setString(5, age);
		
		int a = ps.executeUpdate();
		if(a>0) {
			result = "ok";
		}
		else {
			result = "no";
		}
		ps.close();
		con.close();
		
		return result;
				
	}
}
