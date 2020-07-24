package gmail.ggangpae1.oracleserver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gmail.ggangpae1.oracleserver.domain.Member;
import gmail.ggangpae1.oracleserver.service.MemberService;

@RestController
public class MemberController {
   @Autowired
   private MemberService memberService;
  //로그
   @RequestMapping(value="login")
	public Map<String, Object> login(HttpServletRequest request){
	   memberService.login(request);
	   Member member =(Member)request.getAttribute("result");
	   Map<String,Object> map = new HashMap<String,Object>();
	   //어떤 작업 수행의 결과를 null일 수 있는 경우는
	   //다른 키를 하나추가해서 null 여부를 판단할 수 있도록 해줍니다.
	   if(member==null) {
		   map.put("login",false);
	   }else {
		   map.put("login",true);
		   map.put("result",member);
	   }
	  
	   return map;
	   
   }
}
