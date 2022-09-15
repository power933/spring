package webpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movie_api {

	@Autowired
	BasicDataSource dataSource;
	
	String apikey = "";
	String apidate = "";
	
	@RequestMapping(value="movie" ,produces="text/html; charset=utf-8",method=RequestMethod.GET)
	public String asd(String apikey, String apidate, HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		this.apidate = apidate;
		this.apikey = apikey;
		String msg = "";
		ServletOutputStream out = resp.getOutputStream();
		JSONArray ja = new JSONArray();
		try {
			if(apikey == null || apikey.equals("")) {
				if(apidate == null || apidate.equals("")) {
					msg = "<script>alert('올바르지 못한 접근입니다.');</script>";
				}
			}
			else if(!apikey.equals("") && !apidate.equals("")) {
				Connection con = dataSource.getConnection();
				String sql = "select * from apimovie where aindate like ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, apidate+"%");
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					JSONObject jb = new JSONObject();
					jb.put("aidx", rs.getString("aidx"));
					jb.put("arank", rs.getString("arank"));
					jb.put("arankpart", rs.getString("arankpart"));
					jb.put("person", rs.getString("aperson"));
					jb.put("anm", rs.getString("anm"));
					jb.put("aindate", rs.getString("aindate"));
					ja.add(jb);
				}
				msg = String.valueOf(ja);
			}
			
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
		
		return msg;
	}
	
}
