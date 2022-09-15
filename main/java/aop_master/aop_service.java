package aop_master;

//db crud
public interface aop_service {
	void setDao1(aop_dao dao);
	void register() throws Exception;
	void modify() throws Exception;
	String insertdb(String a) throws Exception;
	String deletedb(String a) throws Exception;
}
