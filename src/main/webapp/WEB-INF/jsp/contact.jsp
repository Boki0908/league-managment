<%@ include file = "header_contact.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div class="header-box">
 <h2 style="padding:50px;" class="text-center" >CONTACT US</h2>
 </div>



    
    <div class="row" style="padding: 50px;">

        <div class="col-md-9 mb-md-0 mb-5">
            <form:form id="contact-form" method="post" modelAttribute="contact" action="${pageContext.request.contextPath}/send">

                <div class="row">

                    <div class="col-md-6">
                        <div class="md-form mb-0">
                            <input type="text" path="name" id="name" name="name" class="form-control" >
                            <label for="name" class="">Your name</label>
                            
                        </div>
                    </div>
                   
                    <div class="col-md-6">
                        <div class="md-form mb-0">
                            <input type="text" id="email" name="email" class="form-control">
                            <label for="email" class="">Your email</label>
                           
                        </div>
                    </div>
                 
                </div>
               
                <div class="row">
                    <div class="col-md-12">
                        <div class="md-form mb-0">
                            <input type="text" id="subject" name="subject" class="form-control">
                            <label for="subject" class="">Subject</label>
                            
                        </div>
                    </div>
                </div>
             
                <div class="row">

                    <div class="col-md-12">

                        <div class="md-form">
                            <textarea type="text" id="content" name="content" rows="2" class="form-control md-textarea"></textarea>
                            <label for="content">Your message</label>
                         
                        </div>

                    </div>
                </div>
              
            </form:form>

            <div class="text-center text-md-left">
                <a class="btn btn-primary" onclick="document.getElementById('contact-form').submit();">Send</a>
            </div>
            <div class="status"></div>
        </div>
       
        <div class="col-md-3 text-center">
            <ul class="list-unstyled mb-0">
                <li><i class="fa fa-map-marker fa-2x"></i>
                    <p>Beograd,SRB</p>
                </li>

                <li><i class="fa fa-phone mt-4 fa-2x"></i>
                    <p>+ 381(60)6124-000</p>
                </li>

                <li><i class="fa fa-envelope mt-4 fa-2x"></i>
                    <p>balkan.f1.esports.league@gmail.com</p>
                </li>
               
            </ul>
   
        </div>
  
    </div>

</section>

 
 ${msg}
 <!--  
<form:form method="post" modelAttribute="contact" action="${pageContext.request.contextPath}/send">
 <table>
	<tr>
	 	<td>Name</td>
	 	<td><form:input path="name" /></td>
 	</tr>
 	<tr>
	 	<td>Phone</td>
	 	<td><form:input path="phone" /></td>
 	</tr>
 	<tr>
	 	<td>Email</td>
	 	<td><form:input path="email" /></td>
 	</tr>
 	<tr>
	 	<td>Address</td>
	 	<td><form:input path="address" /></td>
 	</tr>
 	<tr>
	 	<td valign="top">Subject</td>
	 	<td><form:textarea path="subject" rows="5" cols="20" /></td>
 	</tr>
 	<tr>
	 	<td>&nbsp;</td>
	 	<td><input type="submit" value="Send" /></td>
 	</tr>
 	
 </table>
 </form:form> -->
 
<%@ include file = "footer.jsp" %>