<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Skills</title>
</head>
<body>
<p>${msg4}</p>
<form action="Main" method = "post">
<input type="text" style= "width:250px;" name="skill" id = "skill" value="enter skill here"/><br>
<input type="text" style= "width:250px;" name="proficiency" id = "proficiency" value="enter proficiency here"/><br>
<input type = "hidden" name = "act" value="skill">
<input type = "submit" value = "enter">
</form>
<form action="Main" method = "post">
Click the following button to continue without submitting another data entry for skills
<input type = "hidden" name = "act" value="skillcont">
<input type = "submit" value = "enter" >
</form>
</body>
</html>