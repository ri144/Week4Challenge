<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${msg2}</p>
<form action="Main" method = "post">
<input type="text" style= "width:250px;" name="degree" id = "degree" value="enter degree here"/><br>
<input type="text" style= "width:250px;" name="major" id = "school" value="enter schoool here"/><br>
<input type="text" style= "width:250px;" name="school" id = "major" value="enter major here"/><br>
<input type="text" style= "width:250px;" name="year" id = "year" value="enter year here (must be int)"/><br>
<input type = "hidden" name = "act" value="edu">
<input type = "submit" value = "enter">
</form>
<form>
Click this button to continue
<input type = "hidden" name = "act" value="educont">
<input type = "submit" value = "enter">
</form>
</body>
</html>