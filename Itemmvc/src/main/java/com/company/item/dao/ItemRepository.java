package com.company.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.item.domain.ItemDTO;

//클래스에 @component 를 설정하면 servlet-context.xml파일의
//component-scan에 설정된 패키지에 속한 경우 bean을 자동으로 생성합니다.
//@repostory,@service,@controller를 기재하면 역할까지 부여함

//@Repository
public class ItemRepository {
	
	@Autowired
	SqlSession sqlSession;
	
	private String ns = "itemmapper.";
	//테이블에 전체 데이터를 가져오는 메소드
	public List<ItemDTO> getAll() {
		
		return sqlSession.selectList(ns+"getall");
	}
	public ItemDTO getItem(Integer itemid) {
		return sqlSession.selectOne(ns+"getitem",itemid);
	}
	
	
}
