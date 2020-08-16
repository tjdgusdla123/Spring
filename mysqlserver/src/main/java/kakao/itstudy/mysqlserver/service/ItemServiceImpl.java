package kakao.itstudy.mysqlserver.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kakao.itstudy.mysqlserver.dao.ItemDAO;
import kakao.itstudy.mysqlserver.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAO itemDao;
	
	
	@Override
	@Transactional
	public void list(HttpServletRequest request) {
		//파라미터를 읽기 
		//여기서 설정한 파라미터 이름이 
		//클라이언트가 전송하는 파라미터 이름과 일치 
		//searchtype(검색조건), keyword(검색어),
		//pageno(페이지 번호), count(페이지 당 데이터 개수)
		String searchtype = 
				request.getParameter("searchtype");
		String keyword = 
				request.getParameter("keyword");
		String pageno = 
				request.getParameter("pageno");
		String count = 
				request.getParameter("count");
		
		//기본값 설정이나 계산
		if(searchtype == null) {
			searchtype = "";
			keyword="";
		}
		//keyword를 모두 소문자로 변경 
		keyword = keyword.toLowerCase();
		//기본값 설정
		if(pageno == null) {
			pageno = "1";
		}
		if(count == null) {
			count = "3";
		}
		
		
		//DAO의 파라미터를 만들기
		//Map에 searchtype, keyword, start, size
		Map<String, Object> param = 
				new HashMap<String, Object>();
		param.put("searchtype", searchtype);
		param.put("keyword", keyword);
		//데이터 개수
		int size = Integer.parseInt(count);
		param.put("size", size);
		//시작 번호는 계산
		//1 -> 0
		//2 -> size가 3이면 3
		//3 -> size가 3이면 6
		int start = 
				(Integer.parseInt(pageno)-1)
				* size;
		param.put("start", start);
		//오라클이면 start는 mysql 보다 + 1
		//end는 start + size - 1
		
		//DAO의 메소드 호출
		int cnt = itemDao.count(param);
		List<Item> list = itemDao.list(param);
		
		//결과를 저장해서 Controller에게 전달
		Map<String, Object> result = 
				new HashMap<String, Object>();
		result.put("count", cnt);
		result.put("list", list);
		request.setAttribute("result", result);
		

	}

	@Override
	@Transactional
	public void detail(HttpServletRequest request) {
		//파라미터 읽기
		String itemid = 
				request.getParameter("itemid");
		//Dao 메소드 호출 
		Item item = itemDao.detail(
				Integer.parseInt(itemid));
		
		Map<String, Object>result = 
				new HashMap<String, Object>();
		result.put("item", item);
		request.setAttribute("result", result);
		

	}

	@Override
	@Transactional
	public void insert(MultipartHttpServletRequest request) {
		//itemid 만들기 
		int itemid = itemDao.maxid() + 1;
		String itemname = 
				request.getParameter("itemname");
		//파라미터로 받을 것을 정수로 변환할 때 주의점
		//클라이언트에서 null 체크를 한 경우는 바로 변경이 가능
		//클라이언트에서 null 체크를 안하거나 null을 대입할 수 있는
		//경우에는 null 이 아닐 때만 변환 
		int price = Integer.parseInt(
				request.getParameter("price"));
		String description = 
				request.getParameter("description");
		//기본값이 없는 경우는 null
		String pictureurl = "default.jpg";
		
		//파일을 받아오기
		MultipartFile image = 
				request.getFile("pictureurl");
		//파일이 존재하는 경우에만 
		if(image != null && image.isEmpty() == false) {
			//파일을 업로드할 디렉토리 경로를 설정
			String filePath = 
					request.getServletContext()
					.getRealPath("/img");
			//파일이름 생성 - 중복된 파일이름을 업로드 할까봐서 수정
			pictureurl = 
				UUID.randomUUID() + 
				image.getOriginalFilename();
			//파일 업로드 하기 
			File f = new File(filePath + "/" + pictureurl);
			try(FileOutputStream fos = 
					new FileOutputStream(f)){
				fos.write(image.getBytes());
				fos.flush();
			}catch(Exception e) {
				System.out.println("파일 업로드 예외:" + 
					e.getMessage());
			}
		}
		
		//DAO 파라미터 만들기
		Item item = new Item();
		item.setItemid(itemid);
		item.setItemname(itemname);
		item.setPrice(price);
		item.setDescription(description);
		item.setPictureurl(pictureurl);
		
		Serializable s = itemDao.insert(item);
		Map<String, Object>result = 
				new HashMap<String, Object>();
		if(s != null) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		request.setAttribute("result", result);
		
		
		

	}

}
