package kakao.itstudy.oracleserver;



import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class DataSourceTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;

	@Test
	public void sqlSessionTest()throws Exception{
		//데이터베이스 연결 테스트
		System.out.println(dataSource.getConnection().toString());
		
		//MyBatis 설정 테스트 
		System.out.println(sqlSession.toString());
	}

}
