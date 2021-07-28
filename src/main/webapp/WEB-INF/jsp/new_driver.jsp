<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.bf1el.model.Driver"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file = "header-logged-user.jsp" %>
   <div class="welcome-box">
 <div class="header-box">
 <h2 class="table_hdrs" style="padding:50px; ">ADMIN PANEL</h2></div>   

    <div class="container">

        <form:form method="POST" action="/admin/new_driver" modelAttribute="driverForm" class="form-new-driver">
        
            <h2 class="form-signin-heading table_hdrs">IMPORT NEW DRIVER</h2>
            
            <!--  this is first row  -->
             <div class="row">
        <div class="col-12 col-md-6"> 
            <spring:bind path="drvFirstName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvFirstName" class="form-control" placeholder="First Name"
                                autofocus="true"></form:input>
                    <form:errors path="drvFirstName"></form:errors>
                </div>
            </spring:bind>
          </div> 
          <div class="col-12 col-md-6"> 
              <spring:bind path="drvLastName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvLastName" class="form-control" placeholder="Last Name"
                                autofocus="true"></form:input>
                    <form:errors path="drvLastName"></form:errors>
                </div>
            </spring:bind>
          </div> 
          </div> 
          
          <!--  this is second row  -->
            <div class="row">
        <div class="col-12 col-md-6"> 
            <spring:bind path="drvUsername">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvUsername" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="drvUsername"></form:errors>
                </div>
            </spring:bind>
            </div> 
            <div class="col-12 col-md-6"> 
             <spring:bind path="drvBirthDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvBirthDate" class="form-control" placeholder="MM-DD-YYYY"
                                autofocus="true"></form:input>
                    <form:errors path="drvBirthDate"></form:errors>
                </div>
            </spring:bind>
            </div> 
            </div> 
        
			<!--  this is third row  -->
           <div class="row drow-downs-custom">
            <div class="col-12 col-md-6"> 
            
           
			<label>Nationality</label>

			<select id="nations" class="dropdown-box" name="nations">
			<c:forEach items="${nations}" var="nations">
 			 <option value="${nations.natId}">
 			 ${nations.natName}</option></c:forEach>
  			
			</select>
			
			
      		</div>
           <div class="col-12 col-md-6"> 
            
           
			<label>Team Name</label>

			<select id="teams" class="dropdown-box"  name="teams">
			<c:forEach items="${teams}" var="teams">
 			 <option value="${teams.teamId}">
 			 ${teams.teamName}</option></c:forEach>
  			
			</select>
			
			
      		</div>
           </div>
           
           <!--  this is forth row  -->
           <div class="row">
            <div class="col-12 col-md-6"> 
            <spring:bind path="drvNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvNumber" class="form-control" placeholder="Racing No"
                                autofocus="true"></form:input>
                    <form:errors path="drvNumber"></form:errors>
                </div>
            </spring:bind>
            </div>
           <div class="col-12 col-md-6"> 
           <spring:bind path="drvPoints">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvPoints" class="form-control" placeholder="Points"
                                autofocus="true"></form:input>
                    <form:errors path="drvPoints"></form:errors>
                </div>
            </spring:bind>
            </div>
            </div>
            
            <!--  this is fifth row  -->
           <div class="row">
            <div class="col-12 col-md-6"> 
            <spring:bind path="drvWins">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvWins" class="form-control" placeholder="Wins"
                                autofocus="true"></form:input>
                    <form:errors path="drvWins"></form:errors>
                </div>
            </spring:bind>
            </div>
           <div class="col-12 col-md-6"> 
           <spring:bind path="drvPodiums">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="drvWins" class="form-control" placeholder="Podiums"
                                autofocus="true"></form:input>
                    <form:errors path="drvPodiums"></form:errors>
                </div>
            </spring:bind>
            </div>
            </div>
           
            <button class="lg-btn btn btn-lg btn-block" type="submit">Submit</button>
        </form:form>

    </div>

<%@ include file = "footer.jsp" %>