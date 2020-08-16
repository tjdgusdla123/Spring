package kakao.itstudy.mysqlserver.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ItemService {
	//데이터 목록을 가져오는 메소드
	public void list(HttpServletRequest request);
	
	//상세보기를 위한 메소드
	public void detail(HttpServletRequest request);
	
	//데이터 삽입을 위한 메소드 - 파일 업로드 존재
	public void insert(MultipartHttpServletRequest request);
}
