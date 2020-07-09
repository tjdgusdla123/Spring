<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- spring 태그를 사용하기 위한 설정 -->    
<%@ taglib prefix="spring"
uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="loginform.title" /></title>
</head>
<body>
	<form:form modelAttribute="member">
		<spring:message code="email" />
		<form:input path="email"/><br/>
		<spring:message code="password" />
		<form:password path="password"/><br/>
		<form:select path="loginType" items="${loginTypes}"/>
		<p><spring:message code="loginform.help"/></p>
		<input type="submit" value="로그인"/>
	</form:form>
</body>
</html>