import org.springframework.context.support.GenericXmlApplicationContext;

import controller.GoodController;
import dao.GoodDao;
import domain.Good;
import service.GoodService;
import service.GoodServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext(
				"applicationContext.xml");
		
		GoodController goodController = 
				context.getBean(GoodController.class);
		goodController.detail();
		
		context.close();

	}

}
