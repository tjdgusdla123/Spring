package naver.dkxkgh98.smartorder.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import naver.dkxkgh98.smartorder.domain.StoreMember;

public interface StoreMemberService {
	//메소드의 원형은 public Map<String,Object>이름
	//(HttpServletRequest request, HttpServletResponse response)
	//requset를 이용해서 클라이언트의 정보를 확인할 수있고
	//response를 이용해서 클라이언트에 출력을 할 수 있습니다.
	//파일이 업로드 되는 경우에는 HttpServletRequest대신에
	//MultipartHttpServletRequest를 사용하면 됩니다.
	
	
	//서비스의 메소드는 매개변수를 다양하게 만들 수 있습니다.
	//모든 곳에서 사용가능하도록 만들고자 하면 HttpServletRequest 와 HttpServletResponse를 갖도록 하면 되고
	//상황에 따라 다르게 만들 수도 있습니다.
	        //전체 데이터를 가져오는 메소드
			public void allStoreMember(HttpServletRequest request, HttpServletResponse response);
			//회원가입
			public Map<String, Object> join(HttpServletRequest request, HttpServletResponse response);
			//로그인
			public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response);
			//회원정보 수정
			public Map<String, Object> update(HttpServletRequest request , HttpServletResponse response);
			//회원탈퇴
			public int secession(HttpServletRequest request , HttpServletResponse response);
		
			
	}
	 

