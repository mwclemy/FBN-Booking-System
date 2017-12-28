<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%
	String result;
	//Recipient's email ID needs to be mentioned.
	String to = request.getParameter("email");

	// Sender's email ID needs to be mentioned
	String from = "mukamalouis1@gmail.com";
	final String username = "mukamalouis1@gmail.com";
	final String password = "tukabonomujuni";

	// Assuming you are sending email through relay.jangosmtp.net
	String host = "smtp.gmail.com";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", "587");

	//Get the Session object.
	Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	});

	try {
		// Create a default MimeMessage object.
		Message message = new MimeMessage(mailSession);

		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from));

		// Set To: header field of the header.
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Set Subject: header field
		message.setSubject("Your FBN's account Changes");

		// Now set the actual message
		message.setText("Hello " + request.getParameter("firstName") + ", this is your FBN account changes. Your new role is "+request.getParameter("roleName")+". Thank you! ");

		// Send message
		Transport.send(message);
		response.sendRedirect("ManageUser.jsp");

	} catch (MessagingException e) {
		response.sendRedirect("error.jsp");
	}
%>