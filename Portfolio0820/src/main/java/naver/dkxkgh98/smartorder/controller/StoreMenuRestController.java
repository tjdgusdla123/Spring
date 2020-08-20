package naver.dkxkgh98.smartorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import naver.dkxkgh98.smartorder.domain.StoreMenu;
import naver.dkxkgh98.smartorder.service.StoreMenuService;

@RestController
public class StoreMenuRestController {
	@Autowired
	private StoreMenuService storeMenuService;
	
	@RequestMapping(value = {"/nonmember/mainmenu" , "/nonmember/alcohol", "/nonmember/drink"} , method = RequestMethod.GET)
	public Map<String,Object> mainmenu(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Controller-mainmenu-도착");
		
       storeMenuService.getMenu(request, response);
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreMenu> storeMenu = (List<StoreMenu>)request.getAttribute("list");
		map.put("list", storeMenu);

		return map;
		
	}

	
	
}
