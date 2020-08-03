var getmainmenu = document.getElementById("getmainmenu");
var getalcohol = document.getElementById("getalcohol");
var getdrink = document.getElementById("getdrink");
var menudata = document.getElementById("menudata");

getmainmenu.addEventListener("click", function(event){

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

getalcohol.addEventListener("click", function(event){

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

getdrink.addEventListener("click", function(event){

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