<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>Innovation</title>






<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/navbar-top-fixed.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>


</head>
<body class="bg-light">

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand homePage" href="#">Inventory</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link homePage"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" id="register"
						href="#">Register</a></li>
					<li class="nav-item"><a class="nav-link disabled">Modify</a></li>

				</ul>

			</div>
		</div>
	</nav>


	<div class="container">
		<main>


			<div class="row g-5">
				<div class="col-md-5 col-lg-4 order-md-last">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-primary">Search Projects</span>
					</h4>
					<ul class="list-group mb-3">
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<form class="card p-2">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="">
										<button type="submit" class="btn btn-secondary"
											id="btn-search-id">Id</button>
									</div>
								</form>
							</div>
						</li>

						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<form class="card p-2">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="">
										<button type="submit" class="btn btn-secondary"
											id="btn-search-email">Email</button>
									</div>
								</form>
							</div>
						</li>
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<form class="card p-2">
									<div class="input-group">
										<input type="text" class="form-control" placeholder=""
											id="prName">
										<button type="button" class="btn btn-secondary"
											id="btn-search-name">Project name</button>
									</div>
								</form>
							</div>
						</li>
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<form class="card p-2">
									<div class="input-group">
										<button type="button" class="btn btn-secondary"
											id="btn-search-all">Find All</button>
									</div>
								</form>
							</div>
						</li>
					</ul>
				</div>
				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">Logged Innovation Details</h4>
					<div class="row g-3" id="myDiv">

						<table class="table" id="tresult">
							<thead class="thead-dark">
								<tr>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Project Names</th>
									<th scope="col">Email</th>
									<th scope="col">Patent</th>
									<th scope="col">project Link</th>
									<th scope="col">Submitted Date</th>
									<th scope="col">Project Summary</th>

								</tr>
							</thead>
							<tbody class="result">

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</main>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; happy innovation</p>

		</footer>
	</div>


	<script src="${contextPath}/resources/js/bootstrap.bundle.min.js"></script>
	<script src="${contextPath}/resources/js/innovation.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
   $(document).ready(function(){
	  
	   $("#register").click(function(){
		   goRegisterPage();
	   });
	   
	  
	  
		 $("#btn-search-name").click(function(event) {
			 $('.dataRow').remove();
			 var projectName = $("#prName").val();
			  var data={"key":"projectName","searchVal":projectName};
			 callSearhByProjectService(data);
         });

		 $("#btn-search-all").click(function(event) {
			 $('.dataRow').remove();
			 var data={"key":"","searchVal":""};
			 callSearhByProjectService(data);
         });
	  
	  
		
   });
  

</script>
<body>
</html>
