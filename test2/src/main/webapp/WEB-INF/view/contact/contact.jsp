<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
백엔드가 유일하게 페이지 레이아웃을 구성하는 라이브러리
tiles 라이브러리를 꼭 pom.xml에 추가하고 tiles.xml을 생성하여
적용해 주어야 함. 단, class경로 사용시 /가 아닌 .으로 설정 해야함 
-->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<section style = "background-color: orange;">
고객센터 메인
</section>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>

</body>
</html>