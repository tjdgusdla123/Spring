import java.sql.Connection;

import javax.sql.DataSource;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import hibernate.dao.ItemDAO;
import hibernate.dao.TransactionDAO;

public class Main {

	public static void main(String[] args) {
	    try {
			GenericXmlApplicationContext context =new GenericXmlApplicationContext("applicationContext.xml");
			/*
			 * DataSource ds =context.getBean(DataSource.class); Connection con
			 * =ds.getConnection(); System.out.println(con);
			 */
			
			/*
			 * //dao 인스턴스를 가져와서 삽입하는 메소드 호출 TransactionDAO dao =
			 * context.getBean(TransactionDAO.class); dao.insert();
			 */
			//하이버네이트 설정 확인
			/*
			 * SessionFactory sessionFactory = context.getBean(SessionFactory.class);
			 * System.out.println(sessionFactory);
			 */
			
			ItemDAO itemDao = context.getBean(ItemDAO.class);
			//데이터삽입
			//itemDao.insert();
		 	
			//데이터 수정
			//itemDao.update();
			
			//데이터 삭제
			//itemDao.delete();
			
			//데이터 전체보기
			//itemDao.list();
			
			//데이터 1개가져오기
			itemDao.getItem();
        			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
