<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 로그인 + joinpart.java</title>
</head>
<body>


<img alt="" src="./login.png" onclick="abc()"> <br>
<input type ="button" value="로그아웃" onclick="logout()"> 
<input type = "button" value="자회사몰 회원가입" onclick = "join()"> <br>

<form name="kakao" method="POST" action="kakaojoin.do">
<input type="hidden" name="userid" value="">
<input type="hidden" name="username" value="">
<input type="hidden" name="useremail" value="">
</form>

</body>
<script type="text/javascript" src = "https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

function join() {
	location.href="./join.do";
}

Kakao.init('293a5b17f513198b24992488489133b4');
function abc() {
	Kakao.Auth.login({
		//하이브리드앱 : API, 웹전용 : Auth
	      success: function(response) {
	    	  Kakao.API.request({
	    		  url:'/v2/user/me',
	    		  success:function(response){
	    			  kakao.userid.value = (response["id"]);
	    			  kakao.useremail.value =(response["kakao_account"]["email"]);
	    			  kakao.username.value = response["kakao_account"]["email"];
	    			  kakao.submit();
	    		  },
	    		  fail:function(error){
	    			  console.log(error);
	    		  },
	    	  });
	      },
	      fail: function(error) {
			console.log(error);
	      },
	 });
}



function logout() {
	if(Kakao.Auth.getAccessToken()){
		 Kakao.API.request({
			 url:'/v1/user/unlink',
			 success : function(response) {
				console.log(response);
			},
			fail: function(error) {
				console.log(error);
			},
		 });
		 Kakao.Auth.setAccessToken(undefined);
	}
}



</script>

</html>