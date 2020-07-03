package domain;

import java.util.Date;

import lombok.Data;

import java.util.Date;
@Data
public class MemberInfoTBL {

	private String membernickname; // 회원별명
	private String membermail; // 회원이메일
	private String memberpassword; // 회원비밀번호
	private String memberphonenumber; // 회원전화번호
	private String memberissignup; // 회원탈퇴여부
	private String memberislogin; // 회원로그인여부
	private Date memberlastlogindate; // 회원마지막로그인날짜

}