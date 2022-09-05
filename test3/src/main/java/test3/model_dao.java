package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class model_dao {
	//xml에 있는 id값을 model에서 직접적으로 핸들링 할 수 없습니다.
	@Autowired	//ioc에 등록된 bean에 대한 id값을 가져와서 사용하는 형태
	BasicDataSource dataSource;
	Connection con = null;
	PreparedStatement ps = null;
	public model_dao(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	public String d_select() {
		String ct = "";
		try {
			String sql = "select count(*) as cnt from test3";
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ct = rs.getString("cnt");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ct;
	}
	
	
	
	private String midx;
	private String mid;
	private String mpw;
	private String mnm;
	private String mtel;
	private String mage;
	
	
	public String getMidx() {
		return midx;
	}
	public void setMidx(String midx) {
		this.midx = midx;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMnm() {
		return mnm;
	}
	public void setMnm(String mnm) {
		this.mnm = mnm;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMage() {
		return mage;
	}
	public void setMage(String mage) {
		this.mage = mage;
	}
	
}
