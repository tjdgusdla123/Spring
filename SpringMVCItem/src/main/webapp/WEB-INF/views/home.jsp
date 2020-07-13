<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jsp를 이용해서 데이터를 출력할 때는 이 코드는 거의 필수 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEM</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
	<div align="center" class="body">
		<h2>상품 목록</h2>
		<table border="1">
			<tr class="header">
				<th width="80">상품 ID</th>
				<th width="300">상품 이름</th>
				<th width="100">상품 가격</th>
			</tr>
			<c:forEach var="item" items="${list}">
				<tr class="record">
					<td width="80">${item.itemid}</td>
					<td width="300"><a href="detail/${item.itemid}">${item.itemname}</a>
					</td>
					<td width="100" align="right">${item.price}원</td>
				</tr>

			</c:forEach>
		</table>
		<ul>
			<li><a href="fileview" class="menu">파일 목록 보기</a></li>
			<li><a href="item.xls" class="menu">엑셀 출력</a></li>
			<li><a href="item.pdf" class="menu">PDF 출력</a></li>
			<li><a href="item.json" class="menu">ITEM JSON 출력</a></li>
			<li><a href="dataformat.csv" class="menu"> 문자열 출력 </a></li>
			<li><a href="dataformat.json" class="menu">데이터 확인</a></li>
			<li><a href="#" class="menu" id="ajaxbtn">ajax 요청</a></li>
			<li><a href="item.xml" class="menu">XML 요청</a></li>
			<li><a href="exception" class="menu">예외발생</a></li>
			<li><a href="validation" class="menu">유효성 검사</a></li>
			<li><a href="fileupload" class="menu">파일 업로드 </a></li>
		</ul>
	</div>
	
	<div id="disp"></div>
	
	<script>
		document.getElementById("ajaxbtn").addEventListener("click", function(event){
			//ajax 객체를 생성
			var request = new XMLHttpRequest();
			//요청할 URL을 생성 
			request.open('get', 'ajax.json');
			//전송
			request.send('');
			//데이터를 가져오면 호출될 함수를 설정
			request.addEventListener('load', function(data){
				//데이터 확인 - 404와 관련된 HTML 에러가 발생하면 open에 작성한 URL과
				//Controller의 RequestMapping에 작성한 URL을 비교
				//alert(data.target.responseText)//xml 이면 responseXML
				
				//JSONParsing
				var result = JSON.parse(data.target.responseText);
				var list = result.oop;
				document.getElementById("disp").innerHTML += 
					list[0].Encapsulation + "<br/>";
				document.getElementById("disp").innerHTML += 
					list[1].Inheritance + "<br/>";
				document.getElementById("disp").innerHTML += 
					list[2].Polymorphism + "<br/>";
			});
		});
		
	</script>
</body>
</html>





