package test3;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//xml + controller + model
@Repository("xmlj")	//해당 메소드 모두를 시스템 메모리 저장소에 기억시킴
public class xmljava {
	
	//@autowired : 특정값을 입력 받아 처리가 가능한 템플릿
	//@Resource : 전체에 대한 템플릿만 이용
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	//xml에서 사용하는 id값이 중복 또는 오타가 발생할 경우 연결되지 않습니다
	//selectOne : 한개의 데이터만 가져올 떄 사용, selectList: 여러개
	
	
	
	public List<uservo> selectall(){
		List<uservo> userlist = session.selectList("userDB.selectall");
		
		return userlist;
	}
	
	public List<uservo> selectid(String id) {
		List<uservo> user = session.selectList("userDB.selectid",id);
		
		return user;
	}
	
	public List<uservo> selectage(int age) {
		List<uservo> user = session.selectList("userDB.selectage",age);
		//session.selectList("연결 id",전송값);
		return user;
	}
	public String userinsert(String mid,String mpw,String mname,String mtel,String mage) {
		
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMage(mage);
		vo.setMtel(mtel);
		vo.setMnm(mname);
		session.insert("userDB.userinsert",vo);
		
		String sign = "ok";
		
		return sign;
	}
	public String userupdate(String mid, String mpw, String mname) {
		
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMnm(mname);
		session.update("userDB.userupdate",vo);
		return "OK";
	}
	
	public String userdelete(String mid, String mpw, String mnm) {
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMnm(mnm);
		session.delete("userDB.userdelete",vo);
		return "ok";
	}
	
}









