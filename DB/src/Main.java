import java.sql.Connection;

import javax.sql.DataSource;


import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
  
	public static void main(String[] args) {
		try {
			//Spring 설정 파일 실행
			GenericXmlApplicationContext context =new GenericXmlApplicationContext("applicationContext.xml");
			                                                                       
			//DataSource 가져오기
			DataSource ds = context.getBean(DataSource.class);
			//connection 만들기
			Connection con =ds.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

	}

}
