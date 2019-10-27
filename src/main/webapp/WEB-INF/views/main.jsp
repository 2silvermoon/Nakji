<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
KFC 시작

<sec:authorize access="isAuthenticated()">
<p> 로그인 중 </p>
<a href="/check">유저 정보</a> <br />
<a href="/list">DB 확인</a> <br />
<c:url value="/logout" var="logoutUrl" />
<a href="/logout">Log Out</a> <br />
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
<p> 로그인 해야함</p>
<a href="/loginForm">Log in</a> <br />
</sec:authorize>


</body>
</html>