package aop_master;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("aoptemp")
public class aop_daotemp implements aop_dao{
	
	public String insertsql() {
		return null;
	}
	
	@Override
	public void insertmethod() throws Exception {
		Thread.sleep(3000);
	}
	@Override
	public void updatetmethod() throws Exception {
		Thread.sleep(5000);
	}
	@Override
	public void deletemethod() throws Exception {
		Thread.sleep(4000);
	}
}
