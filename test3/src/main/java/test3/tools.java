package test3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class tools {
	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://umj7-009.cafe24.com/power933","power933","so9332650!@");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}