package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.domain.GoodVO;

//bean을 자동 생성할 수 있도록 해주는 어노테이션
//Component, Controller, Service, Repository
@Repository
public class GoodDAO {
	//데이터베이스 연동 프레임워크의 변수
	//동일한 자료형의 bean이 있으면 자동으로 주입해주는 어노테이션
	@Autowired
	private SqlSession sqlSession;
	
	//테이블의 전체 데이터를 가져오는 메소드
	public List<GoodVO>allgood(){
		return sqlSession.selectList("good.allgood");		
	}
}
