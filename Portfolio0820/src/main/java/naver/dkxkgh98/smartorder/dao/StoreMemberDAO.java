package naver.dkxkgh98.smartorder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.dkxkgh98.smartorder.domain.StoreMember;

@Repository
public class StoreMemberDAO {
@Autowired
//MyBatis 를 xml로 이용할 때 사용하는 클래스
private SqlSession sqlSession;

public List<StoreMember>allstoremember(){
	return sqlSession.selectList("storemember.allstoremember");
	
}
    public StoreMember detailstoremember(String membernickname) {	    	                                        
    	System.out.println("DAO닉네임"+membernickname);
    	return sqlSession.selectOne("storemember.detailstoremember",membernickname);
    	
    }
    
    //이메일 중복 체크 메소드
//    public List<String> memberemailCheck() {
//		return sqlSession.selectList("storemember.memberemailcheck");
//    	
//    }
    //이메일 중복 체크 메소드
    public String memberemailCheck(String memberemail) {
    	System.out.println(memberemail);
    	return sqlSession.selectOne("storemember.memberemailcheck",memberemail);
		
    	
    }
    
    //닉네임 중복 체크 메소드
    public String membernicknameCheck(String membernickname) {
		return sqlSession.selectOne("storemember.membernicknamecheck",membernickname);
    	
    }
	
	 //회원가입 처리 메소드
    public int join(StoreMember storeMember) {
    	System.out.println(storeMember);
		return sqlSession.insert("storemember.join",storeMember);
    	
    }
    //로그인 처리 메소드
    public StoreMember login(String membernickname){
    	return sqlSession.selectOne("storemember.login",membernickname);
    	
    }
    
}
