package naver.dkxkgh98.smartorder.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import naver.dkxkgh98.smartorder.domain.StoreMemberBoard;
import naver.dkxkgh98.smartorder.service.StoreMemberBoardService;
@RestController
public class StoreMemberBoardRestController {
	
	@Autowired
	
	private StoreMemberBoardService storeMemberBoardService;
	
	//게시물작성 
	@RequestMapping(value ="memberboardwrite", method = RequestMethod.POST)
	public Map<String,Object> memberBoard(MultipartHttpServletRequest request, HttpServletResponse response){
		System.out.println("StoreMemberBoardController-memberBoard-도착");
		//서비스 메소드 호출
		storeMemberBoardService.memberBoardWrite(request, response);
		Map<String,Object> map = (Map<String,Object>)
		request.getAttribute("result");
	    System.out.println("StoreMemberBoardController-requset.getAttribute(result)"+request.getAttribute("result"));
		//System.out.println("StoreMemberBoardController-memberBoard-도착-map");
		//request.getSession().getAttribute("storememberinfo");
		//System.out.println("StoreMemberBoardController-memberBoard-도착 후 : " + request.getSession().getAttribute("storememberinfo"));
		//Map<String,Object> map = storeMemberBoardService.memberBoard(request, response);
		//System.out.println("StoreMemberBoardController-memberBoard-도착-map:"+map);
		return map;
		
	}
	@RequestMapping(value ="boardlist" ,method = RequestMethod.GET)
	public Map<String,Object> memberBoardList(HttpServletRequest request,HttpServletResponse response){
		System.out.println("StoreMemberBoardController-memberBoardList-도착");
		storeMemberBoardService.memberBoardList(request, response);
		Map<String,Object> map = (Map<String,Object>)
				request.getAttribute("result");
		return map;
		
	}

		
		
	}
	

