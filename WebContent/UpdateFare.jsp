<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="com.fbn.service.FareFlightServiceImpl"%>
<%@page import="com.fbn.service.FareFlightService"%>
<%@page import="java.util.List"%>
<%@page import="com.fbn.dto.FareFlightDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::.Update Fare</title>
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
					<P>Table of available configured flights</P>
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Fare Id</th>
								<th>Flight Id</th>
								<th>Flight Type</th>
								<th>Origin</th>
								<th>Destination</th>
								<th>Business Price</th>
								<th>Economic Price</th>
								<th>First Class Price</th>
								<th>Operation</th>
							</tr>
						</thead>
						<tbody>
							<%
								FareFlightService ffs = new FareFlightServiceImpl();
								List<FareFlightDTO> list = ffs.getListOfFareFlights();
								int i = 0;
								for (FareFlightDTO ffDTO : list) {
									i++;
							%>
							<tr onMouseover="this.bgColor='#AAAAAA'"
								onMouseout="this.bgColor='#FFFFFF'">
								<td><span class="badge badge-info"><%=i%></span></td>
								<td><%=ffDTO.getFareId()%></td>
								<td><%=ffDTO.getFlightId()%></td>
								<td><%=ffDTO.getFlightType()%></td>
								<td><%=ffDTO.getFlightOrigin()%></td>
								<td><%=ffDTO.getFlightDestination()%></td>
								<td><%=ffDTO.getPriceBusiness()%></td>
								<td><%=ffDTO.getPriceEconomic()%></td>
								<td><%=ffDTO.getPriceFirstClass()%></td>
								<td>
									<button class="btn btn-info" type="button"
										onclick="document.getElementById('<%=ffDTO.getFareId()%>-update').style.display='block'">Update
									</button>
									<div id="<%=ffDTO.getFareId()%>-update" class="modal">
										<div id="formcontents" class="col-sm-9 col-md-12">

											<div class="row" style="background-color: blue">
												<span
													onclick="document.getElementById('<%=ffDTO.getFareId()%>-update').style.display='none'"
													class="close" title="Close">&times;</span>
											</div>
											<fieldset>
												<legend>Fare configuration</legend>
												<form action="UpdateFareServlet" method="post">
													<table class="table">
														<tr>
															<td><br>Business class<br> <br><br>
																Economic class<br><br><br>First class</td>
															<td>
																<div class="form-group">
																	<label for="price">Unity Prices (in $)</label><input
																		type="number" class="form-control"
																		name="business_class_UP" min="1" value="<%=ffDTO.getPriceBusiness()%>"> <br> <input
																		type="number" class="form-control"
																		name="economic_class_UP" min="1" value="<%=ffDTO.getPriceEconomic()%>"> <br> <input
																		type="number" class="form-control"
																		name="first_class_class_UP" min="1" value="<%=ffDTO.getPriceFirstClass()%>"> <br>
																	<input type=hidden class="form-control" name="fare_id"
																		min="1" value="<%=ffDTO.getFareId()%>" >
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