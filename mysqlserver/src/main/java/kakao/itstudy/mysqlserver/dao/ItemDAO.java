package kakao.itstudy.mysqlserver.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kakao.itstudy.mysqlserver.domain.Item;

@Repository
public class ItemDAO {
	@Autowired
	private SessionFactory sessionFactory;
	//select는 nativequery를 이용 
	
	//searchtype 과 keyword를 받아서
	//데이터의 개수를 리턴해주는 메소드 
	//개수를 찾는 몇 페이지까지 출력할 수 있는지 확인하기 위해서 필요
	public int count(Map<String, Object> map){
		int result = -1;
		//searchtype이 없는 경우에는 전체 데이터 개수 찾아오기
		//searchtype이 있으면 keyword가 포함된 데이터 개수 찾아오기
		//searchtype은 itemname, description, both(itemname, description)
		
		//파라미터를 찾아오기 - ServiceImpl에서
		//이 이름으로 파라미터를 만들어 주어야 합니다. 
		String searchtype = 
				(String)map.get("searchtype");
		String keyword = 
				(String)map.get("keyword");
		if(searchtype != null) {
			keyword = "%" + keyword + "%";
		}
		
		//hibernate에서 데이터개수를 찾아오면 BigInteger로 리턴
		//결과를 저장할 변수 
		List<BigInteger> list = null;
		if(searchtype == null || searchtype.equals("")) {
			list = sessionFactory.getCurrentSession()
				.createNativeQuery(
						"select count(*) from item")
				.getResultList();	
		}else if("itemname".equals(searchtype)) {
			//파라미터를 매핑해서 SQL을 완성 
			String sql = "select count(*) from item "
					+ "where itemname like :keyword";
			Query query = sessionFactory.getCurrentSession()
					.createNativeQuery(sql);
			query.setParameter("keyword", keyword);
			list = query.getResultList();
		}else if("description".equals(searchtype)) {
			//파라미터를 매핑해서 SQL을 완성 
			String sql = "select count(*) from item "
					+ "where description like :keyword";
			Query query = sessionFactory.getCurrentSession()
					.createNativeQuery(sql);
			query.setParameter("keyword", keyword);
			list = query.getResultList();
		}else if("both".equals(searchtype)) {
			//파라미터를 매핑해서 SQL을 완성 
			String sql = "select count(*) from item "
					+ "where itemname like :itemname or "
					+ "description like :description";
			Query query = sessionFactory.getCurrentSession()
					.createNativeQuery(sql);
			query.setParameter("itemname", keyword);
			query.setParameter("description", keyword);
			list = query.getResultList();
		}
		if(list != null && list.size() > 0) {
			result = list.get(0).intValue();
		}
		return result;
	}
	//searchtype 과 keyword
	//MySQL은 데이터의 시작번호와 페이지 당 데이터 개수를 받아서
	//시작번호는 0에서부터 시작 
	//조건에 맞는 데이터의 목록을 리턴 
	public List<Item> list(Map<String, Object> map){
		List<Item> list = null;
		
		//파라미터 가져오기
		String searchtype = (String)map.get("searchtype");
		String keyword = (String)map.get("keyword");
		int start = (Integer)map.get("start");
		int size = (Integer)map.get("size");
		
		if(searchtype != null) {
			keyword = "%" + keyword + "%";
		}
		
		String sql = null;
		Query query = null;
		
		if(searchtype == null || searchtype.equals("")) {
			sql = "select * from item "
					+ "order by itemid desc "
					+ "limit :start, :size";
			//Item.class를 생략해도 되지만 
			//생략하면 배열의 배열이 될 것이고
			//생략하지 않으면 객체의 배열이 됩니다. 
			query = sessionFactory.getCurrentSession()
					.createNativeQuery(sql, Item.class);
			query.setParameter("start", start);
			query.setParameter("size", size);	
		}else if("itemname".equals(searchtype)) {
			sql = "select * from item "
					+ "where itemname like :itemname "
					+ "order by itemid desc "
					+ "limit :start, :size";
			//Item.class를 생략해도 되지만 
			//생략하면 배열의 배열이 될 것이고
			//생략하지 않으면 객체의 배열이 됩니다. 
			query = sessionFactory.getCurrentSession()
					.createNativeQuery(sql, Item.class);
			query.setParameter("itemname", keyword);
			query.setParameter("start", start);
			query.setParameter("size", size);	
		}else if("description".equals(searchtype)) {
			sql = "select * from item "
					+ "where description like :description "
					+ "order by itemid desc "
					+ "limit :start, :size";
			//Item.class를 생략해도 되지만 
			//생략하면 배열의 배열이 될 것이고
			//생략하지 않으면 객체의 배열이 됩니다. 
			query = sessionFactory.getCurrentSession()
					.createNativeQuery(sql, Item.class);
			query.setParameter("description", keyword);
			query.setParameter("start", start);
			query.setParameter("size", size);	
		}else if("both".equals(searchtype)) {
			sql = "select * from item "
					+ "where itemname like :itemname "
					+ "or description like :description "
					+ "order by itemid desc "
					+ "limit :start, :size";
			//Item.class를 생략해도 되지만 
			//생략하면 배열의 배열이 될 것이고
			//생략하지 않으면 객체의 배열이 됩니다. 
			query = sessionFactory.getCurrentSession()
					.createNativeQuery(sql, Item.class);
			query.setParameter("itemname", keyword);
			query.setParameter("description", keyword);
			query.setParameter("start", start);
			query.setParameter("size", size);	
		}
		return list;
	}
	
	//기본키를 가지고 하나의 데이터를 찾아오는 메소드
	public Item detail(int itemid) {
		Item item = null;
		/*
		String sql = null;
		Query query = null;
		
		
		sql = "select * from item where itemid = :itemid";
		query = sessionFactory.getCurrentSession()
				.createNativeQuery(sql, Item.class);
		query.setParameter("itemid", itemid);
		*/
		
		//기본키를 가지고 1개 찾아오는 경우는 sql 필요 없음
		item = sessionFactory.getCurrentSession().get(
				Item.class, itemid);
		
		return item;
	}
	
	//데이터를 삽입할 때 itemid를 가장 큰 itemid 에 +1을 할 예정
	//가장 큰 itemid를 가져오는 메소드
	public int maxid() {
		int result = -1;
		
		List<Integer>list = 
				sessionFactory.getCurrentSession()
				.createNativeQuery(
						"select max(itemid) from item")
				.getResultList();
		result = list.get(0);
		return result;
	}
	
	//데이터 삽입하는 메소드
	public Serializable insert(Item item) {
		//save는 입력된 기본키의 값을 리턴합니다.
		//어떤 자료형일지 몰라서 Serializable로 리턴
		
		return sessionFactory.getCurrentSession().save(item);
	}

}




