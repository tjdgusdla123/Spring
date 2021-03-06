package naver.rlgns1129.smartorder.service;



import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.rlgns1129.smartorder.dao.StoreMemberBoardDAO;
import naver.rlgns1129.smartorder.domain.StoreMemberBoard;


@Service
public class StoreMemberBoardServiceImpl implements StoreMemberBoardService {
	@Autowired
	private StoreMemberBoardDAO  storeMemberBoardDao;
	

    
	//게시판 글 작성 
	@Override
	public void memberBoardWrite(MultipartHttpServletRequest request , HttpServletResponse response) {
  
		Map<String,Object> map = new HashMap<>();
		
    //파라미터 읽기  
    String boardTitle = request.getParameter("boardtitle");
    String boardContent = request.getParameter("boardcontent");
    //StoreMember storeMember = (StoreMember)request.getSession().getAttribute("storememberinfo");
	//System.out.println("serviceImpl-memberBoard-memberBoard-storeMember 파라미터 읽기:"+storeMember);
    //String memberNickname = storeMember.getMembernickname();
    String memberNickname = request.getParameter("membernickname");
    MultipartFile imge =request.getFile("boardfile");
   
    
    System.out.println("serviceImpl-memberBoard-boardTitle 파라미터 읽기:"+boardTitle);
	 System.out.println("serviceImpl-memberBoard-boardContent 파라미터 읽기:"+boardContent);
	 //System.out.println("serviceImpl-memberBoard-memberNickname 파라미터 읽기:"+memberNickname);
	 System.out.println("serviceImpl-memberBoard-boardFile 파라미터 읽기:"+imge);
	    
	 
	//기본값이 없는 경우는 null
			String boardFile = "default.jpg";
			
			//파일이 존재하는 경우에만 
			if(imge != null && imge.isEmpty() == false) {
				//파일을 업로드할 디렉토리 경로를 설정
				String filePath = request.getServletContext().getRealPath("/img");
				//파일이름 생성 - 중복된 파일이름을 업로드 할까봐서 수정
				boardFile = UUID.randomUUID() + imge.getOriginalFilename();
				//파일 업로드 하기 
				File f = new File(filePath + "/" + boardFile);
				try(FileOutputStream fos = new FileOutputStream(f)){
					fos.write(boardFile.getBytes());fos.flush();
				}catch(Exception e) {
					System.out.println("파일 업로드 예외:" + 
				   e.getMessage());
				}
//	 
//	  String uploadPath = request.getServletContext().getRealPath("/img");
//		// 파일 이름 만들기
//		 UUID uemail = UUID.randomUUID();
//		String filename = boardFile.getOriginalFilename();
//		      
//	   
//			if(filename.length()>0) {
//				filename = uemail + "_" + filename;
//				//저장된 파일 경로 만들기
//			String filepath  = uploadPath + "\\" + filename;
//			//파일 업로드
//	        File file = new File(filepath);
//				try {
//					boardFile.transferTo(file);
//				} catch (IllegalStateException e) {
//					 System.out.println("파일 업로드 예외"+e.getMessage());
//					e.printStackTrace();
//				} catch (IOException e) {
//					 System.out.println("파일 업로드 예외2"+e.getMessage());
//					e.printStackTrace();
//				}
//		
//	        
//			}else {
//				filename="default.png";
			}
			//필요한 데이터를 생성 
			 StoreMemberBoard storeMemberBoard = new StoreMemberBoard();
		     String boardIp =request.getRemoteAddr();
		     storeMemberBoard.setBoardFile(boardFile);
		     storeMemberBoard.setBoardTitle(boardTitle);
		     storeMemberBoard.setBoardContent(boardContent);
		     storeMemberBoard.setMemberNickname(memberNickname);
		     storeMemberBoard.setBoardIp(boardIp);
		    
		     System.out.println("serviceImpl-memberBoard-storeMemberBoard.setBoardTitle(boardTitle):"+boardTitle);
		     System.out.println("serviceImpl-memberBoard-storeMemberBoard.setBoardFile(boardfile):"+boardFile);
		     System.out.println("serviceImpl-memberBoard-storeMemberBoard.setBoardContent(boardContent):"+boardContent);
		     //System.out.println("serviceImpl-memberBoard-storeMemberBoard.setMemberNickname(memberNickname):"+memberNickname);
		     System.out.println("serviceImpl-memberBoard-storeMemberBoard.setBoardIp(boardIp):"+boardIp);
		    
		     int row = storeMemberBoardDao.memberBoardWrite(storeMemberBoard);
				// 저장에 성공하면 map의 result에 true 저장
				if (row > 0) {
					map.put("result", true);
					System.out.println("ServiceImpl2-memberBoardWrite-map-true:"+map);
				}else {
					map.put("result",false);
					System.out.println("ServiceImpl2-memberBoardWrite-map-false:"+map);
				}
				System.out.println("ServiceImpl2-memberBoardWrite-result,map:"+map);
				 request.setAttribute("result",map);	 
				 
				 
				 
				 
			}

	



//	@Override
//	public void memberBoardList(HttpServletRequest request, HttpServletResponse response) {
//		List<StoreMemberBoard> list = storeMemberBoardDao.memberBoardList();
//		
//		request.setAttribute("list", list);
//		System.out.println("ServiceImpl-memberBoardList-list:"+list);
//	}


	   //게시글 목록  
//    @Override
//	public List<StoreMemberBoard> memberBoardList() {
//			List<StoreMemberBoard> list = storeMemberBoardDao.memberBoardList();
//			System.out.println("serviceImpl-memberBoard-memberBoardList-list:"+list);
//			Calendar cal =Calendar.getInstance();
//			Date today = new Date(cal.getTimeInMillis());
//			System.out.println("serviceImpl-memberBoard-memberBoardList-cal:"+cal);
//			System.out.println("serviceImpl-memberBoard-memberBoardList-today:"+today);
//		
//	for(StoreMemberBoard storeMemberBoard :list) {
//				System.out.println(today.toString());
//				System.out.println(storeMemberBoard.getBoardRegdate().toString().substring(0,10));
//			
//			if(today.toString().equals(storeMemberBoard.getBoardRegdate().toString().substring(0,10))) {
//					storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(11));
//				
//				}else {
//				storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(0, 10));
//				}
//			}
//	System.out.println("serviceImpl-memberBoard-memberBoardList-list:"+list);
//
//			return list;
//			
//			
//			
//	}
	@Override
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
		
		int cnt= 10;
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
				Calendar cal = Calendar.getInstance();
				Date today = new Date(cal.getTimeInMillis());
				for (StoreMemberBoard storeMemberBoard : memberBoardList) {
					if (today.toString().equals(storeMemberBoard.getBoardRegdate().toString().substring(0, 10))) {
						storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(11));
					} else {
						storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(0, 10));
					}
				}

				System.out.println("ServiceImpl-memberBoardList-memberBoardList:"+memberBoardList);
				
				//DAO의 메소드를 호출해서 결과 가져오기 - 데이터 개수와 데이터 목록
				map = new HashMap<String,Object>();
				map.put("memberBoardList",memberBoardList);
				map.put("memberBoardCount",memberBoardCount);
				
				//결과를 저장하기
				System.out.println("ServiceImpl-memberBoardList-request:"+request);
			   request.setAttribute("result", map);
				
						
	}


@Override
public void memberBoardDetail(HttpServletRequest request) {
	
	
}

	
}
 



	
	





