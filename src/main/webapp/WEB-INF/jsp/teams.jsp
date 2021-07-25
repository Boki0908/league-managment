<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<%@ include file = "header-logged-user.jsp" %>
 <div class="welcome-box">
 <div class="header-box">
 <h2 class="table_hdrs" style="padding:50px; ">LIST OF ACTIVE BF1EL DRIVERS IN<br> RES F1</h2></div>   
	<div class="container listing container-teams">   
    <div class="row">
    <c:forEach items="${teams}" var="teams"> 
  <div class="col-12 col-md-6"> 
  <fieldset class="listing-item-wrapper custom-wrapper">
  	<div class="listing-info col-md-12">
  	<h5>Team Name: ${teams.teamName}</h5>
  	</div>
  	<div class="listing-team-drivers">
  	<div class="row">
  		<div class="col-md-4">${teams.drivers[0].driverFirstName}</div>
  		<div class="col-md-4">${teams.drivers[0].driverLastName}</div>
  		<div class="col-md-4">
  				<img class="nat-flag" src="${teams.drivers[0].driversFlag}">
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-4">${teams.drivers[1].driverFirstName}</div>
  		<div class="col-md-4">${teams.drivers[1].driverLastName}</div>
  		<div class="col-md-4">
  				<img class="nat-flag" src="${teams.drivers[1].driversFlag}">
  		</div>
  	</div>
  	</div>
  	<div class="listing-team-drivers">
  		<div class="driver">Engine: ${teams.engineSupplier.engName}</div>
  		<div class="team-origin">Team origin: 
  			<img class="nat-flag" src="${teams.nationality.natFlag}">
  		</div>
  	</div>
  	<div class="listing-image">
  		<img class="teamlogo" src="${teams.teamLogo}">
  	</div>  
  	</fieldset>  
  	</div>
  </c:forEach>
 
  
 
</div>

 </div>  
  </div>    
    
<%@ include file = "footer.jsp" %>