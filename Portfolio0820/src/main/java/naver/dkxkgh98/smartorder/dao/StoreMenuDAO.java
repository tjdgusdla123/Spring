package naver.dkxkgh98.smartorder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.dkxkgh98.smartorder.domain.StoreMenu;

@Repository
public class StoreMenuDAO {
@Autowired
//MyBatis를 xml로 이용할 때 사용하는 클래스
private SqlSession sqlSession;

//전체데이터 가져오
//public List<StoreMenu> allstoremenu(){
	//System.out.println("dao 전체데이터 가져오기 "+sqlSession);
	//return sqlSession.selectList("storemenu.allstoremenu");
	
//}
public StoreMenu detailstoremenu(String menucode) {
	System.out.println("상세보기 dao : "+menucode);
return sqlSession.selectOne("storemenu.detailstoremenu", menucode);

}

public List<StoreMenu> getMenu(StoreMenu storeMenu) { 
	System.out.println("StoreMenudao 데이터 가져오기 "+storeMenu); 	
	 return sqlSession.selectList("storemenu.getmenu",storeMenu);
  
}

}
