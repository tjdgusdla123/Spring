package naver.dkxkgh98.memberinfotbl;

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
	
	//시작 요청이 오면 home 으로 포워딩 : servlet-context.xml파일의 viewResolver와 결합해서 실제 출력할 view를 결정합니다.
	@RequestMapping(value = { "/", "index.html" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("controller-home도착");
		return "home";
	}


}
