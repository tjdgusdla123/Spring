<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/join.css">
<script src= "${pageContext.request.contextPath}/user/js/join.js"></script>

</head>
<body>
	<form   id="joinform"  enctype="multipart/form-data" >

		<h2 align ="center">회원가입</h2>
		<div align="center" id="msg"></div>
		<ul>
			<li>
				<label for="memberemail">이메일</label> 
				<input type="email" id="memberemail" name="memberemail" class="textinput" placeholder="이메일 주소를 입력하세요" />
			</li>
			<div id="memberemailmsg"></div>
			<li>
				<label for="memberpassword">비밀번호</label> 
				<input type="password" id="memberpassword" name="memberpassword" class="textinput" placeholder="비밀번호를 입력하세요"  maxlength="16"/>
			</li>
			<div id="memberpasswordmsg"></div>
			<li>
				<label for="memberpassword1">비밀번호확인</label> 
				<input type="password" id="memberpassword1" class="textinput"  placeholder="비밀번호확인" maxlength="16"/>
			</li>
	         <li>
				<label for="memberphonenumber">전화번호</label> 
				<input type="text" id="memberphonenumber" class="textinput" name="memberphonenumber" placeholder="전화번호를입력하세요" />
			</li>
			<div id="memberphonenumbermsg"></div>
			<li>
				<label for="membernickname">닉네임</label> 
				<input type="text" id="membernickname" name="membernickname" class="textinput" placeholder="닉네임을입력하세요" />
				
			</li>
			<div id="membernicknamemsg"></div>
						<li class="buttons">
				<input type="button" value="회원가입"  id="joinbtn"/> 
				<input type="button" value="메인" id="mainbtn" /> 
				<input type="button" value="로그인" id="loginbtn" />
			</li>
		</ul>
	</form>
</body>
</html>