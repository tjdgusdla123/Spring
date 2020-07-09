package kr.co.pk.item.domain;

public class Member {
	private String email;
	private String password;
	private String loginType;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	@Override
	public String toString() {
		return "Member [email=" + email + ", password=" + password + ", loginType=" + loginType + "]";
	}
}
