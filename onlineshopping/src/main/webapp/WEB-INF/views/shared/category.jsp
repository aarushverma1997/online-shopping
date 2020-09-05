

<div class="container category-list-index w-100 p-0 category-list" >
<h1 class="  mt-5 mb-5 text-center display-4" style="color:orange;">Categories</h1>
 <hr/>
  <nav class="row">
  
  
  <c:forEach items="${categories }" var="category">
  
    <li class="col-6 col-xs-4 col-sm-4 col-md-3 col-lg-3 col-xl-3 c-border" >
     <img alt="" src="${images}/category/${category.name }.png" class="category-img">
     
      <a href="${contextRoot }/show/category/${category.id}/products"  id="a_${category.name  }" class="list-group-item" ">${category.name }</a>
    </li>
   
		
</c:forEach>
  </nav>
</div>
<hr/>



