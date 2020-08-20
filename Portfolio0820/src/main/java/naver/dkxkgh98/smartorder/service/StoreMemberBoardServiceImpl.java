package naver.dkxkgh98.smartorder.service;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.dkxkgh98.smartorder.dao.StoreMemberBoardDAO;

import naver.dkxkgh98.smartorder.domain.StoreMember;
import naver.dkxkgh98.smartorder.domain.StoreMemberBoard;



@Service
public class StoreMemberBoardServiceImpl implements StoreMemberBoardService {
	@Autowired
	private StoreMemberBoardDAO  storeMemberBoardDao;


@Override
@Transactional
public void memberBoardList(HttpServletRequest request, HttpServletResponse response) {
	//페이지 번호와 페이지 당 데이터 개수 읽어와서 데이터의 인덱스를 생성
	String pageNo = request.getParameter("pageno");
    String pagecnt =request.getParameter("pagecnt");
    System.out.println("ServiceImpl-memberBoardList-pageno:"+pageNo);
    System.out.println("ServiceImpl-memberBoardList-pagecnt:"+pagecnt);
    //검색조건과 검색어를 저장 
    String searchtype = request.getParameter("searchtype");
	String keyword = request.getParameter("keyword");
	System.out.println("ServiceImpl-memberBoardList-searchtype:"+searchtype);
	System.out.println("ServiceImpl-memberBoardList-keyword:"+keyword);
	
	int cnt= 3;
	//한번에 가져올 데이터 개수를 설정
	
			if(pagecnt != null) {
				cnt = Integer.parseInt(pagecnt);
			}
			//시작번호와 종료번호를 계산
			int start = 1;
			int end = start + cnt - 1;
			
			if (pageNo != null) {
				start = Integer.parseInt(pageNo) * cnt - (cnt - 1);
				end = Integer.parseInt(pageNo) * cnt;
			}

			if(searchtype==null) {
				searchtype="";
			}
			
			if(keyword == null) {
				keyword="";
			}else {
				keyword = keyword.toLowerCase();
			}
           //파라미터를 가지고 DAO의 파라미터 만들기 
			Map<String,Object> map =new HashMap<>();
			map.put("start",start);
			map.put("end",end);
			map.put("searchtype",searchtype);
			map.put("keyword",keyword);
			System.out.println("ServiceImpl-memberBoardList-map:"+map);
			
			int memberBoardCount= storeMemberBoardDao.memberBoardCount(map);
			System.out.println("ServiceImpl-memberBoardList-memberBoardCount:"+memberBoardCount);
			List<StoreMemberBoard> memberBoardList = storeMemberBoardDao.memberBoardList(map);
			System.out.println("ServiceImpl-memberBoardList-memberBoardList:"+memberBoardList);
			//DAO의 메소드를 호출해서 결과 가져오기 - 데이터 개수와 데이터 목록
			map = new HashMap<String,Object>();
			map.put("memberBoardList",memberBoardList);
			map.put("memberBoardCount",memberBoardCount);
			
			//결과를 저장하기
			System.out.println("ServiceImpl-memberBoardList-request:"+request);
		   request.setAttribute("result", map);
			
					
}


//게시글 상세보기 
@Override
@Transactional
public void memberBoardDetail(HttpServletRequest request, HttpServletResponse response) {
  String boardBno =request.getParameter("boardbno");
  System.out.println("ServiceImpl-memberBoardDetail-boardBno:"+boardBno);
  
  StoreMemberBoard storeMemberBoard = storeMemberBoardDao.memberBoardDetail(Integer.parseInt(boardBno));
  System.out.println("ServiceImpl-memberBoardDetail-storeMemberBoard:"+storeMemberBoard);
  
  Map<String, Object> map =  new HashMap<String, Object>();
  map.put("storeMemberBoard", storeMemberBoard);
  System.out.println("ServiceImpl-memberBoardDetail-map:"+map);
  System.out.println("ServiceImpl-memberBoardDetail-storeMemberBoard:"+storeMemberBoard);
  
  request.setAttribute("result", map);
  System.out.println("ServiceImpl-memberBoardDetail-map:"+map);
  System.out.println("ServiceImpl-memberBoardDetail-request:"+request);


}



@Override
@Transactional
public void memberBoardWrite(MultipartHttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<>(); 

	//파라미터 읽기
	String boardTitle = request.getParameter("boardtitle");
	String boardContent = request.getParameter("boardcontent");
	String memberNickname = request.getParameter("membernickname");
	
	String boardFile = "default.jpg";
	MultipartFile image =request.getFile("boardfile");
	 System.out.println("ServiceImpl-memberBoardWrite-boardTitle:"+boardTitle);
	 System.out.println("ServiceImpl-memberBoardWrite-boardContent:"+boardContent);
	 System.out.println("ServiceImpl-memberBoardWrite-memberNickname:"+memberNickname);
	 System.out.println("ServiceImpl-memberBoardWrite-boardFile:"+boardFile);
	 System.out.println("ServiceImpl-memberBoardWrite-image:"+image);
	 
	 //업로드 하는 파일이 존재하면 새로운 파일이름을 만들고 파일 업로드
	 if(image != null && image.isEmpty() == false) {
		
		 //서버 애플리케이션의 img 디렉토리의 절대 경로 만들기
		 String filePath = request.getServletContext().getRealPath("/img");
		
		 //랜덤한 문자열을 생성하고 원래 파일 이름과 합쳐서 새로운 파일 이름 만들기
		 boardFile = UUID.randomUUID() + image.getOriginalFilename();
		 
		 //파일 업로드할 경로 만들기 
		 File file = new File (filePath +"/"+boardFile);
		 
		 //파일 업로드 하기 
		 try(FileOutputStream fos = new FileOutputStream(file);) {
			 fos.write(image.getBytes());
			fos.flush();

		 }catch(Exception e) {
			 System.out.println("전송 실패:" +e.getMessage());
		 }
		 
	 }
	// DAO 파라미터 만들기
	 String boardIp = request.getRemoteAddr();
	 StoreMemberBoard storeMemberBoard = new StoreMemberBoard();
	 storeMemberBoard.setBoardTitle(boardTitle);
	 storeMemberBoard.setBoardContent(boardContent);
	 storeMemberBoard.setMemberNickname(memberNickname);
	 storeMemberBoard.setBoardFile(boardFile);
	 storeMemberBoard.setBoardIp(boardIp);
	 //System.out.println("서비스 확인 중입니다1.");
	 System.out.println("ServiceImpl2-memberBoardWrite-boardTitle:"+boardTitle);
	 System.out.println("ServiceImpl2-memberBoardWrite-boardContent:"+boardContent);
	 System.out.println("ServiceImpl2-memberBoardWrite-memberNickname:"+memberNickname);
	 System.out.println("ServiceImpl2-memberBoardWrite-boardFile:"+boardFile);
	 System.out.println("ServiceImpl2-memberBoardWrite-boardIp:"+boardIp);
	 
	 
	 //DAO 메소드를 호출하고 결과를 확인해서 memberBoardWrite라는 이름으로 결과를 저장
	 int row = storeMemberBoardDao.memberBoardWrite(storeMemberBoard);
	System.out.println("서비스 확인 중입니다2."+row);
	 map = new HashMap<String,Object>();
	if(row > 0) {
		map.put("result",true);
		System.out.println("ServiceImpl2-memberBoardWrite-map-true:"+map);
	}else {
		map.put("result",false);
		System.out.println("ServiceImpl2-memberBoardWrite-map-false:"+map);
	}
	System.out.println("ServiceImpl2-memberBoardWrite-result,map:"+map);
	 request.setAttribute("result",map);	 
	 
	 
	 
	 
}

	
}




	
	





