package kakao.itstudy.oracleserver.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kakao.itstudy.oracleserver.domain.Item;

@Repository
public class ItemDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//searchtype 과 keyword를 이용해서 데이터 개수 찾아오는 메소드
	public int count(Map<String, Object> map) {
		return sqlSession.selectOne("item.count", map);
	}
	//searchtype 과 keyword 와 start 와 end를 데이터 목록을 찾아오는 메소드
	public List<Item> list(Map<String, Object>map){
		return sqlSession.selectList("item.list", map);
	}
	
	//itemid에 해당하는 데이터 1개를 메소드
	public Item detail(int itemid) {
		return sqlSession.selectOne("item.detail", itemid);
	}
	
	//가장 큰 itemid를 찾아오는 메소드
	public int maxid() {
		return sqlSession.selectOne("item.maxid");
	}
	
	//데이터를 삽입하는 메소드 
	public int insert(Item item) {
		return sqlSession.insert("item.insert", item);
	}
}




