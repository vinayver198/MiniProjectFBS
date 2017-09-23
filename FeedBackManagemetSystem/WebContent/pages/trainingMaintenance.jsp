<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Maintenance Page</title>
</head>
<body>

<%!
	int counter = 0;

	public int getCounter(){
		return counter;
	}
%>

<div style="
    width: 60%;
    min-height: 100px;
    background-color: white;
    border: solid;
    border-color: darkseagreen;
    border-style: ridge;
    border-width: thick;
    padding:10px;
    margin: 10px;">


<p align="center">Training List</p>
<table align="center" border="1">
<col width="130">
<col width="130">
<col width="130">
<col width="100">
<col width="80">
<tr>
<th> <b>Training Name</b> </th> <th><b>Course Name</b> </th> <th><b>Faculty</b> </th> 

<th><b>Start Date</b> </th>  <th><b>End Date</b> </th> <th><b>Update Row</b> </th>

</tr>

<%
	counter = 0;
%>

<c:forEach var="training" items="${trainingPrograms}">

<tr>

<form name="trainingProgramForm<%= counter %>" method="post" 
action="AdminController?action=updateTrainingProgram&trainingCounterNo=<%= counter %>" onSubmit="return check()">

<input type="hidden" name="trainingId" value="<%= counter %>"/>
<td><div align="center">${training.trainingCode}</div></td>

<td><div align="center">${training.courseCode}</div></td>

<td>

<table>
<div align="center"><select id="ddfacultyNameList" name="ddfacultyNameList<%= counter %>">
<c:forEach var="facultyName" items="${facultiesNameList}">
<option value="${facultyName}"> ${facultyName}
</c:forEach>
</select></div>
</table>

</td>

<td><div align="center">${training.startDate}</div></td>

<td><div align="center">${training.endDate}</div></td>


<td>
<div align="center"><input type="submit" name="btUpdateTraining<%= counter %>" value="update"/></div>
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