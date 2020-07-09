package kr.co.pk;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.pk.item.domain.Item;
import kr.co.pk.item.domain.ItemReport;
import kr.co.pk.item.domain.Member;
import kr.co.pk.item.service.ItemService;

@Controller
public class HomeController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "fileview", method = RequestMethod.GET)
	public String fileview(HttpServletRequest request, HttpServletResponse response) {
		itemService.fileview(request, response);
		return "fileview";
	}

	// 파일 다운로드 뷰를 출력하는 요청
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response, Model model) {

		// 아래 문장이 출력되지 않으면 View에서 요청과 Controller 처리 메소드의
		// RequestMapping이 맞지 않는 것입니다.
		// System.out.println("Controller");

		// 파라미터 읽기
		String filename = request.getParameter("filename");

		// 이 줄에서 null 이 리턴되면 ? 뒤에 이름과 위의 이름이 안맞는 것입니다.
		// System.out.println("파라미터:" + filename);

		// 데이터를 저장
		model.addAttribute("filename", filename);

		return "download";
	}

	// 엑셀로 출력하는 요청을 처리하는 메소드
	@RequestMapping(value = "item.xls", method = RequestMethod.GET)
	public String excel(HttpServletRequest request, HttpServletResponse response, Model model) {
		// ITEM 테이블의 데이터를 전부 읽어오는 서비스를 호출
		itemService.allitem(request, response);
		// Model에 데이터 저장
		model.addAttribute("list", request.getAttribute("list"));
		// 출력할 뷰를 결정
		return "excel";
	}

	// PDF로 출력하는 요청을 처리하는 메소드
	@RequestMapping(value = "item.pdf", method = RequestMethod.GET)
	public String pdf(HttpServletRequest request, HttpServletResponse response, Model model) {
		// ITEM 테이블의 데이터를 전부 읽어오는 서비스를 호출
		itemService.allitem(request, response);
		// Model에 데이터 저장
		model.addAttribute("list", request.getAttribute("list"));
		// 출력할 뷰를 결정
		return "pdf";
	}

	// json 출력을 위한 메소드
	@RequestMapping(value = "item.json", method = RequestMethod.GET)
	public String json(HttpServletRequest request, HttpServletResponse response, Model model) {
		// ITEM 테이블의 데이터를 전부 읽어오는 서비스를 호출
		itemService.allitem(request, response);
		// Model에 데이터 저장
		model.addAttribute("list", request.getAttribute("list"));
		// 출력할 뷰를 결정
		return "itemlist";
	}

	// xml 출력을 위한 메소드
	@RequestMapping(value = "item.xml", method = RequestMethod.GET)
	public String xml(HttpServletRequest request, HttpServletResponse response, Model model) {
		// ITEM 테이블의 데이터를 전부 읽어오는 서비스를 호출
		itemService.allitem(request, response);
		List<Item> list = (List<Item>) request.getAttribute("list");
		ItemReport itemReport = new ItemReport();
		itemReport.setList(list);
		// Model에 데이터 저장
		model.addAttribute("list", itemReport);
		// 출력할 뷰를 결정
		return "itemxml";
	}

	// exception 요청이 get 방식으로 온 경우 처리하기 위한 메소드
	@RequestMapping(value = "exception", 
			method = RequestMethod.GET)
	public String exception(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 출력할 뷰를 결정
		return "exception";
	}
	// exception 요청이 post 방식으로 온 경우 처리하기 위한 메소드
	@RequestMapping(value = "exception", 
			method = RequestMethod.POST)
	public String exceptionprocess(
			HttpServletRequest request, HttpServletResponse response, Model model) {
		//파라미터 읽기
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		//파라미터를 가지고 작업
		int result = Integer.parseInt(num1) 
				/ Integer.parseInt(num2);
		//결과 저장
		model.addAttribute("result", result);
		//결과 출력 페이지 설정
		return "result";
	}
	
	@RequestMapping(value="validation", method=RequestMethod.GET)
	public String validation(
		@ModelAttribute("member") Member member) {
		return "validation";
	}
	
	//예외가 발생하면 처리하는 메소드
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("result", e.getMessage());
		return "error/exception";
	}

	@ModelAttribute("loginTypes")
	public List<String> loginTypes(){
		List<String> list = new ArrayList<String>();
		list.add("개인회원");
		list.add("기업회원");
		list.add("비회원");
		return list;
	}

}







