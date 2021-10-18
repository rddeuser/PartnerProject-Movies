<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Movies</title>
</head>
<body>
	<form method ="post" action ="movieNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allItems}" var="currentitem">
	<tr>
		<td><input type="radio" name="title" value="${currentitem.id}"></td>
		<td>${currentitem.title}</td>
		<td>${currentitem.genre}</td>
		<td>${currentitem.rating}</td>
		<td>${currentitem.releaseDate}</td>
	</tr>
	</c:forEach>
	</table>
	<input type ="submit" value ="edit" name="doThisToItem">
	<input type ="submit" value ="delete" name="doThisToItem">
	<input type="submit" value ="add" name ="doThisToItem">
	</form>
</body>
</html>