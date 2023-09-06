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
<!-- Custom styles for this template -->
<link href="${contextPath}/resources/css/form-validation.css"
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
			<div class="text-center">
				<p id="msg"></p>
			</div>

			<div class="row g-5">

				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">Fill Details about Your Innovation</h4>
					<form class="needs-validation" id="registerSubmit" novalidate>
						<div class="row g-3">
							<div class="col-sm-6">
								<label for="firstName" class="form-label">Innovation
									project name </label> <input type="text" class="form-control"
									id="projectName" placeholder="" value="" required>
								<div class="invalid-feedback">Please enter a valid project
									name.</div>
							</div>



							<div class="col-12">
								<label for="email" class="form-label">Email id</label> <input
									type="email" class="form-control" id="submitterEmail"
									placeholder="you@example.com" required>
								<div class="invalid-feedback">Please enter a valid email
									address.</div>
							</div>

							<div class="col-12">
								<label for="address" class="form-label">What is your
									innovation about?</label> <input type="text" class="form-control"
									id="summaryDetails" placeholder="Explain in few words"
									required>
								<div class="invalid-feedback">Please enter few lines about
									your innovation.</div>
							</div>
							<div class="col-12">
								<label for="username" class="form-label"> Provide your
									innovation url </label>
								<div class="input-group has-validation">
									<span class="input-group-text">urls</span> <input type="text"
										class="form-control" id="projectLink"
										placeholder="https://example.com" required>
									<div class="invalid-feedback">Your project url is
										required.</div>
								</div>
							</div>

							<div class="col-md-12">
								<label for="country" class="form-label">Have you patent
									your innovation idea?</label> 
								<select class="form-select" id="petented" required>
									<option value="" >Choose...</option>
									<option value="Yes">Yes</option>
									<option value="No">No</option>
								</select>
								<div class="invalid-feedback">Please select a valid entry.
								</div>
							</div>

						</div>

						<hr class="my-4">

						<button class="w-100 btn btn-primary btn-lg" id="btn-save"
							type="submit">Save my innovation</button>
					</form>

				</div>
			</div>
		</main>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; happy innovation</p>

		</footer>
	</div>

	<script src="${contextPath}/resources/js/bootstrap.bundle.min.js"></script>
	<script src="${contextPath}/resources/js/innovation.js"></script>
	<script src="${contextPath}/resources/js/form-validation.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
   $(document).ready(function(){
	   $(".homePage").click(function(){
		   goHomePage();
	   });
	   
	   $("#btn-save").click(function(event) {
		   var nowDate = new Date(); 
		   var date = nowDate.getFullYear()+'/'+(nowDate.getMonth()+1)+'/'+nowDate.getDate(); 
		    var data = {}
			data["id"] = Math.floor(100000 + Math.random() * 900000);
			data["submitterEmail"] = $("#submitterEmail").val();
			data["projectName"] = $("#projectName").val();
			data["summaryDetails"] = $("#summaryDetails").val();
			data["petented"] = $('#petented :selected').text();
			data["projectLink"] = $("#projectLink").val();
			data["submittedDate"] =date;
	     
	   $.ajax({
		     type: "POST",
		     contentType: "application/json",
		     url: '/save',
		     dataType: 'json',
		     data: JSON.stringify(data),
		     success: function(data) {
		    	
		    	 $('#msg').text(data);
		    	 $('#registerSubmit').trigger("reset");
		     }
		});

     });
	   
   });
   
  
</script>
</body>
</html>
