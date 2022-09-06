package test3;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class select4 {
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Resource(name="xmlj")
	private xmljava xmlj;
	
	@RequestMapping("/select5.do")
	public String insertmb(Model m,String mid,String mpw,String mname,String mtel,String mage) {
		System.out.println(mid);
		try {
			SqlSession session = sqlFactory.openSession();
			String call = xmlj.userinsert(mid, mpw, mname, mtel, mage);
			System.out.println(call);
		} catch (Exception e) {
			
		}
		return "view/insertok";
	}
	
	@RequestMapping("/select4.do")
	public String homepage(Model m) {
		try {
			SqlSession session = sqlFactory.openSession();
			List<uservo> datas = xmlj.selectall();
			System.out.println(datas.size());
			m.addAttribute("list",datas);
			List<uservo> uv = xmlj.selectid("hong");
			System.out.println(uv.get(0).getMpw());
			int age = 5;
			List<uservo> datas2 = xmlj.selectage(age);
			System.out.println(datas2.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "view/select4";
	}
	
	@RequestMapping("/member_update.do")
	public String updatemb(Model m, String mid, String mpw, String mname) {
		try {
			SqlSession modify = sqlFactory.openSession();
			String res = xmlj.userupdate(mid, mpw, mname);
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "view/insertok";
	}
	@RequestMapping("/user_delete.do")
	public String deleteuser(Model M, String mid, String mpw, String mnm) {
		try {
			SqlSession delete = sqlFactory.openSession();
			String res = xmlj.userdelete(mid, mpw, mnm);
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "view/insertok";
	}
}










