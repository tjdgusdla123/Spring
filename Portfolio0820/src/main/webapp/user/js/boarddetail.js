window.addEventListener("load", function(event){
var boarddetail = document.getElementById("boarddetail");

var url = "boarddetale";
var request = new XMLHttpRequest();
request.open("GET", url,true);
request.send('');
request.onload = function() {
		var result = request.responseText;
		console.log(result);
		};
});