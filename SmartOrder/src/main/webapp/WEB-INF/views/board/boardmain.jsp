<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/board/css/boardmain.css">
<body>
  <h1>SmartOrder 게시판입니다. </h1>
	 <ul>
		<li><a href="${pageContext.request.contextPath}/boardlist">목록보기</a></li>
		<li><a href="${pageContext.request.contextPath}/boardwrite">게시물 쓰기</a></li>
		<li><a href="${pageContext.request.contextPath}/../">메인으로</a></li>
</body>
</html>