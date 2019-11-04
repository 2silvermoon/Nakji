<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<table cellpadding="0" cellspacing="0" border="1">
    <tr>
        <td>학번</td>
        <td>등록여부</td>
        <td>암호화</td>
        <td>등록하기</td>
        <td>등록삭제</td>
    </tr>
    
    <c:forEach var="dto" items="${list}">
        <tr>
            <td>${dto.id }</td>
            <td>${dto.enabled }</td>
            <td>${dto.auth }</td>
            <td>
            <c:choose>
            	<c:when test="${dto.enabled == 0}">
            		<a href="register?id=${dto.id }">등록하기</a>
            	</c:when>
            	<c:when test="${dto.enabled == 2}">
            		admin
            	</c:when>
            	<c:otherwise>
            		등록하기
            	</c:otherwise>
            </c:choose>	
            </td>
            <td>
            <c:choose>
            	<c:when test="${dto.enabled == 0}">
            		등록삭제
            	</c:when>
            	<c:when test="${dto.enabled == 2}">
            		admin
            	</c:when>
            	<c:otherwise>
            		<a href="deregister?id=${dto.id }">등록삭제</a>
            	</c:otherwise>
            </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>