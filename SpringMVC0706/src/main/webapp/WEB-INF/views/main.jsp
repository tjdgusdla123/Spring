<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- action은 생략하면 이 페이지에 오게된 요청 : form

method는 생략하면 get

enctype은 file이 있을 때만 multipart/form-data를 설정 -->
<form id="paramform"  method="post" >
		<h2 align ="center">회원가입</h2>
		<div align="center" id="msg"></div>
		<ul>
			<li>
				<label for="membermail">이메일</label> 
				<input type="text" id="membermail" name="membermail" class="textinput" placeholder="이메일 주소를 입력하세요" />
			</li>
			<li>
				<label for="memberpassword">비밀번호</label> 
				<input type="password" id="memberpassword" name="memberpassword" class="textinput" placeholder="비밀번호를 입력하세요"  maxlength="4"/>
			</li>
			<li>
				<label for="memberpassword1">비밀번호확인</label> 
				<input type="password" id="memberpassword1" class="textinput"  placeholder="비밀번호확인" maxlength="4"/>
			</li>

	         <li>
				<label for="memberphonenumber">전화번호</label> 
				<input type="text" id="memberphonenumber" class="textinput" placeholder="전화번호를입력하세요" />
			</li>
			<li>
				<label for="membernickname">닉네임</label> 
				<input type="text" id="membernickname" class="textinput" placeholder="닉네임을입력하세요" />
				<button >중복확인</button><br/>
			</li>
			

						<li class="buttons">
				<input type="submit" value="회원가입" /> 
				<input type="button" value="메인" id="" /> 
				<input type="button" value="로그인" id="ajaxbtn" />
				</form>
</body>
</html>