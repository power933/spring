package AOP;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

//각종 쿼리
public class aop_query {
	
	@Autowired
	BasicDataSource dataSource;
	Connection con = null;
	PreparedStatement ps = null;

	public void insert()  {
		tools t = new tools();
		try {
			con = t.dbcon();
			String mid = "jung";
			String pass = "a123456";
			String pass2 = DigestUtils.md5DigestAsHex(pass.getBytes());
			String mnm = "정경호";
			String mtel = "01022516697";
			String mage = "37";
			
			String sqls = "insert into test3 values('0',?,?,?,?,?)";
			
			
			ps = con.prepareStatement(sqls);
			ps.setString(1, mid);
			ps.setString(2, pass2);
			ps.setString(3, mnm);
			ps.setString(4, mtel);
			ps.setString(5, mage);
			int n = ps.executeUpdate();
			if(n>0) System.out.println("회원가입이 완료되었습니다");
			
		} catch (Exception e) {
			System.out.println(e + ":"+"11");
			e.printStackTrace();
		}
		
	}
}
