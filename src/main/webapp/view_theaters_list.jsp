<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Lists</title>
</head>
<body>
	<form method ="post" action ="addMovieServlet">
	<table>
	<c:forEach items="${requestScope.allTheaters}" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2>${currentlist.theaterName}</h2></td>
		<td><h2>${currentlist.theaterLocation}</h2></td>
	</tr>
		<tr><td colspan="3">Reader: ${currentlist.reader.readerName}</td></tr>
		<c:forEach var ="listVal" items ="${currentlist.ListOfMovies}">
			<tr><td></td><td colspan="4">${listVal.title}, ${listVal.genre}, ${listVal.rating}, ${listVal.releaseDate}</td></tr>
		</c:forEach>
	</c:forEach>
	</table>
	
	<input type="submit" value ="add" name ="doThisToList">
	</form>
	<a href="index.html">Insert a new movie</a>
</body>
</html>