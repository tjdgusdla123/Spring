import org.springframework.context.support.GenericXmlApplicationContext;

import controller.GoodController;
import dao.GoodDao;
import domain.Good;
import service.GoodService;
import service.GoodServiceImpl;

public class Main {
    
	public static void main(String[] args) {
		/*
		//Dao �ν��Ͻ��� ����
		GoodDao goodDao = new GoodDao();
		//Service �ν��Ͻ��� ����
		//�̷��� �ϸ� �����ڸ� �̿��� �����̶�� �մϴ�.
		//GoodService goodService = new GoodServiceImpl(goodDao);
		
		
		//������Ƽ�� �̿��� ���� - setter �޼ҵ� �̿�
		GoodServiceImpl goodService = new GoodServiceImpl();
		goodService.setGoodDao(goodDao);
		
		//Controller�� �ν��ͽ��� ����
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
