package naver.dkxkgh98.smartorder.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.dkxkgh98.smartorder.service.StoreMemberService;
import naver.dkxkgh98.smartorder.service.StoreMenuService;


//웹 사이트의 페이지 이동에만 사용하는 컨트롤러
@Controller
public class StoreMemberPageController {
	@Autowired
	private StoreMemberService storeMemberService;
	@Autowired
	private StoreMenuService storeMenuService;
	@RequestMapping(value = {"/", "index.html","main"}, method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
	   //서비스의 메소드를 호출
		System.out.println("컨트롤 홈 도착");
      	return "user/main";
}
	
	@RequestMapping(value ="join", method = RequestMethod.GET)
	public String join() {
		System.out.println("페이지controller도착-회원가입");
		return "user/join";
		
	}
	
	@RequestMapping(value ="login", method = RequestMethod.GET)
	public String login() {
		System.out.println("페이지controller도착-로그인");
		return "user/login";
		
	}
	@RequestMapping(value ="member", method = RequestMethod.GET)
	public String member() {
		System.out.println("페이지controller도착-member");
		return "user/member";
}

}
