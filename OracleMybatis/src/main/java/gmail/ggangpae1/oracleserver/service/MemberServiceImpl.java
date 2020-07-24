package gmail.ggangpae1.oracleserver.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.ggangpae1.oracleserver.dao.MemberDAO;
import gmail.ggangpae1.oracleserver.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDao ;

	@Override
	public void login(HttpServletRequest request) {
		//파라미터 읽기
	   String id = request.getParameter("id");
	   String pw = request.getParameter("pw");
	   Member member =new Member();
	   member.setId(id);
	   member.setPw(pw);
	   
	   //DAO의 매개변수 만들기
	Member result = memberDao.login(member);
	   
	//result null이면 로그인 실패 그렇지 않으면 로그인 성공
	request.setAttribute("result", result);
			   
	}
	
	

}
