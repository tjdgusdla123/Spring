package naver.dkxkgh98.smartorder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.dkxkgh98.smartorder.service.StoreMenuService;

@Controller
public class StoreMenuPageController {
	@Autowired
	private StoreMenuService storeMenuService;
	@RequestMapping(value ="nonmember", method = RequestMethod.GET)
	public String nonmember() {
		System.out.println("페이지controller도착-비회원입장");
		return "user/nonmember";
		
	}
	//@RequestMapping(value ="user/allstoremenu", method = RequestMethod.GET)
		//public String allstoremenu(HttpServletRequest request, HttpServletResponse response) {
			//서비스의 메소드를 호출
		//storeMenuService.allstoremenu(request,response);
		//	System.out.println("페이지controller도착-전체메뉴");
		//return "user/allstoremenu";	
			
		//}

	//Controller 클래스에 상세보기를 위한 메소드를 구현
     //  @RequestMapping(value = {"user/detailstoremenu/{menucode}"}, method = RequestMethod.GET)
	//public String detailstoremenu(HttpServletRequest request, HttpServletResponse response) {
		 //서비스의 메소드를 호출
	//System.out.println("페이지controller도착-상세보기");
	//	storeMenuService.detailstoremenu(request, response);
		//return "user/detailstoremenu";
//}
	
}
