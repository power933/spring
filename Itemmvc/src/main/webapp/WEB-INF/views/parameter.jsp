<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="getlink?name=adam&job=singer">링크를 이용한 파라미터 전송</a>
	
	<h3>GET 방식의 form 전송</h3>
	<form action="getform">
		이름 : <input type="text" name="name"> <br>
		비번 : <input type="password" name="password"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h3>POST 방식의 form 전송</h3>
	<form action="postform" method="post">
		이름 : <input type="text" name="name"> <br>
		비번 : <input type="password" name="password"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h3>파일업로드</h3>
	<form action="fileupload" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name"> <br>
		파일 : <input type="file" name="pictureurl"> <br>
		<input type="submit" value="전송">
	</form>
	
</body>
</html>