<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::.Update user</title>
</head>
<body>
	<!-- Start of container -->
	<div class="container-fluid">

		<!-- Start of header -->
		<div id="header" class="row">
			<%@ include file="logout-and-logo.jsp"%>
		</div>
		<!-- End of header -->

		<!-- Start of body -->
		<div id="contents" class="row">
			<div id="home-body-row3" class="col-sm-3 col-md-4">
				<%@ include file="menu_agentmanagement.jsp"%>
			</div>


			<div id="home-body-row3" class="col-sm-9 col-md-8">
				<!-- Start of add user -->
				<div id="signin" class="col-sm-9 col-md-8">
					<fieldset>
						<legend>Update your account</legend>
						<b><%=session.getAttribute("updated")%></b>
						<form action="UpdateUserAccountServlet" method="post">

							<div class="form-group">
								<label for="tel">Phone</label><input type="tel"
									class="form-control" name="tel">
							</div>
							<div class="form-group">
								<label for="email">Old Email</label><input type="email"
									class="form-control" name="oldemail">
							</div>
							<div class="form-group">
								<label for="password">Old Password</label><input type="password"
									class="form-control" name="oldpassword">
							</div>
							<div class="form-group">
								<label for="email">New Email</label><input type="email"
									class="form-control" name="newemail">
							</div>
							<div class="form-group">
								<label for="password">New Password</label><input type="password"
									class="form-control" name="newpassword">
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