package kakao.itggangpae1.mysqlserver.domain;

import lombok.Data;

@Data
public class Member {
	private String email;
	private String pw;
	private String nickname;
	private String profile;
}
