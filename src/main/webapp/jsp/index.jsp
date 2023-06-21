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
	<div class="container d-flex align-items-center flex-column"></div>
	<h1 class="nav-item mx-0 mx-lg-1"><a
			class="nav-link py-3 px-0 px-lg-3 rounded">Course List</a></h1>
	<br>
	<form method="post" action="">
		<input style="border: 1px solid grey;
			   border-radius: 10px;
			   height: 20px;
			   width: 50%;
			   padding: 2px 23px 2px 30px;
			   outline: 0;
			   background-color: #f5f5f5;"type="search" name="siteUrl" id="siteUrl" placeholder="Search for Course" size="100">
		<br>
		<button class="button-27" >Find Course</button>
		<br>
	</form>
	<br>
	<h2 class="masthead-subheading text-uppercase mb-0">List of Courses:</h2>
	<div class="container mt-5">
		<div class="row" class="masthead-subheading">
			<div class="col-md-12">
				<ul class="list-group" style="list-style-type:none; padding:0; margin:0;">
					<li class="list-group-item">
						<a href="#">Course 1</a>
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
</section>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/scripts.js"></script>

<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>