<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<center>
<h2>Staff Login</h2>
<input type="button" value="insert" onclick="insert()"></input>
<input type="button" value="Delete"></input>
<input type="button" value="View"></input>
</center>
</form>


<script>
	function insert() {
		window.open("insert.jsp","_self");
	}
</script>
</body>
</html>