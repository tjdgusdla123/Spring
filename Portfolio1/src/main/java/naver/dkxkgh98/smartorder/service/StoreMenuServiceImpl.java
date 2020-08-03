package naver.dkxkgh98.smartorder.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.dkxkgh98.smartorder.dao.StoreMenuDAO;
import naver.dkxkgh98.smartorder.domain.StoreMenu;



@Service
public class StoreMenuServiceImpl implements StoreMenuService {
@Autowired
private StoreMenuDAO storeMenuDao;

@Override
//메뉴를 닉네임과 섹션을 이용해서 가져오기 
public void getMenu(HttpServletRequest request, HttpServletResponse response) {
	//파라미터읽기
	String menuSection =request.getParameter("menusection");
	String storeNickname =request.getParameter("storenickname");
	System.out.println("StoreMenuServiceImpl.getmenu.menuSection 파라미터 : " + menuSection);
	System.out.println("StoreMenuServiceImpl.getmenu.storeNickname 파라미터 : " + storeNickname);
	
	StoreMenu storeMenu =new StoreMenu();
	storeMenu.setMenuSection(menuSection);
	storeMenu.setStoreNickname(storeNickname);
	System.out.println("StoreMenuServiceImpl.getmenu.storeMenu : " + storeMenu);
	System.out.println("StoreMenuServiceImpl.getmenu-storeMenu-storeNickname : " + storeNickname);;
	System.out.println("StoreMenuServiceImpl.getmenu-storeMenu-menuSection : " + menuSection);

	List<StoreMenu> list =storeMenuDao.getMenu(storeMenu);

	
	System.out.println("StoreMenuServiceImpl.getmenu.list : " + list);
	
	request.setAttribute("list", list);
}

	
}
