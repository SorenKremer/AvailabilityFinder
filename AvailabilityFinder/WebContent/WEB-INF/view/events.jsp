<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Events</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/carousel/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous" defer></script>
    <!-- Custom styles for this template -->
    
    <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/register.css" />
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
<div class="container">
        
        <div class="hero">

    <div id="grad1">
        <h3 style="text-align: center;">Lets check the weather in your area</h3>
        <!-- the DIV that will contain the widget -->
<div class="weatherWidget" ></div>

<script>
window.weatherWidgetConfig =  window.weatherWidgetConfig || [];
window.weatherWidgetConfig.push({
    selector:".weatherWidget",
       apiKey:"ME9T9KDKFGATDRLMS29CRC8W7", //Sign up for your personal key
       location:"Minneapolis, Minnesota", //Enter an address
       unitGroup:"us", //"us" or "metric"
       forecastDays:5, //how many days forecast to show
       title:"Minneapolis, Minnesota", //optional title to show in the 
    showTitle:true, 
    showConditions:true
});

(function() {
var d = document, s = d.createElement('script');
s.src = 'https://www.visualcrossing.com/widgets/forecast-simple/weather-forecast-widget-simple.js';
s.setAttribute('data-timestamp', +new Date());
(d.head || d.body).appendChild(s);
})();
</script>


        <h1 style="text-align: center;">Check out your local events!</h1>
		<h3 style = "margin-top: 40px;">> Attending </h3>
        <table class="table" style = "margin-top: 10px;">
            <thead class="">
            <tr id= "new_color">
                
                <th scope="col" style="width: 25%">Description</th>
                <th scope="col" style="width: 25%">Location</th>
                <th scope="col" style="width: 25%">Time</th>
                <th scope="col" style="width: 25%">Status</th>
            </tr>
            </thead>
            <tbody>
            
            <!-- loop over and print our customers -->
				<c:forEach var="tempEvent" items="${userEvents}">
				
				<!-- construct an "update" link with customer id -->
					 <c:url var="deleteLink" value="/customer/deletetestrelationship">
						<c:param name="eventId" value="${tempEvent.id}" />
					</c:url>	 
				
					<tr id= "new_color">
						<td style="width: 25%"> ${tempEvent.description} </td>
						<td style="width: 25%"> ${tempEvent.location} </td>
						<td style="width: 25%"> ${tempEvent.time} </td>
						<td style="width: 25%"> <a href="${deleteLink}">Remove</a> </td> 
						<!-- make attend link to add event to customer -->
					</tr>
				
				</c:forEach> 
            </tbody>
        </table>
        <h3 style = "margin-top: 60px;">> Available </h3>
        <table class="table" style = "margin-top: 10px;">
            <thead class="">
            <tr id= "new_color">
                
                <th scope="col" style="width: 25%">Description</th>
                <th scope="col" style="width: 25%">Location</th>
                <th scope="col" style="width: 25%">Time</th>
                <th scope="col" style="width: 25%">Status</th>
            </tr>
            </thead>
            <tbody>
            
            <!-- loop over and print our customers -->
				 <c:forEach var="tempEvent2" items="${nonUserEvents}">
				
				<!-- construct an "update" link with customer id -->
					<c:url var="addLink" value="/customer/testrelationship">
						<c:param name="eventId" value="${tempEvent2.id}" />
					</c:url>	
				 
					<tr id= "new_color">
						<td style="width: 25%"> ${tempEvent2.description} </td>
						<td style="width: 25%"> ${tempEvent2.location} </td>
						<td style="width: 25%"> ${tempEvent2.time} </td>
						<td style="width: 25%"> <a href="${addLink}">Add</a> </td> 
						<!-- make attend link to add event to customer -->
					</tr>
				
				</c:forEach> 
            </tbody>
        </table>
        
        </div>
        </div>
    </div>
</body>
</html>