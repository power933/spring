<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>
</head>
<body>
<form action="member_update.do" name="f" method="post">
아이디 : <input type="text" name="uid"> <br>
이름 : <input type="text" name="uname"> <br>
-------------------------------- <br>
수정하실 패스워드 : <input type="password" name="upw"> <br>
<input type="submit" value="비밀번호 변경">
</form>
</body>
</html>