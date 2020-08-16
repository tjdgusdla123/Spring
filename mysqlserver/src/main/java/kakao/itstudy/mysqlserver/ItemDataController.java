package kakao.itstudy.mysqlserver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kakao.itstudy.mysqlserver.service.ItemService;

@RestController
public class ItemDataController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="item/list", 
			method=RequestMethod.GET)
	public Map<String, Object>list(
			HttpServletRequest request){
		itemService.list(request);
		return(Map<String, Object>)
				request.getAttribute("result");
	}
	@RequestMapping(value="item/detail", 
			method=RequestMethod.GET)
	public Map<String, Object>detail(
			HttpServletRequest request){
		itemService.detail(request);
		return(Map<String, Object>)
				request.getAttribute("result");
	}
	@RequestMapping(value="item/insert", 
			method=RequestMethod.GET)
	public Map<String, Object>insert(
			MultipartHttpServletRequest request){
		itemService.insert(request);
		return(Map<String, Object>)
				request.getAttribute("result");
	}
	

}
