<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${hasRole == true && hasAdminRole == true}">

<%@ include file="header_admin.jsp"%></c:if>

<c:if test="${hasRole == true && hasAdminRole == false}">
<%@ include file="header-logged-user.jsp"%>
</c:if>


<c:if test="${hasRole == false}"><%@ include file="header.jsp"%></c:if>

 
<div id="carousel" class="carousel slide" data-ride="carousel"
	data-interval="6500">
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="resources/images/sliderimage1.jpg" class="w-100" alt="...">
			<div class="carousel-caption">
				<div class="containter">
					<div class="row justify-content-center">
						<div class="col-8 d-none d-lg-block py-3 px-0">
							<h1 style="color: orange;">
								<i>Welcome to<br> Balkan F1 Esports League</i>
							</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img src="resources/images/sliderimage2.jpg" class=" w-100" alt="...">
			<div class="carousel-caption">
				<div class="containter">
					<div class="row justify-content-center">
						<div class="col-8 d-none d-lg-block py-3 px-0">
							<h1 style="color: orange;"><i>
								Welcome to<br> Balkan F1 Esports League</i>
							</h1>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<a class="carousel-control-prev" href="#carousel" role="button"
		data-slide="prev"> <span class="carousel-control-prev-icon"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carousel" role="button"
		data-slide="next"> <span class="carousel-control-next-icon"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>

		<div class="team">
 <div class="container">
    <h1 class="text-center">Our Events</h1>
  <div class="row">
   <div class="col-lg-3 col-md-3 col-sm-12 item">
    <img src="../resources/images/Belgian.png" class="img-fluid" alt="team">
    <div class="des">
     01.08.2021.
     </div>

   </div>
   <div class="col-lg-3 col-md-3 col-sm-12 item">
    <img src="../resources/images/British.png" class="img-fluid" alt="team">
    <div class="des">
      08.08.2021.
     </div>
 
   </div>
   <div class="col-lg-3 col-md-3 col-sm-12 item">
    <img src="../resources/images/Hungarian.png" class="img-fluid" alt="team">
    <div class="des">
      15.08.2021. 
     </div>

   </div>
   <div class="col-lg-3 col-md-3 col-sm-12 item">
    <img src="../resources/images/Dutch.png" class="img-fluid" alt="team">
     <div class="des">
      23.08.2021.
     </div>
 
   </div>
  </div>
 </div>
</div>
		
		
		
			
<div class="fixed-background">

	<div class="row text-light py-5">
		<div class="col-12 text-center">

			<h1></h1>
			<h3 class="py-4"></h3>
<div class="social_box text-center ">
    <ul>
        <li><a href="https://www.youtube.com/watch?v=uJi6eXHzvNo&t=240s"><i class="fab fa-facebook-f facebook"></i></a></li>
        <li><a href="https://www.youtube.com/watch?v=uJi6eXHzvNo&t=240s"><i class="fab fa-twitter twitter"></i></a></li>
        <li><a href="https://www.youtube.com/watch?v=uJi6eXHzvNo&t=240s"><i class="fab fa-instagram instagram"></i></a></li>
        <li><a href="https://www.youtube.com/watch?v=uJi6eXHzvNo&t=240s"><i class="fab fa-linkedin-in linkedin"></i></a></li>
        <li><a href="https://www.youtube.com/watch?v=uJi6eXHzvNo&t=240s"><i class="fab fa-youtube youtube"></i></a></li>
        <div class="text text-center">FOLLOW</div>
    </ul>
</div>
		</div>

	</div>
	<div class="fixed-wrap">
		<div class="fixed"></div>
	</div>
</div>

<%@ include file="footer.jsp"%>