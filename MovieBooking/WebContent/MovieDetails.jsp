<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::Available Movie List</title>
</head>
<body bgcolor="#FFF8DC">
<center>
<h2>*** MOVIE DETAILS ***</h2>
</center>


<h3>${movie} is being shown at ${city}</h3>



<table width="700" align="center" border="1" bgcolor="#CCCCCC">
	<tr>
		
		<th>Theater Name</th>
		<th>Location</th>
		<th>Show Time</th>
		<th>Status</th>
		
	</tr>
	<c:forEach var="movie" items="${sessionScope.movielist}">
		<tr>

			<td>${movie.theatreName}</td>
			<td>${movie.theatreLocation}</td>
			<td>${movie.showTime}</td>
			<td>
			<c:choose>
			<c:when test="${movie.status == 'Available'}">
			<a href="check.obj?id=${movie.movieId}&status=${movie.status}">${movie.status}</a>
			</c:when>
			<c:when test="${movie.status == 'NotAvailable'}">
			Not Available
			</c:when>
			</c:choose>
            </td>
            
		</tr>
	</c:forEach>
</table>


</body>
</html>