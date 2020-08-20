window.addEventListener("load", function(event){

	var joinbtn = document.getElementById("joinbtn");
	var mainbtn = document.getElementById("mainbtn");
	var loginbtn = document.getElementById("loginbtn");
	var alcoholbtn = document.getElementById("alcoholbtn");
	var drinkmenubtn = document.getElementById("drinkmenubtn");
	var mainmenubtn = document.getElementById("mainmenubtn");
	var boardbtn = document.getElementById("boardbtn");

	
    
	//버튼을 눌렀을 때 페이지 이동
	mainbtn.addEventListener("click", function(event){
		location.href="../";
	});
	
	loginbtn.addEventListener("click", function(event){
		location.href="login";
		});
	
		joinbtn.addEventListener("click", function(event){
		location.href="join";
		});
		
			boardbtn.addEventListener("click", function(event){
		location.href="board";
		});
		
		
		
	          
		 mainmenubtn.addEventListener("click", function(event){

    var url = "nonmember/mainmenu?menusection=메인&storenickname=털보";
                     
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.send('');
	
	request.onload = function() {
		var map = request.responseText;
		console.log(map);
		
		var list = JSON.parse(map);
		console.log(list);

		var msg = "<h2>"+'상품 목록'+"</h2>"+
				  "<table border='1'>"+
				  "<tr>"+
				  "<th width='80'>"+'메뉴명'+"</th>"+
				  "<th width='300'>"+'설명'+"</th>"+
				  "<th width='100'>"+'가격'+"</th>"+
				   
				  "</tr>"
							 
							 
		for (var i=0; i<list.list.length; i++) {
    		var imsi = list.list[i];
    		msg +=  "<tr>" + 
    				"<td width='80'>"+imsi.menuName+"</td>"+
    				"<td width='300'>"+imsi.menuInfo+"</td>"+
    				"<td width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};



});

alcoholbtn.addEventListener("click", function(event){

var url = "nonmember/alcohol?menusection=주류&storenickname=털보";
                     
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.send('');
	
	request.onload = function() {
		var map = request.responseText;
		console.log(map);
		
		var list = JSON.parse(map);
		console.log(list);

		var msg = "<h2>"+'상품 목록'+"</h2>"+
				  "<table border='1'>"+
				  "<tr>"+
				  "<th width='80'>"+'메뉴명'+"</th>"+
				  "<th width='300'>"+'설명'+"</th>"+
				  "<th width='100'>"+'가격'+"</th>"+
				  "</tr>"
							 
							 
		for (var i=0; i<list.list.length; i++) {
    		var imsi = list.list[i];
    		msg +=  "<tr>" + 
    				"<td width='80'>"+imsi.menuName+"</td>"+
    				"<td width='300'>"+imsi.menuInfo+"</td>"+
    				"<td width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};



});

drinkmenubtn.addEventListener("click", function(event){

var url = "nonmember/drink?menusection=음료&storenickname=털보";
                     
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.send('');
	
	request.onload = function() {
		var map = request.responseText;
		console.log(map);
		
		var list = JSON.parse(map);
		console.log(list);

		var msg = "<h2>"+'상품 목록'+"</h2>"+
				  "<table border='1'>"+
				  "<tr>"+
				  "<th width='80'>"+'메뉴명'+"</th>"+
				  "<th width='300'>"+'설명'+"</th>"+
				  "<th width='100'>"+'가격'+"</th>"+
				  "</tr>"
							 
							 
		for (var i=0; i<list.list.length; i++) {
    		var imsi = list.list[i];
    		msg +=  "<tr>" + 
    				"<td width='80'>"+imsi.menuName+"</td>"+
    				"<td width='300'>"+imsi.menuInfo+"</td>"+
    				"<td width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};



});
 	});
 	