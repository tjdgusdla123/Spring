window.addEventListener("load", function(event){
var boarddetail = document.getElementById("boarddetail");
           
var url = "boarddetail/62";
console.log("도착하는지 확인")
var request = new XMLHttpRequest();

request.open("GET", url,true);

request.send('');

request.onload = function() {
	
		var map = request.responseText;
		console.log(map);
		
		//var result = JSON.parse(map);
		//console.log(result);
		};
});
