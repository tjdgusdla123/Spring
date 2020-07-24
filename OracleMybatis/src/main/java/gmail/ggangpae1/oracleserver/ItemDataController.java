package gmail.ggangpae1.oracleserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gmail.ggangpae1.oracleserver.domain.Item;
import gmail.ggangpae1.oracleserver.service.ItemService;

@RestController
public class ItemDataController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public Map<String, Object> list(HttpServletRequest request){
		//서비스의 메소드를 실행
		itemService.list(request);
		Map<String, Object>map = new HashMap<String, Object>();
		//데이터를 가져와서 map에 출력
		List<Item> list = (List<Item>)
		request.getAttribute("list");
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public Map<String, Object> 
		detail(HttpServletRequest request){
		itemService.detail(request);
		Item item = (Item)request.getAttribute("item");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", item);
		return map;
		
	}
	
	
	
}
