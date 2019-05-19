<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.hari.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		<!-- bootstrap -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
		
		<link href="themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link href="themes/css/flexslider.css" rel="stylesheet"/>
		<link href="themes/css/main.css" rel="stylesheet"/>

		<!-- scripts -->
		<script src="themes/js/jquery-1.7.2.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>				
		<script src="themes/js/superfish.js"></script>	
		<script src="themes/js/jquery.scrolltotop.js"></script>
</head>
<body>
<%
Member mem = (Member) session.getAttribute("member");
String un = "";
if(mem == null){
	String msg = "Login First";
	String redirectURL = "http://localhost:8081/PAF/logReg.jsp?msg="+msg;
	response.sendRedirect(redirectURL);
}
else{
	un = mem.getName();
}
%>
<h3 style = "margin-left: 10px; margin-top: 10px;"><a href = "entry/member/myProfile?name=<%=un%>"><%=un %></a></h3>
<%
	String name = request.getParameter("name");
	String type = request.getParameter("type");
	String address = request.getParameter("address");
	String mail = request.getParameter("mail");
	String num = request.getParameter("num");
	String status = request.getParameter("status");
%>

<div id="top-bar" class="container">
			<div class="row">
				<div class="span4">
					<form method="POST" class="search_form">
						<input type="text" class="input-block-level search-query" Placeholder="Search...">
					</form>
				</div>
				<div class="span8">
					<div class="account pull-right">
						<ul class="user-menu">									
							<li><a href="Logout.jsp" onclick = "AlertLogout()">Logout</a></li>		
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.html" class="logo pull-left"><img src="themes/images/logo.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						
					</nav>
				</div>
			</section>
			<section  class="homepage-slider" id="home-slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<img src="themes/images/carousel/banner-1.jpg" alt="" />
						</li>
						<li>
							<img src="themes/images/carousel/banner-2.jpg" alt="" />
							<div class="intro">
								<h1>Sell'n'bye way to the best</h1>
								<p><span>Up to 10000+ customers</span></p>
								<p><span>Reliable and efficient service 24/7</span></p>
								<p><span>Top Most e-commerce System</span></p>
							</div>
						</li>
					</ul>
				</div>			
			</section>
			<br/>
			
			<section class="main-content">
				<!-- Main Content -->
					<div style = "text-align: center;">
						<pre style = "color: #D85611; font-family:sans-serif; font-size: 24px; width: 70%; margin-left: 15%"><b>My Profile</b></pre>
						<br/>
						<h4>User Name: <%=name %></h4>
						<h4>User Type: <%=type %></h4>
						<h4>Address: <%=address %></h4>
						<h4>Mail Id: <%=mail %></h4>
						<h4>Contact Number: <%=num %></h4>
						<h4 style = "color:#2eb82e"><b>Your account is <%=status %></b></h4>
						<br/>
						<pre style = "font-family:sans-serif; font-size: 24px; width: 70%; margin-left: 15%">  <a href = "entry/member/generateUpdateForm?name=<%=un%>">Edit My Profile</a>          <a href = "entry/member/deactivate?name=<%=un%>">Deactivate my account</a></pre>
					</div>
			</section>
			<br/>
			<br/>
			<br/>
			<section id="footer-bar">
				<div class="row">
					<div class="span3">
						<h4>Navigation</h4>
						<ul class="nav">
							<li><a href="./index.html">Homepage</a></li>  
							<li><a href="./about.html">About Us</a></li>
							<li><a href="./contact.html">Contact Us</a></li>
							<li><a href="Logout.jsp" onclick = "AlertLogout()">Logout</a></li>							
						</ul>					
					</div>
					<div class="span4">
						<h4>Others</h4>
						<ul class="nav">
							<li><a href="#">Our Clients</a></li>
							<li><a href="#">FAQ</a></li>
							<li><a href="#">Register</a></li>
						</ul>
					</div>
					<div class="span5">
						<p class="logo"><img src="themes/images/logo.png" class="site_logo" alt=""></p>
						<p>To be successful, you have to use each day as an opportunity to improve, to be better, to get a little bit closer to your goals. It might sound like a lot of work—and with a busy schedule, next to impossible. But the best part is, the more you accomplish, the more you’ll want to do, the higher you’ll want to reach. So  as long as you have the hunger for success, you will always have the power within you to achieve it.</p>
						<br/>
						<span class="social_icons">
							<a class="facebook" href="#">Facebook</a>
							<a class="twitter" href="#">Twitter</a>
							<a class="skype" href="#">Skype</a>
							<a class="vimeo" href="#">Vimeo</a>
						</span>
					</div>					
				</div>	
			</section>
			<section id="copyright">
				<span>Copyright 2019 Sell'N'Bye Company, All right reserved.</span>
			</section>
		</div>
		<script src="themes/js/common.js"></script>
		<script src="themes/js/jquery.flexslider-min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(document).ready(function() {
					$('.flexslider').flexslider({
						animation: "fade",
						slideshowSpeed: 4000,
						animationSpeed: 600,
						controlNav: false,
						directionNav: true,
						controlsContainer: ".flex-container" // the container that holds the flexslider
					});
				});
			});
			function AlertLogout(){
				alert("Logged out");
			}
		</script>
</body>
</html>