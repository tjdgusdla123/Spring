package gmail.ggangpae1.oracleserver.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.ggangpae1.oracleserver.dao.ItemDAO;
import gmail.ggangpae1.oracleserver.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAO itemDao;
	
	@Override
	public void list(HttpServletRequest request) {
		//매개변수로 페이지 번호가 온다고 가정
		String pageno = request.getParameter("pageno");
		//페이지 당 데이터 개수
		int cnt = 2;
		//시작번호 와 끝나는 번호 생성
		int start = 
				Integer.parseInt(pageno) * cnt 
				- (cnt-1);
		int end = Integer.parseInt(pageno) * cnt;
		
		//DAO 의 파라미터 만들기
		Map<String, Object> map = 
				new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		//DAO 의 메소드를 실행하고 결과를 저장
		List<Item> list = itemDao.list(map);
		request.setAttribute("list", list);

	}

	@Override
	public void detail(HttpServletRequest request) {
		String itemid = request.getParameter("itemid");
		Item item = itemDao.detail(Integer.parseInt(itemid));
		request.setAttribute("item", item);

	}

}
