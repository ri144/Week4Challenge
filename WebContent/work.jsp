<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Work</title>
</head>
<body>
<p>${msg3}</p>
<!-- 'position', 'company', 'startmonth', "
					+ "'startyear', 'endmonth', 'endyear', 'duty1', 'duty2' -->
<form action="Main" method = "post">
<input type="text" style= "width:250px;" name="position" id = "position" value="enter position here"/><br>
<input type="text" style= "width:250px;" name="company" id = "company" value="enter company here"/><br>
<input type="text" style= "width:250px;" name="startmonth" id = "startmonth" value="enter start month here"/><br>
<input type="text" style= "width:250px;" name="startyear" id = "startyear" value="enter start year here (must be int)"/><br>
<input type="text" style= "width:250px;" name="endmonth" id = "endyear" value="enter end month here"/><br>
<input type="text" style= "width:250px;" name="endyear" id = "endyear" value="enter end year here (must be int)"/><br>
<input type="text" style= "width:250px;" name="duty1" id = "duty1" value="enter duty1 here"/><br>
<input type="text" style= "width:250px;" name="duty2" id = "duty2" value="enter duty2 here"/><br>
<input type = "hidden" name = "act" value="work">
<input type = "submit" value = "enter">
</form>
<form action="Main" method = "post">
Click the following button to continue without submitting the data entry for work
<input type = "hidden" name = "act" value="workcont">
<input type = "submit" value = "enter" >
</form>					
</body>
</html>