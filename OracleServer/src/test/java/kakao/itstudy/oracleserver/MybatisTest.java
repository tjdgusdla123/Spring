package kakao.itstudy.oracleserver;

import java.util.HashMap;
import java.util.Map;

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

public class MybatisTest {
	
	
	@Autowired
	private SqlSession sqlSession;

	@Test
    public void mybatisConfigTest() {
		System.out.println(sqlSession);
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("데이터 개수:"+sqlSession.selectOne("item.count",map));
	}

	
}
