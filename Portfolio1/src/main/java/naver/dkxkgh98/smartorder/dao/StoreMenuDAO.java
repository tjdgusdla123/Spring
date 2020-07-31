package naver.dkxkgh98.smartorder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.dkxkgh98.smartorder.domain.StoreMenu;

@Repository
public class StoreMenuDAO {
	// MyBatis를 xml로 이용할 때 사용하는 클래스 
	private SqlSession sqlSession;
	
	//버튼을 눌렀을때 섹션 닉네을이용해서 가져오기위한 메소드
	//예를들어 닉네임으로만 가져온다면 전체 메뉴를 가져오게된다 하지만 섹션과 닉네임을 같이 사용한다면 주류만 눌렀을때는 주류만 아니면 메인메뉴만 눌렀을 때는 메인 메뉴만 나올수있다.
    public List<StoreMenu> getMenu(StoreMenu storeMenu){
		
    	return sqlSession.selectList("storemenu.getmenu",storeMenu);
    	
    	
    	
    }
}
