<%@ page import="java.beans.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<%@ page language="java" import="java.util.*"%>
<%
	if (session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Tutory</title>
	<link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
	<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
			crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
		  rel="stylesheet" type="text/css" />
	<link
			href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
			rel="stylesheet" type="text/css" />
	<link href="../css/index-styles.css" rel="stylesheet" />

	<script type="text/javascript">
		function change()
		{
			var answer = document.getElementById('selc').value;
			document.getElementById('textvalue').value=answer;
		}
	</script>
</head>
<body id="page-top">
<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="#page-top">Tutory</a>
		<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
			Menu <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="about.jsp">About</a></li>
				<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#stanowisko"><%= session.getAttribute("name2")%></a></li>
				<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
				<li class="nav-item mx-0 mx-lg-1 bg-danger"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout"><%= session.getAttribute("name")%></a></li>

			</ul>
		</div>
	</div>
</nav>
<header class="masthead bg-primary text-white text-center">
	<div class="container d-flex align-items-center flex-column">

		<h1 class="masthead-subheading text-uppercase mb-0" style="font-size: 80px">Welcome!</h1>
		<div class="divider-custom divider-light">
			<div class="divider-custom-line"></div>
			<div class="divider-custom-icon">
				<i class="fas fa-star"></i>
			</div>
			<div class="divider-custom-line"></div>
		</div>

	</div>
</header>


<section class="masthead bg-white text-darkblue text-center" id="portfolio">

	<h1 class="masthead-subheading text-uppercase mb-0">All courses available:</h1>
	<div >
		<ul class="navbar-nav ms-auto">
			<li class="nav-item mx-0 mx-lg-1">
				<select name="ActionSelect" onChange="change()" id="selc" style="font-size: 25px">
				<%Iterator itr;%>
				<% List data= (List)request.getAttribute("data");
					for (itr=data.iterator(); itr.hasNext(); )
					{
						String value=(String)itr.next();
				%>
				<option value=<%=value%>><%=value%></option>
				<%}%>
			</select></li>

			<br>
			<button class="button-27">Add Course</button>
			<br>
		</ul>
	</div>


	<div class="container mt-5">
		<div class="row" class="masthead-subheading">
			<div class="col-md-12">
				<ul class="list-group" style="list-style-type:none; padding:0; margin:0;">
					<li class="list-group-item">
						<a href="#">Course 1 </a><button id="myButton">+</button>
						<div id="myPopup" class="popup">
        					<div class="popup-content">
            					<h1>
                  					Course 1
              					</h1>
            					<p>description</p>
								<button >Go to Course</button><button id="closePopup">x</button>
        					</div>
    					</div>
					</li>
					<li class="list-group-item">
						<a href="#">Course 2</a>
					</li>
					<li class="list-group-item">
						<a href="#">Course 3</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	



	<script>
        myButton.addEventListener("click", function () {
            myPopup.classList.add("show");
        });
        closePopup.addEventListener("click", function () {
            myPopup.classList.remove("show");
        });
        window.addEventListener("click", function (event) {
            if (event.target == myPopup) {
                myPopup.classList.remove("show");
            }
        });
    </script>
</section>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/scripts.js"></script>

<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>