package naver.dkxkgh98.smartorder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import naver.dkxkgh98.smartorder.domain.StoreMemberBoard;
import naver.dkxkgh98.smartorder.service.StoreMemberBoardService;

@Controller

public class StoreMemberBoardPageController {

	@Autowired
	private StoreMemberBoardService storeMemberBoardService;
	//게시판 메인 
	@RequestMapping(value ="board", method = RequestMethod.GET)
	public String board() {
		System.out.println("페이지controller도착-게시판"); 
		return "user/boardmain";
}	//게시글 작성
	@RequestMapping(value ="boardwrite", method = RequestMethod.GET)
	public String boardwrite() {
		System.out.println("페이지controller도착-글쓰기"); 
		return "user/boardwrite";
}	
	
//	@RequestMapping(value ="boardlist", method = RequestMethod.GET)
//   public String memberBoardList(HttpServletRequest request, HttpServletResponse response) {
//		////System.out.println("페이지controller도착-list"); 
//		storeMemberBoardService.memberBoardList(request, response);
//	return "user/boardlist";
//	
//		
//}
//	@RequestMapping(value ="boardlist", method = RequestMethod.GET)
//	   public String memberBoardList(Model model) {
//			System.out.println("페이지controller도착-list");
//			List<StoreMemberBoard> list = storeMemberBoardService.memberBoardList();
//			model.addAttribute("list",list);
//		return "user/boardlist";	
//			
//	}	
//	//게시판 상세보기 
//	@RequestMapping(value ="boarddetail/{boardBno}", method = RequestMethod.GET)
//	public String memberBoardDetail(@PathVariable("boardBno") int boardBno,Model model) {
//		//서비스 메소드 호출 
//		System.out.println("페이지controller-memberBoardDetail도착-상세보기");
//		model.addAttribute("storeMemberBoard",storeMemberBoardService.memberBoardDetail(boardBno));
//		return "user/boarddetail";
//		
//	}

}