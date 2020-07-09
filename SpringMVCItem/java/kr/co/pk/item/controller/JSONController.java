package kr.co.pk.item.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pk.item.service.ItemService;

@RestController
public class JSONController {
	@Autowired
	private ItemService itemService;
	
	//문자열을 출력하는 요청 처리
	@RequestMapping(value="dataformat.csv", method = RequestMethod.GET)
	public String csv() {
		String result = "dataformat:csv,xml,json";
		return result;
	}
	
	//JSON 출력을 위한 메소드
	@RequestMapping(value="dataformat.json", method = RequestMethod.GET)
	public Map<String, Object> json() {
		List<String> list = new ArrayList<String>();
		list.add("csv:구분자로 구분된 텍스트");
		list.add("xml:태그로 데이터를 표현");
		list.add("json:자바스크립트의 데이터 표현법을 이용해서 데이터를 표현");
		
		Map<String, Object> result = 
				new HashMap<String, Object>();
		result.put("dataformat", list);
		return result;
	}
	
	//JSON 출력을 위한 메소드
	@RequestMapping(value="ajax.json", method = RequestMethod.GET)
	public Map<String, Object> ajaxjson() {
		//테이블 형식의 데이터 구조
		//Map 대신에 DTO를 사용해도 됩니다.
		List<Map<String, Object>> list = 
			new ArrayList<Map<String, Object>>();
	
		Map<String, Object> map = 
			new HashMap<String, Object>();
		map.put("Encapsulation", 
			"캡슐화 - 불필요한 부분은 숨기고 필요한 부분만 외부로 노출해서 사용하는 것으로 정보은닉을 포함하며 "
			+ "클래스를 만드는 것과 인스턴스를 만드는 것이 캡슐화");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("Inheritance", 
			"상속 - 하위 클래스가 상위 클래스의 모든 것을 물려받는 것으로 재사용성이 증가하고 "
			+ "유지보수가 편리해짐 직접 만든 클래스의 경우는 대부분의 경우 클래스를 여러 개 "
			+ "만들다가 동일한 부분이 있어 상위 클래스를 생성 - 이런 이유때문에 "
			+ "다이어그램에서는 하위 클래스에서 상위 클래스로 화살표가 만들어 짐 "
			+ "- is a 관계 또는 generalization 이라고도 함");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("Polymorphism", 
			"다형성 - 동일한 메시지에 대하여 다르게 반응하는 성질로 프로그래밍에서는 "
			+ "동일한 코드가 어떤 인스턴스가 대입되었느냐에 따라 다른 클래스의 메소드를 "
			+ "호출하는 것 - 인터페이스나 추상 클래스에 메소드를 선언하고 다른 클래스들이 "
			+ "인터페이스나 추상클래스를 상속받아서 메소드를 재정의 하는 방식으로 작성 "
			+ "- Inheritance 와 Method Overriding을 이용해서 구현");
		list.add(map);
		
			
		Map<String, Object> result = 
				new HashMap<String, Object>();
		result.put("oop", list);
		return result;
	}
	
}
