<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Importing user classes -->
<%@page import="com.fbn.service.UserServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.fbn.model.User"%>

<!-- Importing user classes -->
<%@page import="com.fbn.service.RoleServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.fbn.model.Role"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::.User management</title>
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
				<!-- Start of user management -->

				<P>Table of users</P>
				<table class="table table-striped" id="example">
					<thead>
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Role</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
						<%
							UserServiceImpl us = new UserServiceImpl();
							List<User> list = us.getListOfUsers();
							int i = 0;
							for (User u : list) {
								i++;
						%>
						<form action="UpdateUserServlet" method="post">
						<tr>
							<td><%=i%><input type="hidden" class="form-control"
								name="userid" value="<%=u.getId()%>"></td>
							</td>
							<td><input type="text" class="form-control" name="fname"
								value="<%=u.getFirstName()%>" ></td>
							<td><input type="text" class="form-control" name="lname"
								value="<%=u.getLastName()%>" ></td>
							<td><input type="email" class="form-control" name="email"
								value="<%=u.getEmail()%>" ></td>
							<td><select class="form-control" name="role" required>
									<%
										RoleServiceImpl roleService = new RoleServiceImpl();
											List<Role> roleList = roleService.getListOfRoles();
											for (Role role : roleList) {
									%>
									<option value="<%=role.getRoleId()%>"><%=role.getRoleName()%></option>
									<%
										}
									%>
							</select></td>
							<td><button type="submit" class="btn btn-info">Update</button>
								<button class="btn btn-danger" type="button"
									onclick="document.getElementById('<%=u.getId() %>').style.display='block'">Delete
								</button>
								<div id="<%=u.getId() %>" class="modal">

									<div id="formcontents" class="col-sm-9 col-md-12">

										<div class="row" style="background-color: blue">
											<span
												onclick="document.getElementById('<%=u.getId() %>').style.display='none'"
												class="close" title="Close">&times;</span>
										</div>
										<h4>Delete User</h4>
										<p>
											Are you sure you want to delete this user?</p>
										<a href="DeleteUserServelet?userId=<%=u.getId()%>">Click here</a>
									</div>
								</div>
								</td>
						</tr>
						</form>
						<%
							}
						%>
					</tbody>
				</table>
			</div>

			<!-- end of user management -->
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