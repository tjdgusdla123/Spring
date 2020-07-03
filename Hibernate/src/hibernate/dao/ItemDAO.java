package hibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernate.domain.Item;

@Repository
public class ItemDAO {
	@Autowired
    //하이버네이트 사용 객체
	private SessionFactory sessionFactory;
	
	//데이터 수정
	//기본키를 조건으로 해서 마머지 항목을 수정 없는 기본키를 대입하면 아무일도 하지 않습니다.
	@Transactional
	public void insert() {
		Item item =new Item();
		item.setCode(3);
		item.setName("문어");
		item.setManufacture("여수");
		item.setPrice(5000);
		item.setBuiltdate(new Date());
		//데이터 삽입
		//sessionFactory.getCurrentSession().save(item);
			
	}
		@Transactional
		public void update() {
			Item item =new Item();
			item.setCode(2);
			item.setName("문어");
			item.setManufacture("여수");
			item.setPrice(5000);
			item.setBuiltdate(new Date());
			//데이터 수정
			//sessionFactory.getCurrentSession().update(item);				
		}		
		//데이터 삭제
		//기본키 항목이외는 아무것도 필요없습니다.기본키를 조건으로 해서 삭제
		@Transactional
		public void delete() {
			Item item =new Item();
			item.setCode(3);							
		//데이터 삭제	
		//sessionFactory.getCurrentSession().delete(item);
		}
		//전체 데이터 가져오기
		//@Transactional
		//public void list() {
			//전체 데이터 가져오기
			//Critera 사용
			//List<Item> list = (List<Item>)sessionFactory.getCurrentSession().createCriteria(Item.class).list();			
			
			//SQL 사용
			//List<Item> list = sessionFactory.getCurrentSession().createSQLQuery("select * from item").addEntity(Item.class).list();
			//데이터 출력
			//for(Item item : list) {
				//System.out.println(item);
		//	}
	//	}		
		
		//기본키를 가지고 데이터 1개 가져오기
				@Transactional
				public void getItem() {
					//Criteria 사용
					Item item = sessionFactory.getCurrentSession().get(Item.class, 1);
					System.out.println(item);
					
				}
}
