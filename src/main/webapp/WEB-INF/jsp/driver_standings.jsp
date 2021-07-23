<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "header-logged-user.jsp" %>

<div class="welcome-box">
<div class="header-box">
<h2 class="table_hdrs" style="padding:50px; ">RES FORMULA 1 CHAMPIONSHIP STANDINGS</h2></div>

<table class="table table-inverse">

  <thead class="thead-dark">
    <tr>
      <th scope="col">Racing No</th>
      <th scope="col">Nationality</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Team</th>
      <th scope="col">Points</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach items="${drivers}" var="drivers">
    <tr>
      
      <td>${drivers.drvNumber}</td>
      <td>
      	<img src="${drivers.nationality.natFlag}" class="nat-flag" alt="Flag">
      </td>	
      <td>${drivers.drvFirstName}</td>
      <td>${drivers.drvLastName}</td>
      <td>
      	<img class ="team-logo"src="${drivers.team.teamLogo}" class="nat-flag" alt="Flag">
      </td>	
      <td>${drivers.drvPoints}</td>
      </tr>
      </c:forEach>
    
  </tbody>
</table>

</div>


<%@ include file = "footer.jsp" %>