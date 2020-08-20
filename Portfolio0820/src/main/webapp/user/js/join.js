window.addEventListener("load", function(event){
    //필요한 DOM 객체 가져오기
    var joinform = document.getElementById("joinform");
    var memberemail = document.getElementById("memberemail");
    var memberpassword = document.getElementById("memberpassword");
    var memberpassword1 = document.getElementById("memberpassword1");
    var memberphonenumber = document.getElementById("memberphonenumber");
    var membernickname = document.getElementById("membernickname");
    
    var msg = document.getElementById("msg");
	var memberemailmsg = document.getElementById("memberemailmsg");
	var memberpasswordmsg = document.getElementById("memberpasswordmsg");
	var membernicknamemsg = document.getElementById("membernicknamemsg");
	var memberphonenumbermsg = document.getElementById("memberphonenumbermsg");
	
	var joinbtn = document.getElementById("joinbtn");
	var mainbtn = document.getElementById("mainbtn");
	var loginbtn = document.getElementById("loginbtn");
	
	//mainbtn 과 loginbtn을 눌렀을 때 페이지 이동
	mainbtn.addEventListener("click", function(event){
		location.href="../";
	});
	loginbtn.addEventListener("click", function(event){
		location.href="login";
	});
	//이미지 미리보기(지금 회원가입 페이지에는 이미지를 첨부하는 것을 만들지 않아서 메뉴판 정보 볼때 여기에있는 코드를 보고 작성하자)
	//image.addEventListener("change", function(event){
		//선택한 파일이 있다면
		//if(this.files && this.files[0]){
			//파일 읽기 객체 생성
			//var reader = new FileReader();
			//파일 읽기 요청
			//reader.readAsDataURL(this.files[0]);
			//자바스크립트에서 파일을 읽는 것은 비동기
			//reader.addEventListener("load", function(e){
				//img.src = e.target.result;
			//});
		//}
	//});
	
	//회원가입 버튼을 눌렀을 때 처리
	var flag = false;
	joinbtn.addEventListener("click", function(event){
		//서버로 보내기 전에 데이터의 유효성 검사를 수행
		//데이터의 길이 나 형식(정규식)을 검사
		
		//길이를 검사할 때는 좌우 공백을 제거하고 검사를 수행
		if (memberemail.value.trim().length < 1) {
			memberemailmsg.innerHTML = '이메일은 필수 입력입니다.<br/>';
			flag = true;
		} else {
			var memberemailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			if (!memberemailRegExp.test(memberemail.value.trim())) {
					memberemailmsg.innerHTML = '잘못된 이메일 형식입니다.<br/>';
					flag = true;
			}
		}
		
		if (memberpassword.value.trim().length < 1) {
			memberpasswordmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			flag = true;
		} else {
			var memberpasswordRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$/;
			if (!memberpasswordRegExp.test(memberpassword.value.trim())) {
					memberpasswordmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자 그리고 특수문자가 포함되어야 합니다.<br/>';
					flag = true;
			} else {
				if (memberpassword.value.trim() !== memberpassword1.value.trim()) {
					memberpasswordmsg.innerHTML = '2개의 비밀번호는 같아야 합니다.<br/>';
					flag = true;
				}
			}
		}
		
		if (membernickname.value.trim().length < 1) {
			membernicknamemsg.innerHTML = '별명은 필수 입력입니다.<br/>';
			flag = true;
		} else {
			var membernicknameRegExp = /^[a-zA-z가-힣0-9]{2,5}$/;
			if (!membernicknameRegExp.test(membernickname.value.trim())) {
				membernicknamemsg.innerHTML = '닉네임은 영문 한글 숫자로 2자 이상 5자 이하이어야 합니다.<br/>';
				flag = true;
			}
		}
		
		if(flag == true){
			return;
		}
		
		//ajax 요청 : join
		var url = "join";
		
		//ajax 객체를 생성
		var request = new XMLHttpRequest();
		
		//요청을 생성
		request.open('post', url, true);
		
		//폼데이터 생성
		var formData = new FormData(joinform);
		
		//요청을 전송
		request.send(formData);
		
		//ajax 요청에 응답이 오면
		request.addEventListener("load", function(e){
			alert(e.target.responseText);
	    //결과를 파싱
			var obj = JSON.parse(e.target.responseText);
			
			//결과를 가지고 다음 행동을 작성
			if(obj.result == true){
				location.href = "../";
			}else{				
				msg.innerHTML = "작성 실패";
				
			}
		});
		
	});
	
	
});




