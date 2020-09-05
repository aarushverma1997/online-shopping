<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>


<div class="container">
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
         <form:form id="billingForm" class="form-horizontal" role="form"
							modelAttribute="billing" 
							method="Post" >
    
            <div class="row">
                <div class="col-lg-6">
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="control-label" for="textinput">Line 1</label>
                        
              <form:input type="text" path="addressLineOne" id="addressLineOne"
										class="form-control" placeholder="Address Line 1" />
									<form:errors path="addressLineOne" cssClass="help-block"
										element="em" />
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="control-label" for="textinput">Line 2</label>
                       <form:input type="text" path="addressLineTwo" id="addressLineTwo"
										class="form-control"  placeholder="Address Line 2" />
									<form:errors path="addressLineTwo" cssClass="help-block" element="em" />
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="control-label" for="textinput">City</label>
                         <form:input type="text" path="city" id="city"
										class="form-control" placeholder="enter the city " />
									<form:errors path="city" cssClass="help-block" element="em" />
                    </div>
                    <!-- Text input-->
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label class="control-label" for="textinput">State</label>
                                <form:input type="text" path="state" id="state"
										class="form-control" placeholder="state  " />
									<form:errors path="state" cssClass="help-block"
										element="em" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label class="control-label" for="textinput">Postcode</label>
                                	<form:password path="postalCode" id="postalCode"
										class="form-control" placeholder=" enter the postalCode" />
									<form:errors path="postalCode" cssClass="help-block" element="em" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="textinput">Country</label>
                         <form:input type="text" path="country" id="country"
										class="form-control" placeholder="country  " />
									<form:errors path="country" cssClass="help-block"
										element="em" />
                    </div>
                </div>
                <div class="col-lg-6 text-center">
                   <img src="${images }/address.png" />
                </div>
            </div>

            <div class="form-group">
                <div class="text-center">
                     <input type="submit" name="_eventId_personal"  value="previous-personal"
										class="btn btn-default" /> 
										<input type="submit" name="_eventId_confirm"  value="Next-confirm"
										class="btn btn-primary" /> 
                </div>
            </div>
        </form:form>
    </div>
</div>
	</div>
	</div>
</div>







<%@include file="../shared/flows-footer.jsp"%>