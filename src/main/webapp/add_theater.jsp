<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Theater</title>
</head>
<body>
	<form action = "addTheaterServlet" method="post">
	Theater: <input type="text" name="theaterName"><br />
	Location: <input type="text" name="location"><br />
	
	Available Items:<br />
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems}" var="currentItem">
	<option value = "${currentItem.id}">${currentItem.title} | ${currentItem.genre}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create Theater and Add Items">
	</form>
	
	<a href="index.html">Go add new movies instead</a>

</body>
</html>