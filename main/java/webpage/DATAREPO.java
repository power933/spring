package webpage;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("dataRepo")
public class DATAREPO {
	
	@Resource(name="sqlTemp")
	private SqlSessionTemplate temp;
	
	public dataDAO select_test() {
		dataDAO t = temp.selectOne("sql.select_test");
		return t;
	}
	
	public List<dataDAO> select_all(){
		List<dataDAO> list = temp.selectList("sql.select_all");
		return list;
	}
}
