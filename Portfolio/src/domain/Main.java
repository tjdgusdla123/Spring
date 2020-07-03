package domain;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		try {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
			DataSource dataSource = context.getBean(DataSource.class);
			// 내용이 정상적으로 출력되면 데이터베이스 접속 성공
			Connection con = dataSource.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

	}

}
