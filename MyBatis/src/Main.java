import org.springframework.context.support.GenericXmlApplicationContext;

import mybatis.dao.GoodDAO;

public class Main {

	public static void main(String[] args){
		try {
			GenericXmlApplicationContext context =new GenericXmlApplicationContext("applicationContext.xml");
			GoodDAO dao= context.getBean(GoodDAO.class);
			System.out.println(dao.allgood());
			context.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

	}

}
