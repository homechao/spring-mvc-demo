<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<jsp:include page="fragments/headTag.jsp"/>
</head>

<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>
    <!-- Start: MAIN CONTENT -->
	<div id="myCarousel" class="carousel slide">
	  <ol class="carousel-indicators">
	    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	    <li data-target="#myCarousel" data-slide-to="1"></li>
	    <li data-target="#myCarousel" data-slide-to="2"></li>
	  </ol>
	  <!-- Carousel items -->
	  <div class="carousel-inner">
	    <div class="active item">
           <img src="resources/images/bootstrap-mdo-sfmoma-01.jpg" alt="">
           <div class="carousel-caption">
             <h4>First Thumbnail label</h4>
             <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
           </div>
	    </div>
	    <div class="item">
           <img src="resources/images/bootstrap-mdo-sfmoma-02.jpg" alt="">
           <div class="carousel-caption">
             <h4>Second Thumbnail label</h4>
             <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
           </div>
    	</div>
	    <div class="item">
           <img src="resources/images/bootstrap-mdo-sfmoma-03.jpg" alt="">
           <div class="carousel-caption">
             <h4>Third Thumbnail label</h4>
             <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
           </div>
    	</div>
	  </div>
	  <!-- Carousel nav -->
	  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
	  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
    <!-- End: MAIN CONTENT -->


    <jsp:include page="fragments/footer.jsp"/>
</div>
<jsp:include page="fragments/bootstrap-js.jsp"/>
</body>

</html>
