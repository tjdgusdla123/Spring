package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.GoodService;
@Controller
public class GoodController {
    //Service �ν��Ͻ��� ������ ������ ����
	@Autowired
	private GoodService goodService;

	     //�󼼺��⸦ ���� �޼ҵ�
         public void detail() {
        	 goodService.detail();
       }
		
}
