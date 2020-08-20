package naver.dkxkgh98.smartorder.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.dkxkgh98.smartorder.domain.StoreMemberBoard;


public interface StoreMemberBoardService {
    //게시물 글쓰기 
	public  void  memberBoardWrite(MultipartHttpServletRequest request, HttpServletResponse response);
	
	//게시글 목록
	public void memberBoardList(HttpServletRequest request, HttpServletResponse response);
	
	//게시글 상세보기 
	public void  memberBoardDetail(HttpServletRequest request, HttpServletResponse response);


	
	
}


