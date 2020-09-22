<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>
</head>
<body>

	<h1>Admin User</h1>
	<a href="${pageContext.request.contextPath }/logout">LogOut</a>
	
	<c:url value="/admin/user-view" var="urlView"></c:url>
	
	<c:if test="${not empty list}">
		<h3>List User</h3>
		<table border="1">
			<tr>
				<th>Username </th>
				<th>Enable </th>
				<th>view </th>
				<th>Add Role </th>
			</tr>
			<c:forEach items="${list }" var="item">
				<tr>
					<td>${item.username } </td>
					<td>${item.enable } </td>
					<td> <a href="${urlView }/${item.username}">View</a> </td>
					<td> <a href="${pageContext.request.contextPath }/admin/user-addRole/${item.username}">Add Role</a>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${not empty userRoles }">
		<h3>User View</h3>
		<table border="1">
			<tr>
				<th>ID </th>
				<th>User Name </th>
				<th>User Role </th>
				<th>Edit </th>
				<th>Delete </th>
			</tr>
			<c:forEach items="${userRoles }" var="item">
				<tr>
					<td> ${item.roleId} </td>
					<td>${item.user.username } </td>
					<td>${item.userRole } </td>
					<td> <a href=" ${pageContext.request.contextPath }/admin/userRole-edit/${item.roleId}">Edit</a> </td>
					<td> <a href=" ${pageContext.request.contextPath }/admin/userRole-delete/${item.roleId}">Delete</a> </td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>