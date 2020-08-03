package naver.dkxkgh98.smartorder;

import java.util.Date;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import naver.dkxkgh98.smartorder.domain.StoreMenu;



//Spring에서 JUnit4 라이브러를 사용하기 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)
//locations에 설정된 파일들을 실행시켜서 메로리에 로드하기 위한설정
//프레임워크마다 설정파일의 경로가 다르므로 web.xml에 설정된 내용을 확인하고
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class StoreMemberTest {
	//데이터베이스 연견을 확일할 때 주입
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;

    
	//@Test
	//public void mybatisTest() {
	// System.out.println(sqlSession);
	// }
	
	//@Test
	//public void detailstroemember() {
	//	System.out.println(sqlSession.selectOne("TestsqlSession"+"storemember.detailstoremember", 1));

	//}

//	@Test
	//public void ConnectTest() {
	//	try {
	//		System.out.println("Test connectTest:"+dataSource.getConnection());
		//} catch (Exception e) {
		//	System.out.println(e.getMessage());
		//	
		//	e.printStackTrace();
		//}
//	}
	@Test
	public void getmainmenutest() {
		StoreMenu storeMenu = new StoreMenu();
		storeMenu.setMenuSection("주류");
		storeMenu.setStoreNickname("털보");
	
		
		System.out.println(sqlSession.selectList("storemenu.getmenu", storeMenu));
		
	}
	

	
	
}
