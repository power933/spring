package webpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class test {
	public static void main(String[] args) {
		String v = org.springframework.core.SpringVersion.getVersion();
		
	}
}

@Controller
class testweb {
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Resource(name="dataRepo")
	private DATAREPO repo;
	
	@Autowired
	BasicDataSource dataSource;
	
	@RequestMapping("test.do")
	public String abc() {
		SqlSession s = sqlFactory.openSession();
		List<dataDAO> result = repo.select_all();
		System.out.println(result.get(0).getMid());
		return "test";
	}

}

