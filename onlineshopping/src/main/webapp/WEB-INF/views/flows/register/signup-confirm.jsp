

<%@include file="../shared/flows-header.jsp" %>

<div class="container">
	
         
            <div class="row">
                <div class="col-lg-6">
                
                
                
                <div class="row">
	    <div class="col-lg-12">
	   
		<div class="card bg-default mb-3">
    <div class="card-header thin-card-header">
        <div class="card-title">
            <ul class="card-toolbar">
                <li class="float-left">
                    <h4 style="font-family:Poppins, sans-serif">Personal-Detail</h4>
                </li>
                
            </ul>
        </div>
    </div>
              <div class="card-body">
       
			
			<table>
			<tr><td><b>Name </b></td><td>&nbsp; : </td><td>&nbsp;&nbsp;&nbsp;&nbsp;  </td><td>${registerModel.user.firstName}</td></tr>
		<tr><td><b>Surname </b></td><td>&nbsp; : </td><td>&nbsp;&nbsp;&nbsp;&nbsp;  </td><td>${registerModel.user.lastName}</td></tr>
		<tr><td><b>Email </b></td><td>&nbsp; : </td><td>&nbsp;&nbsp;&nbsp;&nbsp;  </td> <td> ${registerModel.user.email}</td></tr>
		<tr><td><b>Contact Number  </b></td><td>&nbsp; : </td> <td>&nbsp;&nbsp;&nbsp;&nbsp;  </td><td>${registerModel.user.contactNumber}</td></tr>
		<tr><td><b>Role   </b></td><td>&nbsp; : </td><td>&nbsp;&nbsp;&nbsp;&nbsp;  </td><td> ${registerModel.user.role}</td></tr>
		
			
			
			</table>
			
			
			
              
         </div>  
         <div class="card-footer">
         	<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-info">Edit</a>
         </div>
                
                
                
           
                    </div>
                    </div>
                    </div>
                    </div>
               
                <div class="col-lg-6">
                     
                 
                <div class="row">
	    <div class="col-lg-12">
	   
		<div class="card bg-default mb-3">
    <div class="card-header thin-card-header">
        <div class="card-title">
            <ul class="card-toolbar">
                <li class="float-left">
                    <h4 style="font-family:Poppins, sans-serif">Billing-Address</h4>
                </li>
                
            </ul>
        </div>
    </div>
              <div class="card-body">  
			        
			        <table>
			
			
		<tr>	<td><b>address 1  </b></td><td>&nbsp; : </td><td>&nbsp;&nbsp;&nbsp;&nbsp;  </td><td>${registerModel.billing.addressLineOne}</td></tr>
		<tr>	<td><b>address 1  </b> </td><td>&nbsp;: </td><td> &nbsp;&nbsp;&nbsp;&nbsp; </td><td>${registerModel.billing.addressLineTwo}</td></tr>
		<tr>	<td><b>City </b>  </td><td> &nbsp;: </td><td> &nbsp;&nbsp;&nbsp;&nbsp; </td> <td> ${registerModel.billing.city}</td></tr>
		<tr>	<td><b>State  </b> </td> <td> &nbsp;: </td><td>&nbsp;&nbsp; &nbsp;&nbsp; </td><td>${registerModel.billing.state}</td></tr>
		<tr>	<td><b>PostalCode </b></td><td> &nbsp;: </td><td> &nbsp;&nbsp;&nbsp;&nbsp; </td><td> ${registerModel.billing.postalCode}</td></tr>
		<tr>	<td><b>country </b></td><td>&nbsp; : </td><td> &nbsp;&nbsp;&nbsp;&nbsp; </td><td> ${registerModel.billing.country}</td></tr>
			
			
			</table>
			
			
			        
			        
			        
         </div>  
         <div class="card-footer">
         	<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-info">Edit</a>
         </div>
                
                
                
           
                    </div>
                    </div>
                    </div>
                    </div>
			</div>
			
			  <div class="form-group">
                <div class="text-center">
              
										
										<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Submit</a>
                </div>
            </div>
      
			
			
                </div>
            
          
  

	<%@include file="../shared/flows-footer.jsp" %>