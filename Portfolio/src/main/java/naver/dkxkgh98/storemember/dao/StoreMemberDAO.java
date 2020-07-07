package naver.dkxkgh98.storemember.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreMemberDAO {
@Autowired
//MyBatis 를 xml로 이용할 때 사용하는 클래스
private SqlSeeion sqlSession;
}
