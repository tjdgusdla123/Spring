<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src= "${pageContext.request.contextPath}/user/js/boardlist.js"></script>
<meta charset="UTF-8">
<title>게시판 목록</title>
   <div id="boardlist"></div>
   	<select name="searchType" id="searchType">

					<option value="boardTitle">제목</option>
					<option value="boardContent">본문</option>
					<option value="memberNickname">작성자</option>
				</select>
<input type="text" name="keyword" id="keyword">
<button name="searchtype" id="searchtype">검색</button>
<button name="boardwrite" id="boardwrite">글쓰기</button>
   <span id="boardpage"></span>
</body>
</html>