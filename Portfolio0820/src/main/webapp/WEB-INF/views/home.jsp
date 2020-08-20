<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp를 이용해서 데이터를 출력할 때는 이 코드는 거의 필수 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>


</head>
<body>

	<!-- 바로 user/main으로 포워딩 하도록 해주는 코드 -->
	<!-- 전자 정보 프레임워크가 만들어주는 프로젝트에서 index.jsp에 보면 이런 코드가 존재합니다. -->
	<jsp:forward page="user/main"></jsp:forward>      
</body>
</html>