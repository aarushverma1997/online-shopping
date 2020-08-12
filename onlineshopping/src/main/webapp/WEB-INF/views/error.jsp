<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

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


<link rel="stylesheet" href="${css }/bootstrap.min.css">
<link rel="stylesheet" href="${css }/theme.css">
<link rel="stylesheet" href="${css }/dataTables.bootstrap4.css">
<link rel="stylesheet" href="${css }/myapp.css">



</head>

<body>

	<div class="wrapper">
		
		
		
		<nav class=" navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
		<div class="navbar-header">
		<a class="navbar-brand" href="${contextRoot }/home">Home</a>
		</div>
		
		</div>
	    </nav>
		
		
		
		<div class="content">
			
			<div class="container">
		<div class="col-xs-12">
		
		<div class="jumbotron" >
		     <h1>${errorTitle }</h1>
		     <hr/>
		     <blockquote style="word-wrap:break-word;color:red">
		     ${errorDescription }
		     </blockquote>
		
		</div>
		</div>
		
		</div>
			
	
		</div>

		
		<%@include file="./shared/footer.jsp"%>
	

		
		
	</div>
</body>

</html>