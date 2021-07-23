<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ include file = "header-logged-user.jsp" %>
<div class="welcome-box">
<div class="header-box">

<h2 class="table_hdrs" style="padding:50px; ">LIST OF ACTIVE DRIVERS IN BF1EL</h2></div>

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