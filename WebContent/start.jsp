<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert person</title>
</head>
<body>
<p>${msg}</p>
<form action="Main" method = "post">
<input type="text" style= "width:250px;" name="fname" id = "fName" value="enter first name here"/><br>
<input type="text" style= "width:250px;" name="mname" id = "mName" value="enter middle initial here (1 character)"/><br>
<input type="text" style= "width:250px;" name="lname" id = "lName" value="enter last name here"/><br>
<input type="text" style= "width:250px;" name="email" id = "email" value="enter email here"/><br>
<input type = "hidden" name = "act" value="init">
<input type = "submit" value = "enter">

</form>
</body>
</html>