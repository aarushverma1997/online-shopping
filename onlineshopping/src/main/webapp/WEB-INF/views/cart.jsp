

<c:if test="${not empty message }">

			<div class="col-xs-12 col-lg-12">

				<div class="alert alert-success alart-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>

		</c:if>



<c:choose>
	<c:when test="${not empty cartLines }">



		<div class="container-fluid">
			<div class="row">
				<div
					class=" ml-5 col-sm-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th>Quantity</th>
								<th class="text-center">Price</th>
								<th class="text-center">Total</th>
								<th> </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cartLines}" var="cartLine">
								<tr>
									<td class="col-md-6">
										<div class="media">
											<a class="thumbnail pull-left" href="#"> <img
												class="media-object"
												src="${images}/${cartLine.product.code }.jpg"
												style="width: 150px; height: 150px;">
											</a>
											<div class="media-body ml-5">
												<h4 class="media-heading">
												NAME - 	<a href="/show/${cartLine.product.id}/product">${cartLine.product.name}</a>
												</h4>
												<h5 class="media-heading">
													Brand  -  <a href="#">${cartLine.product.brand}</a>
												</h5>
												<h5 class="media-heading">
													description  -  <a href="#">${cartLine.product.description}</a>
												</h5>
												<span>Status: </span><span class="text-warning"><strong>
												<c:choose>
															<c:when test="${cartline.available == false }">
                                
                                                                 not availale
                                
                                                             </c:when>
															<c:otherwise>

                                                                  available


                                                             </c:otherwise>
														       </c:choose> </strong></span>
											</div>
										</div>
									</td>
									
									<td class="col-md-1" style="text-align: center"><input
										type="number" class="form-control" id="count_${cartLine.id }" min="1" max="3"
										value="${cartLine.productCount}" /></td>
									<td class="col-md-1 text-center"><strong>
											&#8377;${cartLine.buyingPrice}</strong></td>
									<td class="col-md-1 text-center"><strong>&#8377;
											${cartLine.total}</strong></td>
									<td class="col-md-1">
									<button type="button" class="btn btn-info" name="refreshCart" value="${cartLine.id }">
											<span class="glyphicon glyphicon-refresh"></span> Refresh
										</button>
										</td>
										<td class="col-md-1">
										<a  href="${contextRoot }/cart/${cartLine.id }/delete"   type="button" class="btn btn-danger">
											<span class="glyphicon glyphicon-remove"></span> Remove
										</a>
									</td>
								</tr>
								</c:forEach>
								<tr>
									<td> </td>
									<td> </td>
									<td> </td>
									<td><h3>Total</h3></td>
									<td class="text-right"><h3>
											<strong>&#8377;${userModel.cart.grandTotal }</strong>
										</h3></td>
								</tr>
								<tr>
									<td> </td>
									<td> </td>
									<td> </td>
									<td>
										<a  href="${contextRoot }/show/all/products"type="button" class="btn btn-primary">
											<span class="glyphicon glyphicon-shopping-cart"></span>
											Continue Shopping
										</a>
									</td>
									<td>
										<a type="button" id="checkout" class="btn btn-success" href="${contextRoot}/checkout">
											Checkout <span class="glyphicon glyphicon-play"></span>
										</a>
									</td>
								</tr>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>



	</c:when>
	<c:otherwise>

		<div class="jumbotron">
			<div class="text-center">

				<h1>your cart is empty</h1>

			</div>

		</div>

	</c:otherwise>


</c:choose>





















