import org.springframework.context.support.GenericXmlApplicationContext;

import controller.GoodController;
import dao.GoodDao;
import domain.Good;
import service.GoodService;
import service.GoodServiceImpl;

public class Main {
    
	public static void main(String[] args) {
		/*
		//Dao 인스턴스를 생성
		GoodDao goodDao = new GoodDao();
		//Service 인스턴스를 생성
		//이렇게 하면 생성자를 이용한 주입이라고 합니다.
		//GoodService goodService = new GoodServiceImpl(goodDao);
		
		
		//프로퍼티를 이용한 주입 - setter 메소드 이용
		GoodServiceImpl goodService = new GoodServiceImpl();
		goodService.setGoodDao(goodDao);
		
		//Controller를 인스터스를 생성
		GoodController goodController = new GoodController();
		goodController.setGoodService(goodService);
		goodController.detail();
		*/
		
		GenericXmlApplicationContext context =new GenericXmlApplicationContext("applicationContext.xml");
		
		GoodController goodController = context.getBean(GoodController.class);
		goodController.detail();

		context.close();

	}

}
