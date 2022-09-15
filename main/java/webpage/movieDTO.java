package webpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("moviedto")
public class movieDTO {
	
	@Resource(name="sqlTemp")
	private SqlSessionTemplate session;	
	//movie_api2에서 opensession에 대한 정보값
	
	public List<movieDAO> list(String date1, String date2){
		Map map = new HashMap();
		map.put("value1", date1);
		map.put("value2", date2);
		
		List<movieDAO> apidata = session.selectList("sql.select_api",map);
		
		return apidata;
	}
}
