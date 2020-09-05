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
	<%@include file="flows-navbar.jsp" %>