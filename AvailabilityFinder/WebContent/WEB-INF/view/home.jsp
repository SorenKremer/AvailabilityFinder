<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    
    <title>Availability Finder</title>
    
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/carousel/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous" defer></script>
    <!-- Custom styles for this template -->
    
    <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/home.css" />
		  
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	
	

</head>
<body>
    

<!--Navigation bar-->
	<div id="nav-placeholder">

	</div>
	<script>
$(function(){
  $("#nav-placeholder").load("nav");
});
</script>

	
<!--end of Navigation bar-->


<main>

<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
    <div class="carousel-item active">
        
        <img src="${pageContext.request.contextPath}/resources/images/BlueGroup.jpg" width="100%" height="100%">
        <div class="container">
        <div class="carousel-caption">
            <h1>Plan Group Events</h1>
            <p>Easily see when everyone is free!</p>
            <p><a class="btn btn-lg btn-primary" href="register">Sign up today</a></p>
        </div>
        </div>
    </div>
    <div class="carousel-item">
        
        <img src="${pageContext.request.contextPath}/resources/images/BlueTravel.jpg" width="100%" height="100%">
        <div class="container">
        <div class="carousel-caption">
            <h1>Find Local Events</h1>
            <p>Find events other users in your area have created!</p>
            <p><a class="btn btn-lg btn-primary" href="register">Start exploring</a></p>
        </div>
        </div>
    </div>
    <div class="carousel-item">
        
        <img src="${pageContext.request.contextPath}/resources/images/YellowGroup.jpg" width="100%" height="100%">
        <div class="container">
        <div class="carousel-caption">
            <h1>Create Your Own Events</h1>
            <p>One click away!</p>
            <p><a class="btn btn-lg btn-primary" href="register">Sign up for more</a></p>
        </div>
        </div>
    </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
    </button>
</div>


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">


    
    <h1>Trending Events </h1>
    
    

    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
    <div class="col-md-7">
        <h2 class="featurette-heading fw-normal lh-1">Outdoor Climbing </h2>
        <h2> 
            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
            </svg> 
            <span class="text-muted">Taylor's Falls</span>
        </h2>
        <p class="lead">Thursdays 3pm to 7pm</p>
    </div>
    <div class="col-md-5">
        <img src="${pageContext.request.contextPath}/resources/images/Climbing1.png" width="300px" height="300px">

    </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading fw-normal lh-1">Live Music  Hangout </h2>
            <h2> 
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                    <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                </svg> 
                <span class="text-muted">Merlin's Pub</span>
            </h2>
            <p class="lead">Fridays 6pm to 10pm</p>
        </div>
        <div class="col-md-5">
            <img src="${pageContext.request.contextPath}/resources/images/BandBlue.jpg" width="300px" height="100%">
    
        </div>
        </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading fw-normal lh-1">Ultimate Frisbee</h2>
            <h2> 
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                    <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                </svg> 
                <span class="text-muted">Sea Foam Stadium</span>
            </h2>
            <p class="lead">Sunday 10am to 3pm</p>
        </div>
        <div class="col-md-5">
            <img src="${pageContext.request.contextPath}/resources/images/Frisbee.jpg" width="300px" height="100%">
    
        </div>
        </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->

</div><!-- /.container -->


<!-- FOOTER -->
<footer class="container">
    <p class="float-end"><a href="#">Back to top</a></p>
    <p>&copy; 2017-2022 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>
</main>


    <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>


</body>
 

</html>