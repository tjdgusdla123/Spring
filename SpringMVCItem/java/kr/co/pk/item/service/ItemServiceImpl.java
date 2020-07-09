package kr.co.pk.item.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.pk.item.dao.ItemDAO;
import kr.co.pk.item.dao.ItemMapper;
import kr.co.pk.item.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAO itemDao;
	
	//private ItemMapper itemDao;

	@Override
	@Transactional
	public void allitem(HttpServletRequest request, HttpServletResponse response) {
		//1.파라미터 읽기
		
		//2.필요한 처리 수행
		
		//3.DAO 메소드의 매개변수 생성
		
		//4.DAO 메소드를 호출
		List<Item> list = itemDao.allitem();
		//5.결과를 가공
		
		//6.결과를 저장 - REST API Server의 경우는 request에 저장
		request.setAttribute("list", list);
		
		
	}

	@Override
	@Transactional
	public void detailitem(HttpServletRequest request, HttpServletResponse response) {
		//요청 주소의 마지막 부분을 가져오기
		//localhost/detail/itemid
		String requestURI = request.getRequestURI();
		String [] ar = requestURI.split("/");
		String itemid = ar[ar.length-1];
		
		//DAO의 메소드를 호출
		Item item = itemDao.detailitem(Integer.parseInt(itemid));
		//결과를 저장
		request.setAttribute("item", item);
	}

	@Override
	public void fileview(HttpServletRequest request, HttpServletResponse response) {
		//프로젝트 내의 디렉토리에 대한 절대 경로 가져오기
		String imgPath = 
				request.getServletContext().getRealPath("/img");
		//디렉토리 안의 모든 파일에 대한 이름을 가져오기 - File 클래스 이용
		File f = new File(imgPath);
		String [] fileList = f.list();
		
		//파일이름을 List에 저장하고 List를 request에 저장
		List<String> list = new ArrayList<String>();
		for(String imsi : fileList) {
			list.add(imsi);
		}
		//출력할 데이터 저장
		request.setAttribute("list", list);
		
	}
}











