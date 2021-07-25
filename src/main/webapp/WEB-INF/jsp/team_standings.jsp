<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "header-logged-user.jsp" %>

<div class="welcome-box">
<div class="header-box">
<h2 class="table_hdrs" style="padding:50px; ">RES FORMULA 1 CHAMPIONSHIP<br> CONSTRUCTORS STANDINGS</h2></div>

<table  class="table table-inverse">

  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Team</th>
      <th scope="col">Logo</th>
      <th scope="col">Nationality</th>
      <th scope="col">Points</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach items="${teams}" var="teams" varStatus="loopStatus">
    <tr>
      
      <td>${loopStatus.index + 1}</td>
      <td>${teams.teamName}</td>
      <td>
      	<img class ="team-logo"src="${teams.teamLogo}" class="nat-flag" alt="Flag">
      </td>	
      <td>
      	<img src="${teams.nationality.natFlag}" class="nat-flag" alt="Flag">
      </td>	
      <td>${teams.teamPoints}</td>
      </tr>
      </c:forEach>
    
  </tbody>
</table>

</div>


<%@ include file = "footer.jsp" %>