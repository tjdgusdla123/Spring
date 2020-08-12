package kakao.itstudy.oracleserver;



import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kakao.itstudy.oracleserver.dao.ItemDAO;
import kakao.itstudy.oracleserver.domain.Item;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = 
	{"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MybatisTest {
	//MyBatis 객체
	@Autowired
	private SqlSession sqlSession;
	
	//MyBatis 설정 테스트
//	@Test
//	public void mybatisConfigTest() {
//		System.out.println(sqlSession);
//		
//		/*
//		//아무런 조건없이 테스트
//		Map<String, Object> map = 
//				new HashMap<String,Object>();
//		System.out.println("데이터 개수:" + 
//			sqlSession.selectOne(
//					"item.count", map).toString());
//		map.put("start", 1);
//		map.put("end", 2);
//		System.out.println("데이터 목록:" + 
//				sqlSession.selectList(
//						"item.list", map).toString());
//		
//		//description에 비타민이 포함된 데이터 개수 
//		map.put("searchtype", "description");
//		map.put("keyword", "비타민");
//		System.out.println("데이터 개수:" + 
//				sqlSession.selectOne(
//						"item.count", map).toString());
//		System.out.println("데이터 목록:" + 
//				sqlSession.selectList(
//						"item.list", map).toString());
//		*/
//		
//		//상세보기 테스트
//		/*
//		System.out.println(sqlSession.selectOne(
//				"item.detail", 1).toString());
//				*/
//		
//		//가장 큰 itemid 찾아오기
//		int maxid = sqlSession.selectOne("item.maxid");
//		System.out.println(maxid);
//		//삽입
//		kakao.itstudy.oracleserver.domain.Item item = new Item();
//		item.setItemid(maxid + 1);
//		item.setItemname("망고");
//		item.setPrice(3000);
//		item.setDescription("노란 과일");
//		item.setPictureurl("default.jpg");
//		//MyBatis는 AutoCommit이어서 테스트 할 때 삽입하면
//		//데이터가 실제 삽입이 됩니다.
//		//Hibernate는 테스트할 때 결과만 확인할 수 있고
//		//마지막에 rollback을 수행
//		int row = sqlSession.insert("item.insert", item);
//		System.out.println("영향받은 행의 개수:" + row);
//	}
	//DAO 테스트 
	
	//DAO 테스트
		@Autowired
		private ItemDAO itemDao;
		
		@Test
		public void daoTest() {
			//DAO 확인
			//System.out.println(itemDao);
			
			/*
			Map<String, Object> map = 
					new HashMap<String, Object>();
			map.put("searchtype", "description");
			map.put("keyword", "비타민");
			System.out.println(itemDao.count(map));
			*/
			
			/*
			Map<String, Object> map = 
					new HashMap<String, Object>();
			map.put("searchtype", "description");
			map.put("keyword", "비타민");
			map.put("start", 1);
			map.put("end", 3);
			System.out.println(itemDao.list(map));
			*/
			
			//System.out.println(itemDao.detail(3));
			
			//System.out.println(itemDao.maxid());
			
			Item item = new Item();
			item.setItemid(8);
			item.setItemname("과자");
			item.setPrice(2000);
			item.setDescription("애들이 좋아함");
			item.setPictureurl("default.jpg");
			System.out.println(itemDao.insert(item));
			
			
		}
	}

