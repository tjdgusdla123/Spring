window.addEventListener("load", function(event){
    //필요한 DOM 객체 가져오기
    var boardform = document.getElementById("boardform");
    var msg = document.getElementById("msg");
    var boardtitle = document.getElementById("boardtitle");
    var boardcontent = document.getElementById("boardcontent");
    var membernickname = document.getElementById("membernickname");
    var boardfile = document.getElementById("boardfile");
    var writebtn = document.getElementById("writebtn");
    var resetbtn = document.getElementById("resetbtn");
    var mainbtn = document.getElementById("mainbtn");
    var img = document.getElementById("img");
    
    	mainbtn.addEventListener("click", function(event){
		location.href="../";
    });
    	//이미지 미리보기
	boardfile.addEventListener("change", function(event){
		//선택한 파일이 있다면
		if(this.files && this.files[0]){
			//파일 읽기 객체 생성
			var reader = new FileReader();
			//파일 읽기 요청
			reader.readAsDataURL(this.files[0]);
			//자바스크립트에서 파일을 읽는 것은 비동기
			reader.addEventListener("load", function(e){
				img.src = e.target.result;
			});
		}
	});
	//작성 버튼을 눌렀을 때 처리 
	
	writebtn.addEventListener("click", function(event){
	
	//ajax요청 
	var url = "memberboardwrite";
	
	
	//ajax 객체를 생성
	var request = new XMLHttpRequest();

    //요청을 생성
	request.open("post", url, true);
	
	//폼데이터 생성
	var formData = new FormData(boardform);
	
	//요청을 전송
		request.send(formData);
		
	//ajax 요청에 응답이 오면
	request.addEventListener("load", function(e){
		alert(e.target.responseText);
	   
	    //결과를 파싱
		var obj = JSON.parse(e.target.responseText);
			
			//결과를 가지고 다음 행동을 작성
			if(obj.result == true){
				location.href = "boardlist";
			}else{
				msg.innerHTML = "작성 실패 ";
				
				}
	});		
});
});