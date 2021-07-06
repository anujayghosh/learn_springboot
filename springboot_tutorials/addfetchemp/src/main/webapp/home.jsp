<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
__________________________________________<br>
ADD AN EMPLOYEE<br>
__________________________________________<br>
<form action="addEmp">
<input type="text" name="eid"><br>
<input type="text" name="ename"><br>
<input type="text" name="tech"><br>
<input type="submit">
</form><br>
------------------------------------------<br>
<br>
__________________________________________<br>
SEARCH FOR EMPLOYEE BY ID<br>
__________________________________________<br>
<form action="fetchEmp">
<input type="text" name="eid"><br>
<input type="submit">
</form><br>
------------------------------------------<br>
<br>
__________________________________________<br>
UPDATE AN EXISTING EMPLOYEE<br>
__________________________________________<br>
<form action="addEmp">
<input type="text" name="eid"><br>
<input type="text" name="ename"><br>
<input type="text" name="tech"><br>
<input type="submit">
</form><br>
------------------------------------------<br>
<br>
__________________________________________<br>
DELETE EMPLOYEE BY ID<br>
__________________________________________<br>
<form action="deleteEmp">
<input type="text" name="eid"><br>
<input type="submit">
</form><br>
------------------------------------------<br>

</body>
</html>