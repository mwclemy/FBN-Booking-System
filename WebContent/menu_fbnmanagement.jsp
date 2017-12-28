<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::. Management</title>
</head>
<body>
	<center>FBN Management</center>
	<br>
	<!-- Start of accordion -->
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse1">User Management</a>
				</h4>
			</div>
			<div id="collapse1" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="list-group">
						<a href="AddUser.jsp" class="list-group-item">- Add user</a> <a
							href="ManageUser.jsp" class="list-group-item">- Manage user</a>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse2">Flight configuration</a>
				</h4>
			</div>
			<div id="collapse2" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="list-group">
						<a href="AddFlight.jsp" class="list-group-item">- Add flight</a> <a
							href="ManageFlight.jsp" class="list-group-item">- Manage
							flight</a>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse3">Fare configuration</a>
				</h4>
			</div>
			<div id="collapse3" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="list-group">
						<a href="FareConfiguration.jsp" class="list-group-item">-
							Configure flight fare</a> <a href="UpdateFare.jsp"
							class="list-group-item">- Update configured flight fare</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End of accordion -->
</body>
</html>