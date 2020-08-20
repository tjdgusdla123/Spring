package naver.dkxkgh98.smartorder.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	private StoreMemberDAO storeMemberDAO;

	@Override
	public void allstoremember(HttpServletRequest request, HttpServletResponse response) {
		// 1.파라미터 읽기
		// 2.필요한 처리 수행
		// 3.DAO 메소드의 매개변수 생성
		// 4.DAO 메소드를 호출
		List<StoreMember> list = storeMemberDAO.allstoremember();
		// 5.결과를 가공
		// 6.결과를 저장 - REST API Server의 경우는 request에 저장
		request.setAttribute("list", list);
	}

	@Override
	public void detailstoremember(HttpServletRequest request, HttpServletResponse response) {
		// 요청 주소의 마지막 부분을 가져오기
		String requestURI = request.getRequestURI();
		String[] ar = requestURI.split("/");
		String membernickname = ar[ar.length - 1];

		try {
			membernickname = URLDecoder.decode(membernickname, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("serviceImpl.detailItem membernickname변수" + membernickname);
		// DAO의 메소드 호출
		StoreMember storemember = storeMemberDAO.detailstoremember(membernickname);
		// 결과를 저장
		request.setAttribute("storemember", storemember);
		System.out.println(storemember);
	}

	@Override
	public Map<String, Object> join(HttpServletRequest request, HttpServletResponse response) {
		// 결과를 저장할 객체를 생성
		Map<String, Object> map = new HashMap<String, Object>();
		// 성공과 실패 여부를 확일할 데이터 생성
		map.put("result", false);
		// 실패했을 때 실패 이유를 저장하기 위한 데이터 생성
		map.put("memberemailcheck", false);
		map.put("membernicknamecheck", false);

		// 파라미터 읽기
		String memberemail = request.getParameter("memberemail");
		String membernickname = request.getParameter("membernickname");
		String memberpassword = request.getParameter("memberpassword");
		String memberphonenumber = request.getParameter("memberphonenumber");
		// 파일은 읽는 방법이 다름(회원정보에는 파일 첨부가 없기 때문에 주석처리함)
		// MultipartFile mf =request.getFile(image);

//		// memberemail 중복검사
//		String memberemailResult = null;
//		// 암호화 되어 있기 때문에 전체 이메일을 가져와서
//		// 복호화 하면서 비교
//		List<String> memberemaillist = storeMemberDAO.memberemailCheck();
//		try {
//			for (String imsi : memberemaillist) {
//				if (CryptoUtil.decryptAES256(imsi, "tjdgusdla123").equals(memberemail)) {
//					memberemailResult = memberemail;
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		// memberemail 중복 검사 수행
		String memberemailResult = storeMemberDAO.memberemailCheck(memberemail);
		if (memberemailResult == null) {
			map.put("memberemailcheck", true);
		}
		// membernickname 중복 검사 수행
		String membernicknameResult = storeMemberDAO.membernicknameCheck(membernickname);
		if (membernicknameResult == null) {
			map.put("membernicknamecheck", true);
		}
		// memberemail 중복검사와 membernickname중복 검사를 통과한 경우에만 데이터 삽입
		if (memberemailResult == null && membernicknameResult == null) {
			// 그림 파일의 기본 이름 설정(첨부 파일이 없기때문에 지금은 사용하지 않고 메뉴 정보를 만들때 참조해서 만들기)
			// String image ="default.jpg";
			// 파일을 선택한 경우에만 파일을 서버에 복사
			/*
			 * if(mf.isempty()==false) { 
			 * //저장할 디렉토리 경로를 생성 
			 * String uploadPath =request.getServletContext().getRealPath("/user/profile");
			 * //파일 이름을 랜덤하게 설정
			 * image =UUID.randomUUID()+mf.getOriginalFilename(); 
			 * //실제로 저장될 경로 만들기
			 * uploadPath = uploadpath +"/"+ image;
			 *  //파일 객체 생성 
			 *  File file =new File(uploadPath); 
			 *  FileOutputStream fos = null; try { 
			    //mf 의내용을 file에 복사
			 *  fos=new FileOutputStream(file); fos.write(mf.getBytes()); 
			 *  } catch (Exception e)
			 * 
			 * { System.out.println(e.getMessage()); e.printStackTrace(); } }
			 */
		}
		// 암호화에 사용할 키를 생성
		// 실무에서 이 키를 데이터베이스에서 불러옵니다.
		String key = "tjdgusdla123";
		// 저장할 데이터 생성
		StoreMember storeMember = new StoreMember();
		try {
			// memberemail 암호화 해서 저장
			storeMember.setMemberemail(memberemail);
			//storeMember.setMemberemail(CryptoUtil.encryptAES256(memberemail, key));
			storeMember.setMemberpassword(BCrypt.hashpw(memberpassword, BCrypt.gensalt()));
			storeMember.setMembernickname(membernickname);
			storeMember.setMemberphonenumber(memberphonenumber);
			// storeMember.setImage(image);(첨부파일없음 파일있다면 주석처리한 부분을 사용하면된다)

			// 데이터베이스 저장
			int row = storeMemberDAO.join(storeMember);
			// 저장에 성공하면 map의 result에 true 저장
			if (row > 0) {
				map.put("result", true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", false);
		//파라미터읽기
		String membernickname =request.getParameter("membernickname");
		String memberpassword = request.getParameter("memberpassword");
		
		System.out.println("StoreMemberServiceImpl.login.membernickname 파라미터확인 : " + membernickname);
		System.out.println("StoreMemberServiceImpl.login.memberpassword 파라미터확인 : " + memberpassword);
		
		StoreMember storeMember = storeMemberDAO.login(membernickname);
	
		System.out.println("StoreMemberServiceImpl.login.storeMember 파라미터확인 : " + storeMember);
		try {
			if(storeMember.getMembernickname().equals(membernickname)&& BCrypt.checkpw(memberpassword, storeMember.getMemberpassword())) {
				result.put("result",true);
				result.put("membernickname",membernickname);
				result.put("memberpassword",storeMember.getMemberemail());			
				result.put("storememberphonenumber",storeMember.getMemberphonenumber());
				
			}
		}catch(Exception e) {
			System.out.println("serviceImpl-login:"+e.getMessage());
			e.getStackTrace();
		}
		
		request.getSession().setAttribute("storememberinfo", result);
		return result;
	}

	

}

