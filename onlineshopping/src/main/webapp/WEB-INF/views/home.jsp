



<section class="section-content padding-y">
<div class="container">

<div class="row">
     
     
         <%@include file="./shared/homesitebar.jsp"%>
       
       
       
       
	<main class="col-md-9">
	
	
	
	<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="d-block img-fluid banner-img" src="${images}/banner/banner01.jpg" 
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid banner-img" src="${images}/banner/banner02.jpg" 
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid banner-img" src="${images}/banner/banner03.jpg" 
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
	
<c:set value="${productList }" var="productPageList" />	
	

<header class="border-bottom mb-4 pb-3">
		<div class="form-inline">
			<span class="mr-md-auto">${productPageList.getNrOfElements()} Items found </span>
			<select  class="mr-2 form-control" onchange="my(this.value)">
			 <option value="" disabled selected>Select</option>
				<option value="latest">Latest items</option>
				<option value="tranding">Trending</option>
				<option value="popular">Most Popular</option>
				<option value="cheapest">Cheapest</option>
			</select>
			
		</div>
</header><!-- sect-heading -->

<div class="row">

<c:forEach items="${productPageList.pageList }" var="product">

	<div class="col-md-4">
		<figure class="card card-product-grid">
			<div class="img-wrap prodview"> 
				<span class="badge badge-danger"></span>
				<img src="${images }/${product.code}.jpg" class="img-responsive " style="display: block;object-fit: contain; width: 200px;height: 200px;margin-left: 20px" />
				<a class="btn-overlay" href="${contextRoot }/show/${product.id }/product" style="text-decoration: none;"><i class="fa fa-search-plus"></i> Quick view</a>
			</div> <!-- img-wrap.// -->
			<figcaption class="info-wrap">
				<div class="fix-height">
					<a href="#" class="title prod">Name :  ${product.name}</a>
					<a href="#" class="title prod">Brand : ${product.brand}</a>
					<div class="price-wrap mt-2">
						<span class="price prod"> &#8377;${product.unitPrice }</span>
						<del class="price-old prod"> &#8377;${product.unitPrice + 500}</del>
					</div> <!-- price-wrap.// -->
				</div>
				<a href="${contextRoot }/cart/add/${product.id}/product" class="btn btn-block btn-primary mt-2 prod">Add to cart </a>
			</figcaption>
		</figure>
	</div> <!-- col.// -->

	</c:forEach>


</div> <!-- row end.// -->


<nav class="mt-4" aria-label="Page navigation sample">
  <ul class="pagination">

<c:choose>
<c:when test="${productPageList.firstPage }">
 <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
</c:when>
<c:otherwise>
<c:url value="/showProduct/prev" var="url"  />
 <li class="page-item "><a class="page-link" href='<c:out value="${url }" />'>Previous</a></li>
</c:otherwise>
</c:choose>

<c:forEach begin="1" end="${productPageList.pageCount }" step="1" varStatus="tagStatus">

<c:choose>
<c:when test="${productPageList.page + 1 == tagStatus.index }">
 <li class="page-item "><a class="page-link" href="#">${tagStatus.index }</a></li>
</c:when>
<c:otherwise>
<c:url value="/showProduct/${tagStatus.index }" var="url" />
<li class="page-item"><a class="page-link" href='<c:out value="${url }"/>' >${tagStatus.index }</a></li>
</c:otherwise>

 </c:choose>

</c:forEach>


<c:choose>
<c:when test="${productPageList.lastPage }">
 <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
</c:when>
<c:otherwise>
<c:url value="/showProduct/next" var="url"  />
 <li class="page-item "><a class="page-link" href='<c:out value="${url }" />'>Next</a></li>
</c:otherwise>
</c:choose>


   
   
    
   
  </ul>
</nav>

	</main> <!-- col.// -->

</div>

</div> <!-- container .//  -->
</section>





       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   
 <hr/>
 <%@include file="./shared/category.jsp"%>

 <br/>
 
 <%@include file="./shared/Lestestproduct.jsp"%>


<div  class="container-fluid">

<img src="${images}/banner/e02.jpg"  style="width: 100%" />


</div>







