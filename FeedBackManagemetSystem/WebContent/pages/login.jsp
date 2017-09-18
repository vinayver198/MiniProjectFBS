<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/validation.js"></script>


<title>Insert title here</title>


<style>
	
  table{
   border:solid;
   padding:0%
  }  
  
*{
  padding:2%;
}

</style>




</head>
<body id="content" height="800px" width="100%">

<form name="moduleFoam" method="post" action="LoginController?action=doLogin" onSubmit="return check()"">
<table align="center" width="28%" height="40%">

<tr>
<th align="center" colspan="3"><h2>Feedback Management System </h2></th>
</tr>

<tr>
<td align="left">UserName:</td>
<td ><input id="description" name="userName" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}" value="${userName}"/></td>
</tr>

<tr>
<td align="left">Password:</td>
<td ><input id="description" name="passowrd" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}" value="${passowrd}"/></td>
</tr>

<tr>
<td>
<div><input align="center" style="margin-top: 20px; margin-left: 165%;}" type="submit" value = "Login"></div>
</td>
</tr>

</table>
</form>
<p align="center" style="color: red;">${loginStatus}</p>
</body>
</html>