package naver.rlgns1129.smartorder.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.rlgns1129.smartorder.domain.StoreMemberBoard;
import naver.rlgns1129.smartorder.service.StoreMemberBoardService;


@Controller

public class StoreMemberBoardPageController {

	@Autowired
	private StoreMemberBoardService storeMemberBoardService;
	//게시판 메인 
	@RequestMapping(value ="board/list", method = RequestMethod.GET)
	public String board() {
		System.out.println("페이지controller도착-게시판"); 
		return "board/main";
}
	//글쓰기 게시판 메인 
		@RequestMapping(value ="board/boardmain", method = RequestMethod.GET)
		public String boardmain() {
			System.out.println("페이지controller도착-게시판"); 
			return "board/boardmain";
	}
		
	
	//게시글 작성
	@RequestMapping(value ="boardwrite", method = RequestMethod.GET)
	public String boardwrite() {
		System.out.println("페이지controller도착-글쓰기"); 
		return "board/boardwrite";
}	
	
	//게시물 리스트
	@RequestMapping(value ="boardlist", method = RequestMethod.GET)
	public String boardlist() {
		System.out.println("페이지controller도착-글쓰기"); 
		return "board/boardlist";
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