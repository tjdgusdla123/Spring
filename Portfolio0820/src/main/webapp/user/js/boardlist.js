window.addEventListener("load", function(event){
var url = "boardlist";
var request = new XMLHttpRequest();
request.open("post", url, true);
request.send('');
request.addEventListener('load', function(e){
			alert(e.target.responseText);
	var obj = JSON.parse(e.target.responseText);
		obj.innerHTML = "obj";
	});

});

