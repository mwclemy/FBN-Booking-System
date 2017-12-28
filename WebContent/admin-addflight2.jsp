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
			<%@ include file="header.jsp"%>

		</div>
		<!-- End of header -->

		<!-- Start of body -->
		<div id="contents" class="row">
			<div id="home-body-row3" class="col-sm-3 col-md-4">
				<%@ include file="menu_fbnmanagement.jsp"%>
			</div>


			<div id="home-body-row3" class="col-sm-9 col-md-8">
				<center>Add Flight</center>
				<div id="tabbedpane" class="col-sm-9 col-md-11">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#oneway">One
								way</a></li>
						<li><a data-toggle="tab" href="#roundtrip">Round trip</a></li>
					</ul>

					<div class="tab-content">
						<div id="oneway" class="tab-pane fade in active">
							<fieldset>
								<legend>Flight details</legend>
								<form action="AddflightServlet" method="post">

									<table class="table">
										<tr>
											<td>Type</td>
											<td>
												<div class="form-group">
													<label for="departon">Select flight type</label> <label
														for="role">Role</label> <select class="form-control"
														name="flighttype">
														<option value="One way trip">One way trip</option>
														<option value="Round trip">Round trip</option>
													</select>
												</div>
											</td>
											<td>
												<div class="form-group"></div>
											</td>
										</tr>
										<tr>
											<td>Flight</td>
											<td>
												<div class="form-group">
													<label for="origin">Origin</label><input type="text"
														class="form-control" name="origin">
												</div>
											</td>
											<td>
												<div class="form-group">
													<label for="destination">Destination</label> <input
														type="text" class="form-control" name="destination">
												</div>
											</td>
										</tr>
										<tr>
											<td>Date</td>
											<td>
												<div class="form-group">
													<label for="departon">Depart on</label><input type="datetime-local"
														class="form-control" name="departon">
												</div>
											</td>
											<td>
												<div class="form-group">
													<label for="arrivalon">Arrival/Return on date</label> <input
														type="datetime-local" class="form-control" name="arrivalorreturn">
												</div>
											</td>
										</tr>
									</table>
									<button type="submit" class="btn btn-default">Submit</button>
									<button type="reset" class="btn btn-default">Reset</button>
								</form>
							</fieldset>
						</div>
						<div id="roundtrip" class="tab-pane fade">
							<fieldset>
								<legend>Flight details</legend>
								<form action="AddflightServlet" method="post">

									<table class="table">
										<tr>
											<td>Flight</td>
											<td>
												<div class="form-group">
													<label for="origin">Origin</label><input type="text"
														class="form-control" name="origin">
												</div>
											</td>
											<td>
												<div class="form-group">
													<label for="destination">Destination</label> <input
														type="text" class="form-control" name="destination">
												</div>
											</td>
										</tr>
										<tr>
											<td>Date</td>
											<td>
												<div class="form-group">
													<label for="origin">Depart on</label><input type="date"
														class="form-control" name="departon">
												</div>
											</td>
											<td>
												<div class="form-group">
													<label for="destination">Return on</label> <input
														type="date" class="form-control" name="returnon">
												</div>
											</td>
										</tr>
									</table>
									<button type="submit" class="btn btn-default">Submit</button>
									<button type="reset" class="btn btn-default">Reset</button>
								</form>
							</fieldset>

						</div>
					</div>
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