<div class="container">
<div class="row">

<!-- display the sidebar -->
<div class="col-md-3">
<%@include file="./shared/sidebar.jsp" %>
</div>

<!-- display the Products -->
<div class="col-md-9">

<!-- Added breadcrumb component -->
<div class="row">
<div class="col-lg-12">


<nav aria-label="breadcrumb">
<c:if test="${userClickAllProducts == true }">
<script>
window.categoryId = '';
</script>

<ol  class="breadcrumb">
<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
<li class="breadcrumb-item active">All Products</li>

</ol>
</c:if>
</nav>

<nav aria-label="breadcrumb">
<c:if test="${userClickCategoryProducts == true }">
<script>
window.categoryId = '${category.id}';
</script>
<ol  class="breadcrumb">
<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
<li class=" breadcrumb-item active">Category</li>
<li class="breadcrumb-item active">${category.name }</li>

</ol>
</c:if>
</nav>
</div>

</div>


<div class="row">

<div class="col-xl-12">

<div class="container-fluid">

<div class="table-responsive">

<table id="productListTable" class="table table-striped table-bordered">

 <thead>
            <tr>
               
                <th></th>
                  <th>Name</th>
                  <th>price</th>
                  <th>quantity</th>
                  <th></th>
                
                
            </tr>
        </thead>
        
        
        
</table>

</div>

</div>



</div>


</div>





</div>


</div>



</div>