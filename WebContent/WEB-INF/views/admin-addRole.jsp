<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add-role</title>
</head>
<body>

	<h1>Add Role</h1>
	 <a href="${pageContext.request.contextPath }/index">Index</a>
	 
	 <form:form action="${pageContext.request.contextPath }/admin/user-addRole" method="Post" modelAttribute="userRole">
	 	<table> 
	 		<tr>
	 			<td>User </td>
	 			<td> <form:input path="user" value="${user }" readonly="true"/> </td>
	 		</tr>
	 		<tr>
	 			<td>User Role </td>
	 			<td><form:input path="userRole"/> </td>
	 		</tr>
	 		<tr>
	 			<td colspan="2"> <button type="submit">Add</button>
	 		</tr>
	 	</table>
	 </form:form>

</body>
</html>