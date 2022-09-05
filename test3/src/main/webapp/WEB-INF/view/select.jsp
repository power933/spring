<%@page import="java.util.Map"%>
<%@page import="test3.model_dao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="z" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	ArrayList<Map<String,Object>> pso = (ArrayList<Map<String,Object>>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db 연동 ioc형태(dbquerys.java)</title>
</head>
<body>
<!-- controller에서 model값으로 보내준 클래스명으로 var로 변호나하여 key로 출력시킴-->
<%=pso.get(0).get("mid") %>
<z:forEach items="${pso }" var = "test">
고객명 : ${test.mid } 
</z:forEach>
</body>
</html>