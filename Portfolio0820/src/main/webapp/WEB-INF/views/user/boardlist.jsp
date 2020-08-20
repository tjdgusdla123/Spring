<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<div class="box-body">
		<table class="bordered" border="1">
			<tr>
				<th width="11%">글번호</th>
				<th width="46%">제목</th>
				<th width="16%">작성자</th>
				<th width="16%">작성일</th>
				<th width="11%">조회수</th>
			</tr>
			<c:forEach var="storememberboard" items="${map}">
				<tr>                                
					<td align="right">"${map.boardBno}&nbsp;</td>
					<td>&nbsp;<a href="boarddetail/${remapsult.boardBno}"> ${storememberboard.boardTitle}</td></a>
					<td>&nbsp;${map.memberNickname}</td>
					<td>&nbsp; ${map.boardDispdate}</td>
					<td align="right"><span class="badge bg-blue">
							${map.boardReadcnt}</span>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="box-footer">
		<div class="text-center">
			<button id='mainBtn' class="btn-primary">메인으로</button>
		</div>
</body>
</html>