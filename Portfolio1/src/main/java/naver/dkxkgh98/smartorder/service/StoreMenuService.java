package naver.dkxkgh98.smartorder.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StoreMenuService {
    //버튼을 눌렀을때 섹션별로 가저올수있는 메소드 (닉네임과 센션을 이용하여 닉네임에 해당하는 섹션을 찾아서 보여질수있다(데이터 읽기))
	public void getMenu(HttpServletRequest request, HttpServletResponse response);
}
