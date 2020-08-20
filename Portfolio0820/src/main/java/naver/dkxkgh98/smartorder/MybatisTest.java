package naver.dkxkgh98.smartorder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import naver.dkxkgh98.smartorder.dao.StoreMemberBoardDAO;
import naver.dkxkgh98.smartorder.domain.StoreMemberBoard;



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
	    //@Test
		//public void mybatisConfigTest() {
		//System.out.println(sqlSession);
        //카운트  확인 매퍼파일 확인 
		//Map<String, Object> map = new HashMap<String,Object>();
		//System.out.println("데이터 개수:" + sqlSession.selectOne("storememberboard.memberboardcount", map).toString());		
		//리스트 확인 매퍼파일 확인 
		//map.put("start", 1);
		//map.put("end", 5);
		//System.out.println("데이터 목록:" + sqlSession.selectList("storememberboard.memberboardlist", map).toString());
	   //상세보기 확인 
		//System.out.println("상세보기:"+ sqlSession.selectOne("storememberboard.memberboarddetail",1));
		//글 번호를 가지고 조회수 1증가시키는 sql 확인 (업데이트)
		//System.out.println("조회수 증가:"+ sqlSession.update("storememberboard.memberboardupdatereadcnt",5));
	 
		//게시글 삽입 확인 
//		StoreMemberBoard storeMemberBoard = new StoreMemberBoard();
//	   storeMemberBoard.setBoardBno(6);
//	   storeMemberBoard.setBoardTitle("매퍼파일테스트");
//	   storeMemberBoard.setBoardContent("매퍼파일 확인중입니다");
//	   storeMemberBoard.setMemberNickname("test2");
//	   storeMemberBoard.setBoardIp("1");
//	   storeMemberBoard.setBoardFile("default.jpg");
//	   
//	   int row = sqlSession.insert("storememberboard.memberboardwrite", storeMemberBoard);
//		System.out.println("영향받은 행의 개수:" + row);
//	   
//	}
		//DAO테스트
		@Autowired
		private StoreMemberBoardDAO storeMemberBoardDao;
		@Test 
		public void daoTest() {
			//DAO확인
		//System.out.println(storeMemberBoardDao);
			
			//검색타입에 키워드 에따라 데이터를 가져오기 확인 
			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("searchtype","both");
//			map.put("keyword","처음");
//			System.out.println(storeMemberBoardDao.memberBoardCount(map));
			
		    //글번호를 가져와서  조회수증가 시키기 확인 
			//System.out.println(storeMemberBoardDao.memberBoardUpdateReadcnt(5));
			
			//상세보기 확인 
			//System.out.println(storeMemberBoardDao.memberBoardDetail(5));
			
			//전체보기 확인 
			//map.put("searchtype","both");
			//map.put("keyword","짱");
			//map.put("start", 1);
			//map.put("end", 2);
			//System.out.println(storeMemberBoardDao.memberBoardList(map));
			
			//게시글 작성(삽입)
//		    StoreMemberBoard storeMemberBoard = new StoreMemberBoard();
//		    storeMemberBoard.setBoardBno(1);
//		    storeMemberBoard.setBoardIp("boardIp");
//		    storeMemberBoard.setBoardTitle("DAO확인");
//		    storeMemberBoard.setBoardContent("DAO확인중입니다.");
//		    storeMemberBoard.setBoardFile("default.jpg");
//		    storeMemberBoard.setMemberNickname("test2");
//		    System.out.println(storeMemberBoardDao.memberBoardWrite(storeMemberBoard));
//		    
		    
		    
		    
		}
		
}
