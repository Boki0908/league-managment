<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>BF1el</title>
<%@ include file = "header-logged-user.jsp" %>
<link rel="shortcut icon" type="image/png" href="${contextPath}../resources/images/logo.png">

<div class="drivers-box">
<h2 style="padding:50px; ">LIST OF ACTIVE BF1EL DRIVERS</h2>


  <table class="table table-inverse">
  <thead>
    <tr>
      <th>Number</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Username</th>
      <th>Nationality</th>
      <th>Team</th>
    </tr>
  </thead>
  <tbody>  
  
        
      
        
    
    <c:forEach items="${drivers}" var="drivers">
    <tr>
      <th>${drivers.drvNumber}</th>
      <th>${drivers.drvFirstName}</th>
    
      <th>${drivers.drvLastName}</th>
    
      <th>${drivers.drvUsername}</th>
    
     <th> <img src="${drivers.nationality.natFlag}" 
      class="nat-flag" alt="Flag"></th>
      
      <th>
      <img class="team-logo" src="${drivers.team.teamLogo}"></th>
    </tr>
     </c:forEach>
  </tbody>
</table>
       
    
    
    </div>

<%@ include file = "footer.jsp" %>