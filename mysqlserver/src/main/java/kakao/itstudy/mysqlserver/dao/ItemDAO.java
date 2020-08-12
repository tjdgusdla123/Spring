package kakao.itstudy.mysqlserver.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kakao.itstudy.mysqlserver.domain.Item;

@Repository
public class ItemDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	//searchtype 과 keyword를 받아서
	//데이터의 개수를 리턴해주는 메소드 
	//개수를 찾는 몇 페이지까지 출력할 수 있는지 확인하기 위해서 필요
	public int count(Map<String, Object> map){
		int result = -1;
		
		
		return result;
	}
	//searchtype 과 keyword
	//데이터의 시작번호와 페이지 당 데이터 개수를 받아서
	//조건에 맞는 데이터의 목록을 리턴 
	public List<Item> list(Map<String, Object> map){
		List<Item> list = null;
		
		return list;
	}
	
	//기본키를 가지고 하나의 데이터를 찾아오는 메소드
	public Item detail(int itemid) {
		Item item = null;
		
		return item;
	}
	
	//데이터를 삽입할 때 itemid를 가장 큰 itemid 에 +1을 할 예정
	//가장 큰 itemid를 가져오는 메소드
	public int maxid() {
		int result = -1;
		
		return result;
	}
	
	//데이터 삽입하는 메소드
	public Serializable insert(Item item) {
		//save는 입력된 기본키의 값을 리턴합니다.
		//어떤 자료형일지 몰라서 Serializable로 리턴
		
		return sessionFactory.getCurrentSession().save(item);
	}

}




