package naver.dkxkgh98.smartorder.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import naver.dkxkgh98.smartorder.domain.StoreMember;

public interface StoreMemberService {
	//메소드의 원형은 public Map<String,Object>이름
	//(HttpServletRequest request, HttpServletResponse response)
	//requset를 이용해서 클라이언트읭 정보를 확인할 수있고
	//response를 이용해서 클라이언트에 출력을 할 수 있습니다.
	//파일이 업로드 되는 경우에는 HttpServletRequest대신에
	//MultipartHttpServletRequest를 사용하면 됩니다.
	
	
	//전체 데이터를 가져오는 메소드
	public void allstoremember(HttpServletRequest request, HttpServletResponse response);
   
	//상세보기를 위한 메소드
	public void detailstoremember(HttpServletRequest request, HttpServletResponse response);

	//회원가입을 처리해주는 메소드(데이터삽입)
	public  Map<String,Object> join(HttpServletRequest request, HttpServletResponse response);
	
	//로그인을 위한 메소드
	public Map<String,Object>login(HttpServletRequest request, HttpServletResponse response);

	 
}

