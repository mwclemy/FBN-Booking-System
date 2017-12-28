<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.util.Date"%>
<%@page import="com.fbn.service.FlightServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.fbn.model.Flight"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::.Fright Management</title>
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
			<div id="home-body-row3" class="col-sm-9 col-md-4">
				<%@ include file="menu_fbnmanagement.jsp"%>
			</div>


			<div id="home-body-row3" class="col-sm-9 col-md-8"
				style="overflow: scroll;">
				<!-- Start of add user -->
				<P>Table of available flights</P>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Type</th>
							<th>Seats</th>
							<th>Origin</th>
							<th>Destination</th>
							<th>Business Seats</th>
							<th>Economic Seats</th>
							<th>First Class Seats</th>
							<th>Depart</th>
							<th>Arrival</th>
							<th>Return</th>
							<th colspan="3">Operation</th>
						</tr>
					</thead>
					<tbody>
						<%
							FlightServiceImpl fsi = new FlightServiceImpl();
							List<Flight> list = fsi.getListOfFlight();
							int i = 0;
							for (Flight f : list) {
								i++;
								if (f.getFlightType().equals("Round trip")) {
						%>
						<tr>
							<td><%=i%></td>
							<td><%=f.getFlightType()%></td>
							<td><%=f.getFlightSeats()%></td>
							<td><%=f.getFlightOrigin()%></td>
							<td><%=f.getFlightDestination()%></td>
							<td><%=f.getNumSeatsBusiness()%></td>
							<td><%=f.getNumSeatsEconomic()%></td>
							<td><%=f.getNumSeatsFirstClass()%></td>
							<td><%=f.getDepartureDate()%></td>
							<td>---</td>
							<td><%=f.getArrivalOrReturnDate()%></td>
							<td><a href="#"
								onclick="document.getElementById('<%=f.getFlightId() %>-edit-round-trip').style.display='block'"><i
									class="fa fa-pencil">&nbsp;Edit</i></a>
								<div id="<%=f.getFlightId() %>-edit-round-trip" class="modal" style="overflow: scroll;">

									<form action="UpdateFlightServlet" method="post">

										<div id="formcontents" class="col-sm-9 col-md-12">

											<div class="row" style="background-color: blue">
												<span
													onclick="document.getElementById('<%=f.getFlightId() %>-edit-round-trip').style.display='none'"
													class="close" title="Close">&times;</span>
											</div>
											<h4>
												Update this
												<%=f.getFlightType()%>
												flight
											</h4>
											<div class="form-group">
												<input type="hidden" value="<%=f.getFlightId()%>"
													class="form-control" name="flightId">
											</div>
											<div class="form-group">
												<label for="flightOrigin">Flight origin</label><input
													type="text" value="<%=f.getFlightOrigin()%>"
													class="form-control" name="flightOrigin">
											</div>
											<div class="form-group">
												<label for="flightDestination">Flight destination</label><input
													type="text" value="<%=f.getFlightDestination()%>"
													class="form-control" name="flightDestination">
											</div>
											
											<div class="form-group">
												<label for="flight_seats">Flight Seats</label><input
													type="text" value="<%=f.getFlightSeats()%>"
													class="form-control" name="flight_seats">
											</div>
											<div class="form-group">
												<label for="business_seats">Business Seats</label><input
													type="text" value="<%=f.getNumSeatsBusiness()%>"
													class="form-control" name="business_seats">
											</div>
											<div class="form-group">
												<label for="economic_seats">Economic Seats</label><input
													type="text" value="<%=f.getNumSeatsEconomic()%>"
													class="form-control" name="economic_seats">
											</div>
											<div class="form-group">
												<label for="first_class_seats">First Class Seats</label><input
													type="text" value="<%=f.getNumSeatsFirstClass()%>"
													class="form-control" name="first_class_seats">
											</div>
											<div class="form-group">
												<label for="flightDeparture">Flight departure</label><input
													type="datetime-local" class="form-control"
													name="flightDeparture">
											</div>
											<div class="form-group">
												<label for="arrivalon">Flight Return on date</label><input
													type="datetime-local" class="form-control" name="arrivalon">
											</div>
											<div class="btn-group">
												<button type="submit" class="btn btn-primary">Update</button>
											</div>

										</div>
									</form>
								</div> <a href="#"
								onclick="document.getElementById('<%=f.getFlightId() %>-delete-round-trip').style.display='block'"><i
									class="fa fa-trash">&nbsp;Delete</i></a>
								<div id="<%=f.getFlightId() %>-delete-round-trip" class="modal">
									<div id="formcontents" class="col-sm-9 col-md-12">

										<div class="row" style="background-color: blue">
											<span
												onclick="document.getElementById('<%=f.getFlightId() %>-delete-round-trip').style.display='none'"
												class="close" title="Close">&times;</span>
										</div>
			
										<h4>Delete Flight</h4>
										<p>Are you sure you want to delete this flight?</p>

										<a href="DeleteFlightServelet?flightId=<%=f.getFlightId()%>"><button
												type="submit" class="btn btn-primary">Ok</button></a>
										<button onclick="document.getElementById('<%=f.getFlightId() %>-delete-round-trip').style.display='none'" type="submit" class="btn btn-default">Cancel</button>
									</div>
									<br><br>
								</div></td>

						</tr>
					</tbody>
					<%
						} else {
					%>
						<tr>
							<td><%=i%></td>
							<td><%=f.getFlightType()%></td>
							<td><%=f.getFlightSeats()%></td>
							<td><%=f.getFlightOrigin()%></td>
							<td><%=f.getFlightDestination()%></td>
							<td><%=f.getNumSeatsBusiness()%></td>
							<td><%=f.getNumSeatsEconomic()%></td>
							<td><%=f.getNumSeatsFirstClass()%></td>
							<td><%=f.getDepartureDate()%></td>
							<td><%=f.getArrivalOrReturnDate()%></td>
							<td>---</td>
							<td><a href="#"
								onclick="document.getElementById('<%=f.getFlightId() %>-edit-one-way').style.display='block'"><i
									class="fa fa-pencil">&nbsp;Edit</i></a>
								<div id="<%=f.getFlightId() %>-edit-one-way" class="modal" style="overflow: scroll;">

									<form action="UpdateFlightServlet" method="post">

										<div id="formcontents" class="col-sm-9 col-md-12">

											<div class="row" style="background-color: blue">
												<span
													onclick="document.getElementById('<%=f.getFlightId() %>-edit-one-way').style.display='none'"
													class="close" title="Close login">&times;</span>
											</div>
											<h4>
												Update this
												<%=f.getFlightType()%>
												flight
											</h4>
											<div class="form-group">
												<input type="hidden" value="<%=f.getFlightId()%>"
													class="form-control" name="flightId">
											</div>
											<div class="form-group">
												<label for="flightOrigin">Flight origin</label><input
													type="text" value="<%=f.getFlightOrigin()%>"
													class="form-control" name="flightOrigin">
											</div>
											<div class="form-group">
												<label for="flightDestination">Flight destination</label><input
													type="text" value="<%=f.getFlightDestination()%>"
													class="form-control" name="flightDestination">
											</div>
											<div class="form-group">
												<label for="flight_seats">Flight Seats</label><input
													type="text" value="<%=f.getFlightSeats()%>"
													class="form-control" name="flight_seats">
											</div>
											<div class="form-group">
												<label for="business_seats">Business Seats</label><input
													type="text" value="<%=f.getNumSeatsBusiness()%>"
													class="form-control" name="business_seats">
											</div>
											<div class="form-group">
												<label for="economic_seats">Economic Seats</label><input
													type="text" value="<%=f.getNumSeatsEconomic()%>"
													class="form-control" name="economic_seats">
											</div>
											<div class="form-group">
												<label for="first_class_seats">First Class Seats</label><input
													type="text" value="<%=f.getNumSeatsFirstClass()%>"
													class="form-control" name="first_class_seats">
											</div>
			
											<div class="form-group">
												<label for="flightDeparture">Flight departure</label><input
													type="datetime-local" class="form-control"
													name="flightDeparture">
											</div>
											<div class="form-group">
												<label for="arrivalon">Flight arrival date</label><input
													type="datetime-local" class="form-control" name="arrivalon">
											</div>
											<div class="btn-group">
												<button type="submit" class="btn btn-primary">Update</button>
											</div>

										</div>

									</form>
								</div> <a href="#"
								onclick="document.getElementById('<%=f.getFlightId() %>-delete-one-way').style.display='block'"><i
									class="fa fa-trash">&nbsp;Delete</i></a>
								<div id="<%=f.getFlightId() %>-delete-one-way" class="modal">

									<div id="formcontents" class="col-sm-9 col-md-12">

										<div class="row" style="background-color: blue">
											<span
												onclick="document.getElementById('<%=f.getFlightId() %>-delete-one-way').style.display='none'"
												class="close" title="Close">&times;</span>
										</div>
										<h4>Delete Flight</h4>
										<p>Are you sure you want to delete this flight?</p>

										<a href="DeleteFlightServelet?flightId=<%=f.getFlightId()%>"><button
												type="submit" class="btn btn-primary">Ok</button></a>
										<button onclick="document.getElementById('<%=f.getFlightId() %>-delete-one-way').style.display='none'" type="submit" class="btn btn-default">Cancel</button>
									</div>
								</div></td>
						</tr>
					<%
						}
						}
					%>

					<tbody>
				</table>
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
	<!-- End of container -->
</body>
</html>