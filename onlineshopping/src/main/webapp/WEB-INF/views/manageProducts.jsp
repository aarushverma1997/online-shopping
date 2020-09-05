<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">

		<c:if test="${not empty message }">

			<div class="col-xs-12 col-lg-12">

				<div class="alert alert-success alart-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>

		</c:if>




		<div class="col-md-offset-2 col-md-8 col-lg-12  ">
			<div class="card   mb-3">

				<div class="card-header">

					<h1>Product Management</h1>

				</div>
				<div class="card-body">

					<form:form  class="form-horizontal" modelAttribute="product"
						action="${contextRoot }/manage/products" method="Post"
						enctype="multipart/form-data">


						<div class="form-group">
							<label class="control-label  col-md-8" for="name">Enter	the Product Name : </label>
							<div class="col-md-10">
								<form:input type="text" path="name" id="name"
									class="form-control" placeholder="Product Name" />
								<form:errors path="name" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label  col-md-8" for="brand">Enter
								the Product Brand : </label>
							<div class="col-md-10">
								<form:input type="text" path="brand" id="brand"
									class="form-control" placeholder="Product Brand" />
								<form:errors path="brand" cssClass="help-block" element="em" />

							</div>
						</div>


						<div class="form-group">
							<label class="control-label  col-md-8" for="description">Enter
								the Product Description : </label>
							<div class="col-md-10">
								<form:textarea path="description" id="description" rows="4"
									class="form-control" placeholder=" Write Product Description" />
								<form:errors path="description" cssClass="help-block"
									element="em" />

							</div>
						</div>


						<div class="form-group">
							<label class="control-label  col-md-8" for="unitPrice">Enter
								the Product Unit-Price : </label>
							<div class="col-md-10">
								<form:input type="text" path="unitPrice" id="unitPrice"
									class="form-control"
									placeholder="Product Unit Price In &#8377;" />
								<form:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label  col-md-8" for="quantity">Quantity
								Available : </label>
							<div class="col-md-10">
								<form:input type="number" path="quantity" id="quantity"
									class="form-control" placeholder="Product Quantity" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label  col-md-8" for="file">Select
								Image : </label>
							<div class="col-md-10">
								<form:input type="file" path="file" id="file"
									class="form-control" />
									<form:errors path="file" cssClass="help-block" element="em" />
									

							</div>
						</div>


						<div class="form-group">
							<label class="control-label  col-md-8" for="categoryId">Select
								Category : </label>
							<div class="col-md-10">
								<form:select path="categoryId" id="categoryId"
									class="form-control" items="${categories }" itemLabel="name"
									itemValue="id" />

							</div>
						<c:if test="${product.id == 0}">
						<div class="text-right">
						<br/>
						
						<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#addCategoryModal">Add Category</button>
						
						</div>
						</c:if>
							
							
							
							
						</div>

						<div class="form-group ">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="submit"
									class="btn btn-primary" />

								<form:hidden path="id" />
								<form:hidden path="code" />
								<form:hidden path="supplierId" />
								<form:hidden path="active" />
								<form:hidden path="purchases" />
								<form:hidden path="views" />



							</div>
						</div>


					</form:form>


				</div>

			</div>
		</div>
	</div>

<div class="row">

<div class="col-xs-12">




</div>


<div class="col-xs-12 col-lg-12">
<div class="container-fluid">
<div class="table-responsive">

<table id="adminProductsTables" class="table table-striped table-bordered">

<thead>
<tr>

<th>Id</th>
<th>&#160;</th>
<th>Brand</th>
<th>Name</th>
<th>Quantity</th>
<th>Unit Price</th>
<th>Active</th>
<th>Edit</th>


</tr>


</thead>

</table>



</div>

</div>

</div>


</div>



</div>



<div class="modal fade" id="addCategoryModal" role="dialog" tabindex="-1">

<div class="modal-dialog" role="document">
<div class="modal-content"> 

<div class="modal-header">
<h4 class="modal-title">Add New Category</h4>

<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>


</div>
<div class="modal-body">

<form:form 

id="categoryForm"

modelAttribute="category" action="${contextRoot }/manage/category" method="POST" class="form-horizontal">

<div class="form-group">

<label for="name" class="control-label col-md-6">Category Name</label>
<div class="col-md-8 ">

<form:input type="text" path="name" id="name" class="form-control"  />
</div>


</div>

<div class="form-group">

<label for="description" class="control-label col-md-6">Category description</label>
<div class="col-md-8 ">

<form:textarea cols="" rows="5" path="description" id="description" class="form-control"  ></form:textarea>
</div>


</div>


<div class="form-group">


<div class="col-md-offset-4 col-md-8 col-8">
<input type="submit" name="sumbit" value="add category"  class="btn btn-primary" />
</div>


</div>


</form:form>




</div>

</div>



</div>



</div>

</div>