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
</script>

<link rel="stylesheet" href="${css }/bootstrap.min.css">
<link rel="stylesheet" href="${css }/myapp.css">
<link rel="stylesheet" href="${css }/theme.css">


</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!-- Page Content -->

			<!-- leading Home Page -->

			<c:if test="${userClickHome == true }">

				<%@include file="home.jsp"%>
			</c:if>

			<!-- load only when User click about -->

			<c:if test="${userClickAbout == true }">

				<%@include file="about.jsp"%>
			</c:if>

			<!-- load only when User click Contact -->

			<c:if test="${userClickContact == true }">

				<%@include file="contact.jsp"%>
			</c:if>
			<!-- /.container -->
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<script src="${js }/jq.js"></script>
		<script src="${js }/bootstrap.min.js"></script>
		<script src="${js }/myscript.js"></script>
	</div>
</body>

</html>