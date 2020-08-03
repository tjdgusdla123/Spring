package naver.dkxkgh98.smartorder.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreMenuPageController {

	@RequestMapping(value = { "/","index.html","user/main"},method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {	
	System.out.println("컨트롤러 메인 도착");
		return "member/main";
		
	}
	@RequestMapping(value = "nonmember",method = RequestMethod.GET)
	public String nonmember(HttpServletRequest request, HttpServletResponse response) {	
		System.out.println("컨트롤러 nonmember 도착");
		return "member/nonmember";
	
	}
}
