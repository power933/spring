package aop_master;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

public class aop_servicetemp implements aop_service {
	public aop_dao dao1;
	
	@Override
	public String insertdb(String data) throws Exception {
//		String aa = "insert into imgs values('0','"+data+"')";
//		Connection con = null;
//		PreparedStatement ps = con.prepareStatement(aa);
//		System.out.println(ps+"1");
//		System.out.println(ps.toString()+"2");
		return null;
	}
	
	@Override
	public String deletedb(String a) throws Exception {
		
		
		return null;
	}
	
	@Override
	public void setDao1(aop_dao dao) {
		this.dao1 = dao;
		
	}
	@Override
	public void modify() throws Exception {
//		dao1.updatetmethod();
//		dao1.deletemethod();
	}
	@Override
	public void register() throws Exception {
//		dao1.insertmethod();
	}
	
}
