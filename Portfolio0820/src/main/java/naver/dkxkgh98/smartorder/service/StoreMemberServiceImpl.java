package naver.dkxkgh98.smartorder.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIDecryptor;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import naver.dkxkgh98.smartorder.dao.StoreMemberDAO;
import naver.dkxkgh98.smartorder.domain.StoreMember;
import naver.dkxkgh98.smartorder.util.CryptoUtil;

@Service
public class StoreMemberServiceImpl implements StoreMemberService {
	

	@Autowired
	private StoreMemberDAO storeMemberDao;

	@Override
	public void allStoreMember(HttpServletRequest request, HttpServletResponse response) {
		// 1. 파라미터 읽기

		// 2. 필요한 처리 수행

		// 3. DAO 메소드의 매개변수 생성

		// 4. DAO 메소드를 호출
		List<StoreMember> list = storeMemberDao.allStoreMember();
		// 5. 결과를 가공

		// 6. 결과를 저장 - REST API Server의 경우는 request에 저장
		request.setAttribute("list", list);

	}

	@Override
	public Map<String, Object> join(HttpServletRequest request, HttpServletResponse response) {
		// 결과를 저장할 객체를 생성
		Map<String, Object> map = new HashMap<String, Object>();
		//성공과 실패 여부를 확인할 데이터 생성
		map.put("result", false);
		//실패했을 때 왜 실패헀는지 이유를 저장하기 위한 데이터 생성
		map.put("memberemailcheck", false);
		map.put("membernicknamecheck", false);
		
		String memberNickname = request.getParameter("membernickname");
		String memberEmail = request.getParameter("memberemail");
		String memberPassword = request.getParameter("memberpassword");
		String memberPhoneNumber = request.getParameter("memberphonenumber");
		
		//email 중복 검사 수행
		String emailResult = storeMemberDao.memberEmailCheck(memberEmail);
		if (emailResult == null) {
			map.put("memberemailcheck", true);
		} 
		
		//nickname 중복 검사 수행
		String nicknameResult = storeMemberDao.memberNicknameCheck(memberNickname);
		if (nicknameResult == null) {
			map.put("membernicknamecheck", true);
		}
		
		//암호화에 사용할 키를 생성
		//실무에서 이 키를 데이터베이스에서 불러옵니다.
		String key = "rlgns1129@naver.com";
		//저장할 데이터 생성
		try {
		StoreMember storeMember = new StoreMember();
			
			storeMember.setMemberNickname(memberNickname);
			storeMember.setMemberEmail(memberEmail);
			storeMember.setMemberPassword(BCrypt.hashpw(memberPassword, BCrypt.gensalt()));
			storeMember.setMemberPhoneNumber(memberPhoneNumber);
			
			//데이터베이스에 저장
			int row = storeMemberDao.join(storeMember);
			//저장에 성공하면 map의 result에 true 저장
			if(row > 0) {
				map.put("result", true);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return map;

	}

	@Override
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", false);
		
		String memberNickname;
		if(request.getParameter("membernickname") != null) {
			memberNickname = request.getParameter("membernickname");
			System.out.println("StoreMemberServiceImpl.login.storeMemberNickname.getParameter로 가져왔을때 파라미터확인 : " + memberNickname);
		}else {
			Map<String, Object> storeMemberInfo = (Map<String, Object>)request.getSession().getAttribute("storememberinfo");
			System.out.println("StoreMemberServiceImpl.login.storeMemberNickname.else 구문 storeMemberInfo : " + storeMemberInfo);
			memberNickname = (String)storeMemberInfo.get("storemembernickname");
			System.out.println("StoreMemberServiceImpl.login.storeMemberNickname.세션에서 가져왔을때 파라미터확인 : " + memberNickname);

		}
		String memberPassword = request.getParameter("memberpassword");

		System.out.println("StoreMemberServiceImpl.login.storeMemberNickname 파라미터확인 : " + memberNickname);
		System.out.println("StoreMemberServiceImpl.login.storeMemberPassword 파라미터확인 : " + memberPassword);
		
		StoreMember storeMember = storeMemberDao.login(memberNickname);
		
		System.out.println("StoreMemberServiceImpl.login.storeMember 파라미터확인 : " + storeMember);
		
		
		try {
			
				if(storeMember.getMemberNickname().equals(memberNickname) && BCrypt.checkpw(memberPassword, storeMember.getMemberPassword())) {
					result.put("result", true);
					result.put("storemembernickname", memberNickname);
					result.put("storememberemail", storeMember.getMemberEmail());
					result.put("storememberphonenumber", storeMember.getMemberPhoneNumber());
					
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("storememberinfo", result);
		return result;
		
		
	}

	
	@Override
	public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response) {
		
		// 결과를 저장할 객체를 생성
		Map<String, Object> map = new HashMap<String, Object>();
		//성공과 실패 여부를 확인할 데이터 생성
		map.put("result", false);
		//실패했을 때 왜 실패헀는지 이유를 저장하기 위한 데이터 생성
		map.put("membernicknamecheck", false);
				
		String memberNickname = request.getParameter("membernickname");
		String memberEmail = request.getParameter("memberemail");
		String memberPassword = request.getParameter("memberpassword");
		String memberPhoneNumber = request.getParameter("memberphonenumber");

		System.out.println("StoreMemberServiceImpl.update.memberNickname 파라미터확인 : " + memberNickname);
		System.out.println("StoreMemberServiceImpl.update.memberEmail 파라미터확인 : " + memberEmail);
		System.out.println("StoreMemberServiceImpl.update.memberPassword 파라미터확인 : " + memberPassword);
		System.out.println("StoreMemberServiceImpl.update.memberPhoneNumber 파라미터확인 : " + memberPhoneNumber);
		
		
		//nickname 중복 검사 수행
		String nicknameResult = storeMemberDao.memberNicknameCheck(memberNickname);
		if (nicknameResult == null) {
			map.put("membernicknamecheck", true);
		}
				
		//암호화에 사용할 키를 생성
		//실무에서 이 키를 데이터베이스에서 불러옵니다.
		String key = "rlgns1129@naver.com";
		//저장할 데이터 생성
		try {
		StoreMember storeMember = new StoreMember();
					
			storeMember.setMemberNickname(memberNickname);
			storeMember.setMemberPassword(BCrypt.hashpw(memberPassword, BCrypt.gensalt()));
			storeMember.setMemberPhoneNumber(memberPhoneNumber);
			storeMember.setMemberEmail(memberEmail);
			//데이터베이스에 저장
			int row = storeMemberDao.update(storeMember);
			//저장에 성공하면 map의 result에 true 저장
			if(row > 0) {
				map.put("result", true);
			}
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public int secession(HttpServletRequest request, HttpServletResponse response) {
		int result = -1;
		Map<String, Object> storeMemberInfo = (Map<String, Object>)request.getSession().getAttribute("storememberinfo");
		System.out.println("StoreMemberServiceImpl.login.storeMemberNickname.else 구문 storeMemberInfo : " + storeMemberInfo);
		String memberNickname = (String)storeMemberInfo.get("storemembernickname");
		System.out.println("StoreMemberServiceImpl.login.storeMemberNickname.세션에서 가져왔을때 파라미터확인 : " + memberNickname);
		String memberPassword = request.getParameter("memberpassword");
		
		System.out.println("StoreMemberServiceImpl.secession.storeMemberInfo : " + storeMemberInfo);
		System.out.println("StoreMemberServiceImpl.secession.storeMemberNickname : " + memberNickname);
		System.out.println("StoreMemberServiceImpl.secession.memberPassword : " + memberPassword);

		
		StoreMember storeMember = storeMemberDao.login(memberNickname);
		
		System.out.println("StoreMemberServiceImpl.login.storeMember 파라미터확인 : " + storeMember);
		
		
		try {
				if(storeMember.getMemberNickname().equals(memberNickname) && BCrypt.checkpw(memberPassword, storeMember.getMemberPassword())) {
				result = storeMemberDao.secession(memberNickname);
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
		
		return result;
	}



}