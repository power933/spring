<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String mid = (String)session.getAttribute("mid1");
	String mname = (String)session.getAttribute("mname");
	String pd_code = request.getParameter("product_code");
	String pd_name = request.getParameter("product_name");
	String pd_price = request.getParameter("product_price");
	String pd_ea = request.getParameter("product_ea");
	String mtel = (String)session.getAttribute("mtel");
	String memail = (String)session.getAttribute("memail");
	
	
	DecimalFormat dc = new DecimalFormat("###,###");
	String money = dc.format(Integer.parseInt(pd_price));
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 체크</title>
</head>
<body>
<form action="" id = "frm" name="frm" enctype="application/x-www-form-urlencoded">
<!-- PG사에 제공되는 hidden값들 -->
<input type = "hidden" name = "version" value="1.0">
<input type = "hidden" name = "mid" value="">
<input type = "hidden" name = "oid" value="">

<!-- 결제금액 -->
<input type = "hidden" name = "price" value="<%=Integer.parseInt(pd_price)*Integer.parseInt(pd_ea) %>">
<input type = "hidden" name = "timestamp" value="">
<input type = "hidden" name = "currency" value="WON">

<!-- 상품명 -->
<input type = "hidden" name = "goodname" value="<%=pd_name %>">
<input type = "hidden" name = "buyername" value="<%=mname%>">
<input type = "hidden" name = "buyertel" value="<%=mtel%>">
<input type = "hidden" name = "buyeremail" value="<%=memail%>">
<input type = "hidden" name = "goodcode" value="<%=pd_code%>">
<input type = "hidden" name = "goodea" value="<%=pd_ea%>">
<input type = "hidden" name = "buyerid" value="<%=mid%>">



상품코드 :<%=pd_code %>	<br>
상품이름 :<%=pd_name %>	<br>
상품수량 :<%=pd_ea %>EA	<br>
결제금액 :<%=money %>원<br>

<p>-----------------------배송정보 입력 및 최종 금액 확정----------------------------</p>

수령인 : <input type = "text" name="rec_name" value="<%=mname%>"> <br>
수령인 연락처 : <input type = "text" name="rec_tel" value="<%=mtel%>"> <br>
배송지 주소 : <input type = "text" name="rec_addr" > <br>
적립금 사용 : <input type = "text" name="point" value="0"> <br>
최종결제금액 : <input type = "text" name="total" value="">  

<p>--------------------------결제파트------------------------------------</p>
<input type = "radio" name="gopaymethod" value="CARD" checked>신용카드결제
<input type = "radio" name="gopaymethod" value="Directbank">계좌이체
<input type = "radio" name="gopaymethod" value="vbank">가상계좌
<input type = "button" value="결제하기" id="payment">
</form>

</body>

<script type="module">

	import{gopayment}from "./js/index.js";
	document.querySelector("#payment").addEventListener("click",function(){
		gopayment(frm.price.value);
});
	

</script>

</html>















