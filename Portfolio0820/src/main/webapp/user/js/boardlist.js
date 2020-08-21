window.addEventListener("load", function(event){
var url = "boardlist";
var request = new XMLHttpRequest();
request.open("POST", url,true);
request.send('');
request.onload = function() {
		var map = request.responseText;
		console.log(map);
		
	var list = JSON.parse(map);
		console.log(list);
			var msg = "<h2>"+'게시글 목록'+"</h2>"+
				  "<table border='1'>"+
				  "<tr>"+
				  "<th width='80'>"+'글번호'+"</th>"+
				  "<th width='100'>"+'제목'+"</th>"+
				  "<th width='100%'>"+'작성자'+"</th>"+
				    "<th width='80'>"+'작성일'+"</th>"+
				     "<th width='80'>"+'조회수'+"</th>"+
				  "</tr>"
							 
							 
		for (var i=0; i<list.result; i++) {
    		var imsi = list.result[i];
    		msg +=  "<tr>" + 
    				"<td width='80'>"+imsi.boardBno+"</td>"+
    				"<td width='100'>"+imsi.boardTitle+"</td>"+
    				"<td width='100'>"+imsi.memberNickname+"</td>"+
    				"<td width='80'>"+imsi.boardDispdate+"</td>"+
    				"<td width='80'>"+imsi.boardReadcnt+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};


});


