package naver.dkxkgh98.smartorder.domain;
import java.util.Date;

import lombok.Data;

@Data
public class StoreMemberBoard {
	//회원게시판 테이블
	private Integer boardBno;  //글번
	private String  boardTitle; //글제목 
	private String  boardContent;//글내용
	private Date    boardRegdate; //작성일 
	private Date    boardUpdatedate;//수정일 
	private Integer boardReadcnt;//조회수 
	private String  boardIp;//작성한 곳의 아이피 
	private String  boardFile;//첨부파일  
	private String  memberNickname;//맴버 닉네임 
	private String  boardDispdate;


}
