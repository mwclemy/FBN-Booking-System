<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header::.FBN</title>
<link rel="stylesheet" href="libraries/css/style.css">
<% if (session.getAttribute("Id")== null) {
	response.sendRedirect("index.jsp");
}
%>

</head>
<body>
	<div id="logo" class="col-sm-3 col-md-4">
		<img src="images/logo.PNG" alt="Logo"  class="img-responsive" width="100" height="50">
	</div>
	<div id="login" class="col-sm-9 col-md-8">
		<%@ include file="loginform.jsp"%>
	</div>
</body>
</html>