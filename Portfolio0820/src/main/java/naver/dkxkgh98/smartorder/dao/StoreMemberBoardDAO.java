package naver.dkxkgh98.smartorder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.dkxkgh98.smartorder.domain.StoreMemberBoard;

@Repository
public class StoreMemberBoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//게시글 작성
	public int memberBoardWrite(StoreMemberBoard storeMemberBoard) {
		System.out.println("StoreMemberBoardDAO-storeMemberBoard:"+storeMemberBoard);
		return sqlSession.insert("storememberboard.memberboardwrite",storeMemberBoard);
	}
	
   //게시글 목록 
	public List<StoreMemberBoard>memberBoardList(Map<String,Object>map){
		System.out.println("dao 전체데이터 가져오기 "+sqlSession);
		return sqlSession.selectList("storememberboard.memberboardlist",map);
		
		
	}
	//게시글 상세보기 
    public StoreMemberBoard memberBoardDetail(int boardBno) {
    	System.out.println("dao 상세보기 "+sqlSession);
    	return sqlSession.selectOne("storememberboard.memberboarddetail",boardBno);
   	
    }
   //글번호를 가지고 조회수 1증가 시키기 
    public int memberBoardUpdateReadcnt(int boardBno) {
    	return sqlSession.update("storememberboard.memberboardupdatereadcnt",boardBno);
    }
    //데이터 개수를 찾아오는 메소드 
	public int memberBoardCount(Map<String,Object>map) {
		return sqlSession.selectOne("storememberboard.memberboardcount",map);
		                                              
	}
}
