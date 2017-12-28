<% if (session.getAttribute("Id")== null) {
	response.sendRedirect("index.jsp");
}
%>
<div class="col-sm-3 col-md-4">
	<img src="images/logo.PNG" alt="Logo" class="img-responsive"
		width="100" height="50">
</div>
<div class="col-sm-9 col-md-8">
<br><br>
	<a id="logout" href="logout.jsp">
		<button type="button" class="btn btn-info" >Logout</button>
	</a>

</div>