<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- exception 객체를 사용할 수 있는 페이지 -->
<%@ page isErrorPage = "true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 페이지</title>
</head>
<body>
	서버에 장애가 발생했습니다.<br/>
	빠른 시간 내에 조치하겠습니다.<br/>
	예외내용:${result}
</body>
</html>