<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="com.fbn.service.FlightService"%>
<%@page import="com.fbn.service.FlightServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.fbn.model.Flight"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::.Fare Configuration</title>
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
				<div>
					<P>Table of available non-configured flights</P>
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Flight Id</th>
								<th>Type</th>
								<th>Seats</th>
								<th>Origin</th>
								<th>Destination</th>
								<th>Depart</th>
								<th>Arrival</th>
								<th>Return</th>
								<th>Operation</th>
							</tr>
						</thead>
						<tbody>
							<%
								FlightService fs = new FlightServiceImpl();
								List<Flight> list = fs.getListOfFlight();
								int i = 0;
								for (Flight f : list) {
									i++;
									if (f.getFlightType().equals("Round trip")) {
							%>
							<tr onMouseover="this.bgColor='#AAAAAA'"
								onMouseout="this.bgColor='#FFFFFF'">
								<td><span class="badge badge-info"><%=i%></span></td>
								<td><%=f.getFlightId()%></td>
								<td><%=f.getFlightType()%></td>
								<td><%=f.getFlightSeats()%></td>
								<td><%=f.getFlightOrigin()%></td>
								<td><%=f.getFlightDestination()%></td>
								<td><%=f.getDepartureDate()%></td>
								<td>---</td>
								<td><%=f.getArrivalOrReturnDate()%></td>
								<td>
									<button class="btn btn-danger" type="button"
										onclick="document.getElementById('<%=f.getFlightId()%>-round-trip').style.display='block'">Configure
									</button>
									<div id="<%=f.getFlightId()%>-round-trip" class="modal">
										<div id="formcontents" class="col-sm-9 col-md-12">

											<div class="row" style="background-color: blue">
												<span
													onclick="document.getElementById('<%=f.getFlightId()%>-round-trip').style.display='none'"
													class="close" title="Close">&times;</span>
											</div>
											<fieldset>
												<legend>Fare configuration</legend>
												<form action="FareConfigurationServlet" method="post">
													<table class="table">
														<tr>
															<td><br>Business class<br> <br><br>
																Economic class<br><br> <br>First class</td>
															<td>
																<div class="form-group">
																	<label for="price">Unity Prices (in $)</label><input
																		type="number" class="form-control"
																		name="business_class_UP" min="1"> <br> <input
																		type="number" class="form-control"
																		name="economic_class_UP" min="1"> <br> <input
																		type="number" class="form-control"
																		name="first_class_class_UP" min="1"> <br>
																	<input type=hidden class="form-control" name="flightId"
																		min="1" value="<%=f.getFlightId()%>">
																</div>
															</td>
														</tr>
													</table>
													<button type="submit" class="btn btn-info">Submit</button>
													<button type="reset" class="btn btn-default">Reset</button>
												</form>
											</fieldset>
										</div>
									</div>
								</td>

							</tr>
						</tbody>
						<%
							} else {
						%>
						<tr onMouseover="this.bgColor='#AAAAAA'"
							onMouseout="this.bgColor='#FFFFFF'">
							<td><span class="badge badge-info"><%=i%></span></td>
							<td><%=f.getFlightId()%></td>
							<td><%=f.getFlightType()%></td>
							<td><%=f.getFlightSeats()%></td>
							<td><%=f.getFlightOrigin()%></td>
							<td><%=f.getFlightDestination()%></td>
							<td><%=f.getDepartureDate()%></td>
							<td><%=f.getArrivalOrReturnDate()%></td>
							<td>---</td>
							<td>
								<button class="btn btn-danger" type="button"
									onclick="document.getElementById('<%=f.getFlightId()%>-one-way').style.display='block'">Configure
								</button>
								<div id="<%=f.getFlightId()%>-one-way" class="modal">
									<div id="formcontents" class="col-sm-9 col-md-12">

										<div class="row" style="background-color: blue">
											<span
												onclick="document.getElementById('<%=f.getFlightId()%>-one-way').style.display='none'"
												class="close" title="Close">&times;</span>
										</div>
										<fieldset>
											<legend>Fare configuration</legend>
											<form action="FareConfigurationServlet" method="post">
												<table class="table">
													<tr>
														<td><br>Business class <br> <br> <br>
															Economic class<br> <br> <br>First class</td>
														<td>
															<div class="form-group">
																<label for="price">Unity Prices (in $)</label><input
																	type="number" class="form-control"
																	name="business_class_UP" min="1"> <br> <input
																	type="number" class="form-control"
																	name="economic_class_UP" min="1"> <br> <input
																	type="number" class="form-control"
																	name="first_class_class_UP" min="1"> <br>
																<input type=hidden class="form-control" name="flightId"
																	min="1" value="<%=f.getFlightId()%>">
															</div>
														</td>
													</tr>
												</table>
												<button type="submit" class="btn btn-info">Submit</button>
												<button type="reset" class="btn btn-default">Reset</button>
											</form>
										</fieldset>
									</div>
								</div>
							</td>

						</tr>
						<%
							}
							}
						%>

						<tbody>
					</table>
				</div>
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