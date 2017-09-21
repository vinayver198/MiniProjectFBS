<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.util.ArrayList"
    	import = "com.cg.fms.dto.FacultySkill" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Maintenance Page</title>
</head>
<body>

<%@ include file ="/pages/header.jsp"%>
 


<div style="
    width: 30%;
    min-height: 100px;
    background-color: white;
    border: solid;
    border-color: darkseagreen;
    border-style: ridge;
    border-width: thick;
    margin: 10px;
    padding:10px;
    position: absolute;
    float: left;">

<body>

<p align="center">Faculty List</p>
<table align="center" border="1">
<col width="130">
<col width="100">
<tr>
<th> <b>Name</b> </th> <th><b>Skills</b> </th>
</tr>

<c:forEach var="faculty" items="${facultyList}">

<tr>

<td><div align="center">${faculty.name}</div></td>

<td>
<table >
<c:forEach var="skill" items="${faculty.skillSet}">
<tr>
<td>${skill}</td>
</tr>
</c:forEach>
</table>
</td>

</tr>


</c:forEach>

</table>

</body>


</div>

<div style="
    width: 60%;
    min-height: 100px;
    background-color: white;
    border: solid;
    border-color: darkseagreen;
    border-style: ridge;
    border-width: thick;
    padding:10px;
    float: right;
    margin: 10px;">


<%!
	int counter = 0;

	public int getCounter(){
		return counter;
	}
%>
    


<p align="center">Course List</p>
<table align="center" border="1">
<col width="130">
<col width="130">
<col width="130">
<col width="100">
<col width="80">
<tr>
<th> <b>Course Name</b> </th> <th><b>Duration (Days)</b> </th> <th><b>Assigned Faculty</b> </th> 

<th><b>Faculty List</b> </th>  <th><b>Assign</b> </th>

</tr>

<%
	counter = 0;
%>

<c:forEach var="course" items="${courseArrayList}">

<tr>

<form name="courseForm<%= counter %>" method="post" action="AdminController?action=AssignFaculty&courseCounterNo=<%= counter %>" onSubmit="return check()">
<input type="hidden" name="courseId" id="courseId" value="<%= counter %>"/>
<td><div align="center">${course.name}</div></td>

<td><div align="center">${course.duration}</div></td>

<td>
<table align="center">
<%
	int count=0;
%>
<c:forEach var="faculty" items="${course.facultyNames}">
<tr>
<td><div align="center">${faculty}</div></td><td><div align="right">
	<input type="submit" name="btRemoveFaculty<%= counter %><%= count %>" value="X"/></div></td>
</tr>
<%
	count++;
%>
</c:forEach>
</table>
</td>

<td>

<table>
<div align="center"><select id="ddfacultyNameList" name="ddfacultyNameList<%= counter %>">
<c:forEach var="facultyName" items="${facultiesNameList}">
<option value="${facultyName}"> ${facultyName}
</c:forEach>
</select></div>
</table>

</td>

<td>
<div align="center"><input type="submit" name="btAssignFaculty<%= counter %>" value="assign"/></div>
</td>

</form>

</tr>

<%
	counter++;
%>

</c:forEach>

</table>


    
    
    
</div>

</body>
</html>