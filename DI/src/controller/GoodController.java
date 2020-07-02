package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.GoodService;
import service.GoodServiceImpl;

@Controller
public class GoodController {
	//Service 인스턴스를 저장할 변수 생성
	@Autowired
	private GoodService goodService;
	
	//상세보기를 위한 메소드
	public void detail() {
		goodService.detail();
	}
}

