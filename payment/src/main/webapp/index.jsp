<%@page import="java.util.Random"%>
<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String mid, mname;
	mid = "hong";
	mname = "홍길동";
	String memail = "power933@naver.com";
	String mtel = "01034122650";
	session.setAttribute("mname", mname);
	session.setAttribute("mid1",mid);
	session.setAttribute("memail",memail);
	session.setAttribute("mtel",mtel);
	

	
	
	Random rd = new Random();
	int number = ran();
	
%>

<%! public int ran(){
		
	Random rd = new Random();
	int number = rd.nextInt(999999);
	if(number<100000){
		return ran();
	}
	return number;
}
	
	%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택 부분</title>
</head>
<body>
<!-- 
상품코드는 6~12자리
금액,수량은 무조건 숫자만
최소금액 천원부터
 -->
<form name = "frm" id = "frm">
상품코드 : <input type = "text" name = "product_code" value=<%=number %> readonly> <br>
상품명 : <input type = "text" name = "product_name"> <br>
결제금액 : <input type = "text" name = "product_price"> <br>
상품수량 : <input type = "text" name = "product_ea"> <br>
<input type = "button" value="상품구매확정" id="btn">
</form>
<script type="module">

	import {gopage} from "./js/index.js";
	document.querySelector("#btn").addEventListener("click",gopage);

</script>





</body>
</html>