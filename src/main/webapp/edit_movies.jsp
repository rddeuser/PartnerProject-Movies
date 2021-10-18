<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Movie</title>
</head>
<body>
<form action="editMovieServlet" method="post">
<input type="hidden" name ="id" value="${toEdit.id}">
Movie Title: <input type = "text" name = "title" value="${toEdit.title}">
Movie Genre: <input type = "text" name = "genre" value="${toEdit.genre}">
Movie Rating: <input type = "text" name = "rating" value="${toEdit.rating}">
Release Date: <input type = "text" name = "month" placeholder = "mm"><input type = "text" name = "day" placeholder = "dd"><input type = "text" name = "year" placeholder = "yyyy">
<input type="submit" value="Save Edited Item">
</form>
</body>
</html>