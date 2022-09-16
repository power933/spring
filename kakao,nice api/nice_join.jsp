<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nice인증 체크 페이지</title>
</head>
<body>
<form name="f" method = "post" action="nice_joinok.do" enctype="application/x-www-form-urlencoded">
고객명 <input type = "text" name = "username"> <br>
고객전화번호 <input type = "text" name = "usertel"> <br>
<input type="button" value = "본인인증" onclick="user_check()">
</form>
<script type="text/javascript">
function user_check() {
	if(f.username.value=="") alert("사용자 이름을 입력해 주세요");
	else if(f.usertel.value=="") alert("사용자 전화번호를 입력해주세요");
	else f.submit();
}
</script>

</body>
</html>