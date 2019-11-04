<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
로그인 여부
 
<hr>
 
<sec:authorize access="isAuthenticated()">
<p> Log-In</p>
</sec:authorize>
 
<sec:authorize access="!isAuthenticated()">
<p> Log-Out</p>
</sec:authorize>

USER ID : <sec:authentication property="name"/><br/>
 
<c:url value="/logout" var="logoutUrl" />
<a href="/logout">Log Out</a> <br />
</body>
</html>