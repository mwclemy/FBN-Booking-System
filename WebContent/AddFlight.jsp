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
<title>FBN::.Add flight</title>
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
				<p>
					<%=session.getAttribute("addingFight")%>
				</p>
				<center>Add Flight</center>
				<form action="FlightConfigurationServlet" method="post" role="form"
					class="">

					<table class="table table-striped">
						<tr>
							<td>Type</td>
							<td>
								<div class="form-group">
									<label for="departon">Select flight type</label> <select
										class="form-control" name="flighttype">
										<option value="One way trip">One way trip</option>
										<option value="Round trip">Round trip</option>
									</select>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="seats">Set total number of seats for flight
									</label> <input type="number" class="form-control" name="seats"
										max="1000" min="1" required>
								</div>
							</td>
						</tr>
						<tr>
							<td>Flight</td>
							<td>
								<div class="form-group">
									<label for="origin">Origin</label><input type="text"
										class="form-control" name="origin" required>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="destination">Destination</label> <input type="text"
										class="form-control" name="destination" required>
								</div>
							</td>
						</tr>
						<tr>
							<td>Date</td>
							<td>
								<div class="form-group">
									<label for="departon">Depart on</label><input
										type="datetime-local" class="form-control" name="departon"
										required>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="arrivalon">Arrival/Return on date</label> <input
										type="datetime-local" class="form-control"
										name="arrivalorreturn" required>
								</div>
							</td>
						</tr>
						<tr>
							<td>Flight Seats</td>
							<td>
								<div class="form-group input-group input-group-sm ">
									<label for="firstclass_seats">First Class Seats </label> <input
										type="number" class="form-control " name="first_class_seats"
										max="1000" min="1" required>
								</div>
							</td>
							<td>
								<div class="form-group input-group input-group-sm">
									<label for="business_seats">Business Class Seats </label> <input
										type="number" class="form-control" name="business_seats"
										max="1000" min="1" required>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>

							<td>
								<div class="form-group input-group input-group-sm">
									<label for="economic_seats">Economic Class Seats </label> <input
										type="number" class="form-control" name="economic_seats"
										max="1000" min="1" required>
								</div>
							</td>
							<td></td>
						</tr>
					</table>
					<button type="submit" class="btn btn-info">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</form>
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