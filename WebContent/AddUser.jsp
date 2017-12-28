<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.fbn.service.RoleServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.fbn.model.Role"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::.Add user</title>
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
				<%@ include file="menu_fbnmanagement.jsp"%>
			</div>


			<div id="home-body-row3" class="col-sm-9 col-md-8">
				<!-- Start of add user -->
				<div id="add-user" class="col-sm-9 col-md-8">
					<fieldset>
						<legend>User details</legend>
						<b> <%
 	if (!session.equals(null)) {
 		out.println(session.getAttribute("userregistered"));
 	}
 %>
						</b>
						<form action="RegisterUserServlet" method="post">

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
							<div class="form-group">
								<label for="role">Role</label> <select class="form-control"
									name="role" required>
									<%
										RoleServiceImpl roleService = new RoleServiceImpl();
										List<Role> list = roleService.getListOfRoles();
										for (Role role : list) {
									%>
									<option value="<%=role.getRoleId()%>"><%=role.getRoleName()%></option>
									<%
										}
									%>
								</select>
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