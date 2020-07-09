package kr.co.pk.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {
	//생성자
	public DownloadView() {
		//형식을 설정
		setContentType(
			"application/download; charset=utf-8");
	}
	
	//출력할 뷰를 그리는 메소드
	//model 은 Controller에서 전달한 데이터
	//request는 클라이언트의 요청 정보를 저장
	//response는 클라이언트에게 응답할 정보를 저장
	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//파일의 절대 경로 만들기
		//절대 경로는 운영체제에 따라 디렉토리 표현 방법이 다릅니다.
		//windows는 \\ 그 이외 운영체제는 /
		//상대경로는 무조건 /
		String filename = (String)model.get("filename");
		//이 라인도 출력이 안되면 servlet-context.xml을 잘못 설정
		//null이 출력되면 get 할 때의 이름이 잘못되었던가 request에 저장하고 model로 읽은 것
		System.out.println(filename);
		
		//경로는 맞는데 다운로드가 안되면 /를 \\으로 변경
		String filePath = 
			request.getServletContext().getRealPath("/img")
			+ "/" + filename;
		File file = new File(filePath);
		
		//파일의 형식과 크기를 설정
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		//브라우저 종류를 판단
		//파일명에 한글이 있을 때 인코딩 방식때문에 판단
		String userAgent = request.getHeader("User-Agent");
		//IE에서 접속하면 userAgent에 rv라는 문자열이 포함되어 있음
		boolean ie = userAgent.indexOf("rv") > -1;
		
		//파일이름 설정
		String fileName = null;
		if(ie) {
			fileName = URLEncoder.encode(
				file.getName(), "utf-8");
		}else {
			fileName = new String(
					file.getName().getBytes("utf-8"),
					"iso-8859-1");
		}
		response.setHeader("Content-Disposition",
				"attachment; filename=\"" + 
				fileName + "\";");
		
		//파일 다운로드 받는 로직
		response.setHeader("Content-Transfer-Encoding",
				"binary");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis,  out);
		}finally {
			if(fis != null) {
				try {
					fis.close();
				}catch(Exception e) {}
			}
		}
		out.flush();
	}
}





