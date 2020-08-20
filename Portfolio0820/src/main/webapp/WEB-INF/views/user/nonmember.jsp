<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비회원 입장</title>

<script src= "${pageContext.request.contextPath}/user/js/nonmember.js"></script>
</head>
<body>
                <h2 align="center">스마트 오더입니다.</h2>
                <h3>털보 식당</h3>
                 
                
                
                
                
              <input type="button" value="메인메뉴"  id="mainmenubtn"/>  
             <input type="button" value="음료"  id="drinkmenubtn"/>
             <input type="button" value="주류"  id="alcoholbtn"/>
              <input type="button" value="회원가입"  id="joinbtn"/>
             <input type="button" value="로그인"  id="loginbtn"/>
             <input type="button" value="메인으로"  id="mainbtn"/>
              <input type="button" value="게시판"  id="nonmemberboardbtn"/>
             
               <div id="menudata"></div>
                              
                                
</body>
</html>