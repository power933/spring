<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<thead>
<tr>
<th width="80">순위</th>
<th width="200">영화제목</th>
<th width="100">누적관객수</th>
</tr>
</thead>
<tbody id = "listview">
<tr>

</tr>
</tbody>


</table>
</body>

<script type="text/javascript">
var today = "2022-09-08";
var ajax = new XMLHttpRequest();
ajax.open("GET","http://localhost:8080/webpage/movie?apikey=123&apidate="+today,true);
ajax.send();

ajax.onreadystatechange = function() {
	if(ajax.status==200 && ajax.readyState==XMLHttpRequest.DONE) {
		var mdata = JSON.parse(ajax.response);
		html_print(mdata);
	}
}

function html_print(mdata) {
	var pt = document.getElementById("listview");
	var ea = mdata.length;
	console.log(mdata);
	var htmlcode = "";
	var icon = "";
	var k = 0;
	do{
		if(mdata[k]['arankpart']=="NEW"){
			icon = "[신규]";
		}
		else{
			icon = "";
		}
		htmlcode += "<tr>";
		htmlcode += "<td>"+mdata[k]["arank"]+"</td>";
		htmlcode += "<td>"+mdata[k]["anm"]+icon+"</td>";
		htmlcode += "<td>"+mdata[k]["person"]+"</td>";
		htmlcode += "</tr>";
		k++;
	}while(k<ea);
	pt.innerHTML = htmlcode;
	
	
}








</script>

</html>
