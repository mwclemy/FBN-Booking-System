<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FBN::.Sign up</title>
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
</head>
<body>
	<!-- Start of container -->
	<div class="container-fluid">

		<!-- Start of header -->
		<div id="header" class="row">
			<%@ include file="loginform.jsp"%>
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
				<!-- Start of add user -->
				<div id="signin" class="col-sm-9 col-md-8">
					<b><%=session.getAttribute("customerregistered")%></b>

					<fieldset>
						<legend>User details</legend>
						<form action="SignupServlet" method="post">

							<div class="form-group">
								<label for="fname">First name</label><input type="text"
									class="form-control" name="fname">
							</div>
							<div class="form-group">
								<label for="lname">Last name</label><input type="text"
									class="form-control" name="lname">
							</div>
							<div class="form-group">
								<label for="tel">Phone</label><input type="tel"
									class="form-control" name="tel">
							</div>
							<div class="form-group">
								<label for="email">Email</label><input type="email"
									class="form-control" name="email">
							</div>
							<div class="form-group">
								<label for="password">Password</label><input type="password"
									class="form-control" name="password">
							</div>
							<div class="form-group">
								<label for="address">Address</label><input type="text"
									class="form-control" name="address">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default">Reset</button>
						</form>
					</fieldset>
				</div>
				<!-- end of add user -->

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