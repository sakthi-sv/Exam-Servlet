<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
</head>
<body>

<% HttpSession log = request.getSession(false); %>

Welcome, <% if(log.getAttribute("userid") != null) 
				 out.print(log.getAttribute("userid").toString());
			else 
				out.print("user"); %>
				
		<% log.invalidate(); %>

</body>
</html>