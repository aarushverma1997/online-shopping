<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container shipping" >
<div class="col-md-12  col-sm-12  col-xs-8 ">

           
            
        
            
            <div class="row">
            
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                
                                
                                     <form:form id="billingForm" class="form-horizontal" role="form"
							modelAttribute="billing" 
							method="Post" >
                        
                                        <h3 class="text-center">Billing Address</h3>
                         
                                        <hr>

                                              <div class="col-xs-6 col-sm-6 col-md-6">
                                                 <div class="form-group">
                                                     <input type="text" name="full_name" id="full_name" class="form-control input-sm"  value="">
                                                </div>
                                 </div>
                              

                                          <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                            <input type="text" name="email" id="email" class="form-control input-sm"  value="${userModel.email }">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="mobile" id="mobile" class="form-control input-sm" value="${userModel.mobile }">
                                    </div>
                                </div>

                                          <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                           <form:input type="text" path="addressLineOne" id="addressLineOne"
										class="form-control input-sm" placeholder="Address Line 1" />
									<form:errors path="addressLineOne" cssClass="help-block"
										element="em" />                                       
                                           
                                    </div>
                                </div>
                                
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                   <form:input type="text" path="addressLineTwo" id="addressLineTwo"
										class="form-control input-sm"  placeholder="Address Line 2" />
									<form:errors path="addressLineTwo" cssClass="help-block" element="em" />
                                 </div>
                                </div>
                                

                                          <div class="col-xs-12 col-sm-4 col-md-4">
                                    <div class="form-group">
                            <form:input type="text" path="city" id="city"
										class="form-control input-sm" placeholder="enter the city " />
									<form:errors path="city" cssClass="help-block" element="em" />
                                    </div>
                                </div>
                                   <div class="col-xs-12 col-sm-4 col-md-4">
                                    <div class="form-group">
                            <form:input type="text" path="state" id="state"
										class="form-control input-sm" placeholder="state  " />
									<form:errors path="state" cssClass="help-block"
										element="em" />
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <form:password path="postalCode" id="postalCode"
										class="form-control input-sm" placeholder=" enter the postalCode" />
									<form:errors path="postalCode" cssClass="help-block" element="em" />
                                    </div>
                                </div>
                                
                                 <div class="col-xs-12 col-sm-4 col-md-4">
                                    <div class="form-group">
                            <form:input type="text" path="country" id="country"
										class="form-control input-sm" placeholder="country  " />
									<form:errors path="country" cssClass="help-block"
										element="em" />
                                    </div>
                                </div>
                                
                                
                                               <input class="coupon_question" type="checkbox" name="coupon_question" value="1">
                                        <span class="item-text">Check Shipping address</span>
                                        
                                        
                                        
</form:form>
        
                                  </div>
                          <div class="col-md-6 shipping col-sm-6 col-xs-12">
                                        <h3 class="text-center">shipping Address</h3>

                                        <hr>
                                              <div class="col-xs-6 col-sm-6 col-md-6">
                                                 <div class="form-group">
                                                     <input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="First Name">
                                                </div>
                                 </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="Last Name">
                                    </div>
                                </div>

                                          <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                            <input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="Email id">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="Mobile no">
                                    </div>
                                </div>

                                          <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                            <textarea class="form-control">                                                
                                            </textarea>
                                    </div>
                                </div>

                                          <div class="col-xs-12 col-sm-4 col-md-4">
                                    <div class="form-group">
                            <input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="country">
                                    </div>
                                </div>
                                   <div class="col-xs-12 col-sm-4 col-md-4">
                                    <div class="form-group">
                            <input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="city">
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="pincode">
                                    </div>
                                </div>
                                  </div> 
                                  <div class="container text-center col-md-12">
                                    <a class="btn btn-primary pull-right" href="${flowExecutionUrl}&_eventId_payment">
                                        Continue
                                    </a>
                                </div>
                            </form>  
                            </div>
                    </div>
                    
                   </div> 
<%@include file="../shared/flows-footer.jsp"%>