package domain;
import java.util.Date;
	import java.util.Date;

	public class MemberInfoTBL {
		
			private String membernickname;  // 회원별명
			private String membermail;      // 회원이메일 
			private String	memberpassword;   // 회원비밀번호 
			private String	memberphonenumber;  //회원전화번호
			private String	memberissignup;  // 회원탈퇴여부 
			private String	memberislogin;   // 회원로그인여부
			private Date	memberlastlogindate;  // 회원마지막로그인날짜 
			public MemberInfoTBL() {
				super();
				
			}
			public String getMembernickname() {
				return membernickname;
			}
			public void setMembernickname(String membernickname) {
				this.membernickname = membernickname;
			}
			public String getMembermail() {
				return membermail;
			}
			public void setMembermail(String membermail) {
				this.membermail = membermail;
			}
			public String getMemberpassword() {
				return memberpassword;
			}
			public void setMemberpassword(String memberpassword) {
				this.memberpassword = memberpassword;
			}
			public String getMemberphonenumber() {
				return memberphonenumber;
			}
			public void setMemberphonenumber(String memberphonenumber) {
				this.memberphonenumber = memberphonenumber;
			}
			public String getMemberissignup() {
				return memberissignup;
			}
			public void setMemberissignup(String memberissignup) {
				this.memberissignup = memberissignup;
			}
			public String getMemberislogin() {
				return memberislogin;
			}
			public void setMemberislogin(String memberislogin) {
				this.memberislogin = memberislogin;
			}
			public Date getMemberlastlogindate() {
				return memberlastlogindate;
			}
			public void setMemberlastlogindate(Date memberlastlogindate) {
				this.memberlastlogindate = memberlastlogindate;
			}
			@Override
			public String toString() {
				return "MemberInfoTBL [membernickname=" + membernickname + ", membermail=" + membermail
						+ ", memberpassword=" + memberpassword + ", memberphonenumber=" + memberphonenumber
						+ ", memberissignup=" + memberissignup + ", memberislogin=" + memberislogin
						+ ", memberlastlogindate=" + memberlastlogindate + "]";
			}
			
}