<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FBN::.Home</title>
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
</head>
<body>
	<!-- Start of container -->
	<div class="container-fluid">

		<!-- Start of header -->
		<div id="header" class="row">

			<%@ include file="IndexHeader.jsp"%>

		</div>
		<!-- End of header -->

		<!-- Start of navbar -->
		<div id="nav" class="row">
			<nav class="navbar navbar-inverse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="services.jsp">Services</a></li>
					<li><a href="contactus.jsp">Contact Us</a></li>
					<li><a href="aboutus.jsp">About Us</a></li>
				</ul>
			</nav>
		</div>
		<!-- End of navbar -->

		<!-- Start of body -->
		<div id="contents" class="row">
			<div id="home-body-row3" class="col-sm-3 col-md-4">
				<p>some adds</p>
			</div>
			<div id="home-body-row3" class="col-sm-9 col-md-8">
				<p>Welcome message</p>
			</div>

		</div>
		<!-- End of body -->

		<!-- Start of footer -->
		<div id="footer" class="row">

			<%@ include file="footer.jsp"%>

		</div>
		<!-- End of footer -->
	</div>
	<!-- End of container -->
</body>
</html>