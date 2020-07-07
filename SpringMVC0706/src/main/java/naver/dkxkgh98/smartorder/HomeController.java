package naver.dkxkgh98.smartorder;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/", "index.html" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("controller-home");
		return "home";
	}

	// form 요청을 GET으로 전송했을 때 처리할 메소드
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		System.out.println("controller-main");
		// 단순 페이지 이동은 jsp 파일의 이름만 리턴하면 됩니다.
		return "main";
	}

//	@RequestMapping(value="main", method = RequestMethod.POST)
//	//기존의 HttpServletRequest를 이용한 파라미터 처리를 위한 메소드
//	public String main(HttpServletRequest request) {
//	System.out.println("컨트롤러 메인 확인");
//		String membermail = request.getParameter("membermail");
//	String memberpassword = request.getParameter("memberpassword");
//	String memberpassword1 = request.getParameter("memberpassword1");
//	String memberphonenumber = request.getParameter("memberphonenumber");
//	String membernickname = request.getParameter("membernickname");
//	
//	System.out.println("이메일:"+membermail);
//	System.out.println("비밀번호:"+memberpassword);
//	System.out.println("비밀번호확인:"+memberpassword1);
//	System.out.println("전화번호:"+memberphonenumber);
//	System.out.println("닉네임:"+membernickname);
//	
//	return "result";
//}
@RequestMapping(value="form", method = RequestMethod.POST)
public String form(
@RequestParam("membermail") String membermail,
@RequestParam("memberpassword") String memberpassword,
@RequestParam("memberpassword1") String memberpassword1,
@RequestParam("memberphonenumber") String memberphonenumber,
@RequestParam("membernickname") String membernickname) {
	
//출력
System.out.println("메일:" + membermail);
System.out.println("비밀번호:" + memberpassword);
System.out.println("확인" + memberpassword1);
System.out.println("전화번호:" + memberphonenumber);
System.out.println("닉네임:" + membernickname);

return "result";
}
}
