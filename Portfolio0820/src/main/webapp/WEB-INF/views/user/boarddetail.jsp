<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>
		<img src="${pageContext.request.contextPath}/img/${storeMemberBoard.boardFile}" id="img" width="100"height="100" border="1" /> <br />
			<div class="box-body">
				<div class="form-group">
					<label>제목</label> <input type="text" name="boardtitle"
						class="form-control" value="${storeMemberBoard.boardTitle}" readonly="readonly" />
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea name="content" rows="5" readonly="readonly"
						class="form-control">${storeMemberBoard.boardContent}</textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> <input type="text" class="form-control"
						value="${storeMemberBoard.memberNickname}" readonly="readonly" />
				</div>
			
        
			</div>
			<div class="box-footer">
				<button class="btn btn-success" id="mainbtn">메인</button>
				<c:if test="${storememberinfo.membernickname == storeMemberBoard.memberNickname}">
					<button class="btn btn-warning" id="updatebtn">수정</button>
					<button class="btn btn-danger" id="deletebtn">삭제</button>
				</c:if>
				<button class="btn btn-primary" id="listbtn">목록</button>
			</div>
		</div>
	</section>


</body>
</html>