import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;






public class DBTest {

	
	@Test
	public void dbConnect() {
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe","user10","user10");
		
			System.out.println(con);
			
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			
		}
	}
}
