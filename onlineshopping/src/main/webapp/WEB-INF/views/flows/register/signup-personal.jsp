<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="content">



<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Welcome</h3>
                        <p>Now Be The Our Member Lets Join us today.!</p>
                        <a type="submit" href="${contextRoot}/login" class="btn btn-info">Login</a><br/>
                    </div>
                    <div class="col-md-9 register-right">
                        <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" >Join us</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" >Now</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Registration Here</h3>
                                
                                <form:form id="registerForm" class="form-horizontal"
							modelAttribute="user" 
							method="Post" >
                                
                                
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <form:input type="text" path="firstName" id="firstName"
										class="form-control" placeholder="Enter the first Name" />
									<form:errors path="firstName" cssClass="help-block"
										element="em" />
                                        </div>
                                        <div class="form-group">
                                            <form:input type="text" path="lastName" id="lastName"
										class="form-control" placeholder="enter the last name " />
									<form:errors path="lastName" cssClass="help-block" element="em" />
                                        </div>
                                        <div class="form-group">
                                          <form:input type="email" path="email" id="email"
										class="form-control" placeholder="enter the email " />
									<form:errors path="email" cssClass="help-block" element="em" />
                                        </div>
                                        <div class="form-group">
                                           <form:input type="text"    minlength="10" maxlength="10" path="contactNumber" id="contactNumber"
										class="form-control" placeholder="contact Number " />
									<form:errors path="contactNumber" cssClass="help-block"
										element="em" />
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <form:radiobutton path="role" value="USER" checked="checked"/>
                                                    <span> User </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                   <form:radiobutton path="role" value="SUPPLIER"/>
                                                    <span>Supplier </span> 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <form:password path="password" id="password"
										class="form-control" placeholder="password" />
									<form:errors path="password" cssClass="help-block" element="em" />
						
                                        </div>
                                       
                                        <div class="form-group">
                                            <form:password path="confirmPassword" id="confirmPassword"
										class="form-control" placeholder=" confirm Password" />
									<form:errors path="confirmPassword" cssClass="help-block" element="em" />
                                        </div>
                                       <input type="submit" name="_eventId_billing"  value="billing-next"
										class="btnRegister" " />
                                    </div>
                                    </div>
                                    </form:form>
                                </div>
                                	
                                
                            </div>
                           
                            </div>
                        </div>
                    </div>
                </div>

         





<%@include file="../shared/flows-footer.jsp"%>