package webpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movie_api2 {
	
	String apikey = "";
	String apidate = "";
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Resource(name="moviedto")
	private movieDTO dto;
	
	@RequestMapping(value="movie_api" ,produces="text/html; charset=utf-8",method=RequestMethod.GET)
	public void apidata(String apikey, String apidate, Model m, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		this.apikey = apikey;
		this.apidate = apidate;
		PrintWriter out = resp.getWriter();
		
		if(this.apikey.equals("power933") && !this.apidate.equals("")) {
			String date1 = this.apidate + " 00:00:00";
			String date2 = this.apidate + " 23:59:59";
			
			SqlSession session = sqlSessionFactory.openSession();
			List<movieDAO> apidata = dto.list(date1,date2);
			
			int w = 0;
			System.out.println(apidata);
			JSONArray ja = new JSONArray();
			while(w<apidata.size()) {
				JSONObject jo = new JSONObject();
				jo.put("arank", apidata.get(w).getArank());
				jo.put("arankpart", apidata.get(w).getArankpart());
				jo.put("aperson", apidata.get(w).getPerson());
				jo.put("anm", apidata.get(w).getAnm());
				ja.add(jo);
				w++;
			}
			out.print(ja.toString());
		}
		else {
			out.print("error:32");         
		}
		
	}
}
