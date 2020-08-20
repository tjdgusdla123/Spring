<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 메뉴</title>
<!--  
<link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/allmenu.css">
</head>
<body>
	<div align="center" class="body">
         <h1>김밥지옥</h1>
		<h2>전체메뉴</h2>
		<table border="1">
			<tr class="header">
			     <th width="70">가게닉네임</th> 
			     <th width="70">메뉴구분</th>				
			
				<th width="50">번호</th>
					<th width="300">메뉴명</th>
				<th width="50">가격</th>

			
			</tr>
			
			<c:forEach var="storemenu" items="${list}">
            <tr class="record">           
             <td width="70">${storemenu.storenickname}</td>
             <td width="70">${storemenu.menusection}</td>
              <td width="50">${storemenu.menucode}</td>
            <td width="50"><a href="detailstoremenu/${storemenu.menucode}">${storemenu.menuname}</td>                 
            <td width="80">${storemenu.menuprice}원</td>
             
             <a href="${pageContext.request.contextPath}/" class="menu" > 이전      
        </tr>
        </c:forEach>
	</table>
</body>
</html>  -->