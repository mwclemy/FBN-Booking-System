<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.util.Date"%>
<%@page import="com.fbn.service.UserBookingService"%>
<%@page import="com.fbn.service.UserBookingServiceImpl"%>
<%@page import="com.fbn.dto.UserBookingDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
<script src="libraries/js/jquery-3.2.1.min.js"></script>
<script src="libraries/js/bootstrap.min.js"></script>
<title>FBN::.Bookings</title>
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
				<%@ include file="menu_customermanagement.jsp"%>
			</div>


			<div id="home-body-row3" class="col-sm-9 col-md-8">
				<!-- Start of add user -->
				<P>Table of Bookings</P>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Booking Id</th>
							<th>Number of Business Seats</th>
							<th>Number of Economic Seats</th>
							<th>Number of First Class Seats</th>
							<th>Total Price</th>
							<th>Booking Date</th>
						</tr>
					</thead>
					<tbody>
						<%
							UserBookingService ubs = new UserBookingServiceImpl();
							List<UserBookingDTO> list = ubs
									.getBookingsByUserId(Integer.parseInt(session.getAttribute("Id").toString()));
							int i = 0;
							for (UserBookingDTO f : list) {
								i++;
						%>
						<tr>
							<td><%=i%></td>
							<td><%=f.getBookingId()%></td>
							<td><%=f.getNumSeatsBusiness()%></td>
							<td><%=f.getNumSeatsEconomic()%></td>
							<td><%=f.getNumSeatsFirstClass()%></td>
							<td><%=f.getTotalPrice()%>$</td>
							<td><%=f.getBookingDate()%></td>

						</tr>
					</tbody>
					<%
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