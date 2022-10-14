package com.company.item;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.item.dao.ItemRepository;
import com.company.item.domain.ItemDTO;

//테스트를 위한 클래스를 로드
//JUnit - Java의 단위테스트를 위한 라이브러리
@RunWith(SpringJUnit4ClassRunner.class)
//설정 파일을 읽어옴
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class ItemTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testconnect() {
		
		ItemDTO it = new ItemDTO();
		it = 
				ItemDTO.builder()
				.itemid(1)
				.build();
//		System.out.println(it.toString());
		
		try(Connection con = dataSource.getConnection()){
//			System.out.println(con);
		}
		catch (Exception e) {
//			System.out.println(e);
		}
	}
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test2() {
//		System.out.println(sqlSession);
	}
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void testGetAll() {
		System.out.println(itemRepository.getAll());
	}
	
	
}










