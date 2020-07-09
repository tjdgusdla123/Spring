package kr.co.pk.item.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.pk.item.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(
			value = {"/", "index.html"}, method = RequestMethod.GET)
	public String home(
			HttpServletRequest request, 
			HttpServletResponse response) {
		//서비스의 메소드를 호출
		itemService.allitem(request, response);
		return "home";
	}
	
	@RequestMapping(
			value = {"detail/{itemid}"}, 
			method = RequestMethod.GET)
	public String detail(
			HttpServletRequest request, 
			HttpServletResponse response) {
		//서비스의 메소드를 호출
		itemService.detailitem(request, response);
		return "detail";
	}
	
	
	
}







