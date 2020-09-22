<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>
</head>
<body>

	<h1>Info</h1>
	<c:if test="${not empty infoRegister }">
		<h2>${infoRegister }</h2>
	</c:if>
	<a href="index">Index</a>

</body>
</html>