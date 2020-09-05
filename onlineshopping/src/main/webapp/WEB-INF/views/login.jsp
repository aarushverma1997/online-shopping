<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title }</title>
<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<link rel="stylesheet" href="${css }/bootstrap.min.css">

<link rel="stylesheet" href="${css }/dataTables.bootstrap4.css">
<link rel="stylesheet" href="${css }/myapp.css">



</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">

					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>

				</div>
			</div>
		</nav>

		<div class="content">
		
		<c:if test="${not empty message }">
		
		   <div class="row">

			<div class="col-md-offset-2 col-md-6  ">
				<div class="alart alart-danger">${message}</div>
		</div>
		</div>
		
		</c:if>
		
		<c:if test="${not empty logout }">
		
		   <div class="row">

			<div class="col-md-offset-2 col-md-6  ">
				<div class="alart alart-success">${logout}</div>
		</div>
		</div>
		
		</c:if>
		
		
		
		

<div id="login">

<div class="container">
	<div class="row">
		 <h1><i class="fa fa-lock" aria-hidden="true"></i> Login</h1>
       
        </div><br /><br />
         
                   <form id="loginForm"  action="${contextRoot}/login"  class="form-horizontal"
						 method="POST">
                	<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user-tie"></i></span>
								</div>
								<input type="text" name="username" id="username" class="form-control" placeholder="username or email"/>
							</div><br />
         
                	<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-key icon"></i></span>
								</div>
									<input type="Password" name="password" id="password" class="form-control" placeholder="password"/>
									
							</div><br />
            <div class="checkbox">
              <label><input type="checkbox" value=""/> Remember me</label>
            </div><br />
              <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-off"></span> Login</button>
              <input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
              
              </form>
         <br/>
        <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-remove"></span>Login with Facebook </button><br />
               <br /> <center><div style="border:1px solid black;height:1px;width:300px;"></div></center><br />
        <div class="footer1">
                  <p>Don't have an Account! <a href="${contextRoot }/register">Sign Up Here</a></p>
          <p>Forgot <a href="#">Password?</a></p>
        </div>
 
	</div>


</div>





		
		
		
       </div>

	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>
	<!-- /.container -->

	<script src="${js }/jq.js"></script>
	<script src="${js }/jquery.validate.js"></script>
	<script src="${js }/bootstrap.min.js"></script>
	<script src="${js }/myscript.js"></script>

	</div>
</body>




</html>