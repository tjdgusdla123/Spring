window.addEventListener("load", function(event){
var searchtype = document.getElementById("searchtype");
var boardwrite = document.getElementById("boardwrite");
var keyword = document.getElementById("keyword");

  
	//버튼을 눌렀을 때 페이지 이동
	boardwrite.addEventListener("click", function(event){
		location.href="boardwrite";
	});
	
	 searchtype.addEventListener("click", function(event){

	 });
var url = "boardlist1";
var request = new XMLHttpRequest();
request.open("GET", url,true);
request.send('');
request.onload = function() {
		var map = request.responseText;
		console.log(map);
		
	var result = JSON.parse(map);
		console.log(result);
			var msg = "<h2>"+'게시글 목록'+"</h2>"+
				  "<table border='1'>"+
				  "<tr>"+
				  "<th width='50'>"+'글번호'+"</th>"+
				  "<th width='130'>"+'제목'+"</th>"+
				  "<th width='100'>"+'작성자'+"</th>"+
				    "<th width='100'>"+'작성일'+"</th>"+
				     "<th width='50'>"+'조회수'+"</th>"+
				  "</tr>"
							 
							 
		for (var i=0; i<result.memberBoardList.length; i++) {
    		var imsi = result.memberBoardList[i];
    		msg +=  "<tr>" + 
    				"<td width='50'>"+imsi.boardBno+"</td>"+
    				"<td width='130'>"+imsi.boardTitle+"</td>"+
    				"<td width='100'>"+imsi.memberNickname+"</td>"+
    				"<td width='100'>"+imsi.boardDispdate+"</td>"+
    				"<td width='50'>"+imsi.boardReadcnt+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			boardlist.innerHTML = msg;
	};


});


