<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FBN::.Home</title>
<link rel="stylesheet" href="libraries/css/style.css">
<link rel="stylesheet" href="libraries/css/bootstrap.min.css">
</head>
<body>
		<div class="row">
			<div id="login-button">
				<button type="button" class="btn btn-info"
					onclick="document.getElementById('id01').style.display='block'">Login</button>
			</div>

			<div id="id01" class="modal">

				<form action="LoginServlet" method="post">


					<div id="formcontents" class="col-sm-9 col-md-12">
						<div class="row" style="background-color:red">
							<span
								onclick="document.getElementById('id01').style.display='none'"
								class="close" title="Close login">&times;</span>
						</div>
						<div class="form-group">
							<label for="email">Email</label><input type="email"
								placeholder="Enter email" class="form-control" name="email">
						</div>
						<div class="form-group">
							<label for="password">Password</label><input type="password"
								placeholder="Enter Password" class="form-control"
								name="password">
						</div>
						<div class="btn-group">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>

						<span class="psw">Forgot <a href="#">password?</a></span>
						<br>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<a id="sign-up-link"href="signup.jsp">Sign up</a>
		</div>
		<script>
			// Get the modal
			var modal = document.getElementById('id01');

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		</script>
		
</body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
