<section>
        <div class="container bg-default">
            <div class=" mt-5 mb-5 text-center display-2" style="color:orange">Letest Products</div>
            <hr/>
            <div class="row">
            
            <c:forEach items="${products }" var="product">
                <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 p-2">
                    <div class="card p-3 shadow text-center border-3">
                        <div class="card-body">
                            <img src="${images }/${product.code}.jpg" style="width: 90px;height: 90px">                            <hr/>
                            <h2 class="card-title display-1" style="font-size:3.0vmin;">${product.name }</h2><br/>
                            <h2 class="card-title display-1" style="font-size:2.0vmin;">Brand : ${product.brand }</h2>
                            <br/>
                                 
									<p class="item-price">Price : <strike> &#8377;${product.unitPrice + 150 }</strike> <br/> Off Price :  <span>&#8377;${product.unitPrice }</span></p>
									
									<a href="${contextRoot }/show/${product.id }/product"  class="btn btn-default"><span class="glyphicon glyphicon-eye-open"></span>View</a> &#160;
									
									<a href="${contextRoot }/cart/add/${product.id }/product" class="btn btn-primary">Add to Cart</a>
											
                        </div>
                    </div>
                </div>
               </c:forEach>
            </div>
        </div>
    </section>
    <hr/>