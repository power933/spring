<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>portfolio Project</title>
</head>
<body>
프로젝트 페이지 뷰 <br>
<input type = "button" value="ajax로드" onclick="ajaxload()">

영화순위 : <span id="no"></span>
영화제목 : <span id="names"></span>
주연 : <span id="person"></span>

</body>

<script type="text/javascript">
function ajaxload() {
	var a = new XMLHttpRequest();
	a.open("GET","http://localhost:8080/webpage/controller2",true);
	a.send();
	
	a.onreadystatechange = function() {
		if(a.status==200 && a.readyState == XMLHttpRequest.DONE){
			var datas = JSON.parse(a.response);
			document.getElementById("no").innerText=datas["idx"];
			document.getElementById("names").innerText=datas["name"];
			document.getElementById("person").innerText=datas["person"];
		}
	}
}

</script>

</html>