<%@ include file="template/header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<c:if test="${not empty msg}">
	<div class="row">
		<div class="col-md-6">
			<div class="alert alert-info fade in">${msg}</div>
		</div>
	</div>
</c:if>
<div class="col-lg-9 col-sm-9">
	<div class="btn-pref btn-group btn-group-justified btn-group-lg"
		role="group" aria-label="...">
		<div class="btn-group" role="group">
			<c:choose>
				<c:when test="${tp=='product'}">
					<button type="button" id="product" class="btn btn-primary"
						href="#prod" data-toggle="tab">
				</c:when>
				<c:otherwise>
					<button type="button" id="product" class="btn btn-default"
						href="#prod" data-toggle="tab">
				</c:otherwise>
			</c:choose>
			<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
			<div class="hidden-xs">New Product</div>
			</button>
		</div>

		<div class="btn-group" role="group">
			<c:choose>
				<c:when test="${tp=='productList'}">			
			<button type="button" id="product" class="btn btn-primary"
				href="#prodlist" data-toggle="tab">
				</c:when>
		  <c:otherwise>
			<button type="button" id="product" class="btn btn-default"
				href="#prodlist" data-toggle="tab">
				</c:otherwise>
			</c:choose>
			
				<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
				<div class="hidden-xs">Product List</div>
			</button>
		</div>

		<div class="btn-group" role="group">
			<c:choose>
				<c:when test="${tp=='supplier'}">
					<button type="button" id="supplier" class="btn btn-primary"
						href="#supp" data-toggle="tab">
				</c:when>
				<c:otherwise>
					<button type="button" id="supplier" class="btn btn-default"
						href="#supp" data-toggle="tab">
				</c:otherwise>
			</c:choose>
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			<div class="hidden-xs">Supplier</div>
			</button>
		</div>

		<div class="btn-group" role="group">
			<c:choose>
				<c:when test="${tp=='category'}">
					<button type="button" id="category" class="btn btn-primary"
						href="#cate" data-toggle="tab">
				</c:when>
				<c:otherwise>
					<button type="button" id="category" class="btn btn-default"
						href="#cate" data-toggle="tab">
				</c:otherwise>
			</c:choose>
			<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
			<div class="hidden-xs">Category</div>
			</button>
		</div>
	</div>

	<div class="well">
		<div class="tab-content">
			<c:choose>
				<c:when test="${tp=='product'}">
					<div class="tab-pane fade in active" id="prod">
				</c:when>
				<c:otherwise>
					<div class="tab-pane fade in " id="prod">
				</c:otherwise>
			</c:choose>

			<div class="row">
				<div id="input">
					<sf:form modelAttribute="product"
						action="${contextRoot}/admin/product" autocomplete="off"
						method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4">Product Name</label>
							<div class="col-sm-6">
								<sf:input type="text" required="required" path="productName"
									class="form-control" placeholder="Enter Product Name" />
							</div>
							<sf:errors path="productName" cssStyle="color:red;" />
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Product Brand</label>
							<div class="col-sm-6">
								<sf:input type="text" required="required" path="brand"
									class="form-control col-md-6" placeholder="Enter Product Brand" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Product Description</label>
							<div class="col-sm-6">
								<sf:textarea rows="3" required="required" path="description"
									class="form-control col-md-6"
									placeholder="Enter Product Description" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Product Quantity</label>
							<div class="col-sm-6">
								<sf:input type="number" path="qty" class="form-control col-md-6"
									placeholder="Enter Product Quantity" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Product Price</label>
							<div class="col-sm-6">
								<sf:input type="text" path="unitprice" class="form-control"
									placeholder="Enter Product Price" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-sm-6">
								<sf:select path="cid" items="${categories}"
									itemLabel="categoryName" itemValue="cid" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Supplier</label>
							<div class="col-sm-6">
								<sf:select path="sid" items="${suppliers}"
									itemLabel="supplierName" itemValue="sid" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Product Image</label>
							<div class="col-sm-6">
								<sf:input type="file" path="pic" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Active</label>
							<div class="col-sm-6">
								<sf:checkbox path="isactive" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-6">
								<button type="submit" class="form-control btn-primary">Update</button>
							</div>
						</div>
					</sf:form>
				</div>

			</div>


		</div>
		<c:choose>
		<c:when test="${tp=='productList'}">			
		<div class="tab-pane fade in active" id="prodlist">
		</c:when>
		<c:otherwise>
		<div class="tab-pane fade in" id="prodlist">
		
		</c:otherwise>
		</c:choose>
			<div class="row">
				<div class="widget stacked widget-table action-table">
					<div class="widget-header">
						<i class="icon-th-list"></i>
						<h3>Product List</h3>
					</div>
					<!-- /widget-header -->
					<div class="widget-content">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Image</th>
									<th>Product ID</th>
									<th>Product Name</th>
									<th>Product Brand</th>
									<th>Description</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Suppplier</th>
									<th>Category</th>
									<th>Active</th>	
									<th class="td-actions">Modify</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="prod">
									<tr>
										<c:choose>
											<c:when test="${cmd=='edit' && id==prod.pid}">
												<td>${prod.pid }</td>
												<td colspan="2"><sf:form modelAttribute="product"
														action="${contextRoot}/admin/product/update"
														autocomplete="off" method="POST">
														<sf:hidden path="pid" value="${prod.pid}" />
														<div class="input-group">
															<span class="input-group-addon"><i
																class="icon-user"></i></span>
															<sf:input type="text" class="form-control"
																path="productName" placeholder="Enter Product Name"
																required="required" value="${prod.productName}" />
															<span class="input-group-btn"><button
																	type="submit" class="form-control">Update</button></span>
															<sf:errors path="productName" cssStyle="color:red;" />
														</div>
													</sf:form></td>

											</c:when>
											<c:otherwise>
												 <td><img src="<c:url value="/resources/images/product/${prod.pid}.jpg" />" alt="image" style="width:50%"/></td>
                  							<td>${prod.pid}</td>
												<td>${prod.productName }</td>
												<td>${prod.brand}</td>
												<td>${prod.description}</td>
												<td>${prod.qty}</td>
												<td>${prod.unitprice}</td>
												<td>${prod.sid}</td>
												<td>${prod.cid}</td>
												<td>${prod.isactive}</td>
												
												<td class="td-actions"><a
													href="${contextRoot}/admin/product/${prod.pid}/edit"
													class="btn btn-small btn-primary"> <i
														class="btn-icon-only icon-ok"></i>
												</a> <a href="${contextRoot}/admin/product/${prod.pid}/remove"
													class="btn btn-small"> <i
														class="btn-icon-only icon-remove"></i>
												</a></td>

											</c:otherwise>
										</c:choose> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /widget-content -->

				</div>
				<!-- /widget -->
			</div>

		</div>



		<c:choose>
			<c:when test="${tp=='supplier'}">
				<div class="tab-pane fade in active" id="supp">
			</c:when>
			<c:otherwise>
				<div class="tab-pane fade in" id="supp">
			</c:otherwise>
		</c:choose>

		<div class="row">
			<div id="input">
				<sf:form modelAttribute="supplier"
					action="${contextRoot}/admin/supplier" autocomplete="off"
					method="POST">
					<div class="input-group">
						<span class="input-group-addon"><i class="icon-user"></i></span>
						<sf:input type="text" class="form-control" path="supplierName"
							placeholder="Enter Supplier Name" required="required" />
						<span class="input-group-btn"><button type="submit"
								class="form-control">Add</button></span>
						<sf:errors path="supplierName" cssStyle="color:red;" />
					</div>
				</sf:form>
			</div>

		</div>
		<div class="row">
			<div class="widget stacked widget-table action-table">
				<div class="widget-header">
					<i class="icon-th-list"></i>
					<h3>Supplier List</h3>
				</div>
				<!-- /widget-header -->
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Supplier ID</th>
								<th>Supplier Name</th>
								<th class="td-actions">Modify</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${suppliers}" var="supp">
								<tr>
									<c:choose>
										<c:when test="${cmd=='edit' && id==supp.sid}">
											<td>${supp.sid }</td>
											<td colspan="2"><sf:form modelAttribute="supplier"
													action="${contextRoot}/admin/supplier/update"
													autocomplete="off" method="POST">
													<sf:hidden path="sid" value="${supp.sid}" />
													<div class="input-group">
														<span class="input-group-addon"><i
															class="icon-user"></i></span>
														<sf:input type="text" class="form-control"
															path="supplierName" placeholder="Enter Supplier Name"
															required="required" value="${supp.supplierName}" />
														<span class="input-group-btn"><button type="submit"
																class="form-control">Update</button></span>
														<sf:errors path="supplierName" cssStyle="color:red;" />
													</div>
												</sf:form></td>

										</c:when>
										<c:otherwise>

											<td>${supp.sid }</td>
											<td>${supp.supplierName }</td>
											<td class="td-actions"><a
												href="${contextRoot}/admin/supplier/${supp.sid}/edit"
												class="btn btn-small btn-primary"> <i
													class="btn-icon-only icon-ok"></i>
											</a> <a href="${contextRoot}/admin/supplier/${supp.sid}/remove"
												class="btn btn-small"> <i
													class="btn-icon-only icon-remove"></i>
											</a></td>

										</c:otherwise>
									</c:choose>
								</tr>

							</c:forEach>
						</tbody>
					</table>

				</div>
				<!-- /widget-content -->

			</div>
			<!-- /widget -->
		</div>

	</div>

	<c:choose>
		<c:when test="${tp=='category'}">
			<div class="tab-pane fade in active" id="cate">
		</c:when>
		<c:otherwise>
			<div class="tab-pane fade in" id="cate">
		</c:otherwise>
	</c:choose>

	<div class="tab-pane fade in" id="cate">
		<div class="row">
			<div id="input">
				<sf:form modelAttribute="category"
					action="${contextRoot}/admin/category" autocomplete="off"
					method="POST">
					<div class="input-group">
						<span class="input-group-addon"><i class="icon-user"></i></span>
						<sf:input type="text" class="form-control" path="categoryName"
							placeholder="Enter Category Name" required="required" />
						<span class="input-group-btn"><button type="submit"
								class="form-control">Add</button></span>
						<sf:errors path="categoryName" cssStyle="color:red;" />
					</div>
				</sf:form>
			</div>

		</div>
		<div class="row">
			<div class="widget stacked widget-table action-table">
				<div class="widget-header">
					<i class="icon-th-list"></i>
					<h3>Supplier List</h3>
				</div>
				<!-- /widget-header -->
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Category ID</th>
								<th>Category Name</th>
								<th class="td-actions">Modify</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${categories}" var="cate">
								<tr>
									<c:choose>
										<c:when test="${cmd=='edit' && id==cate.cid}">
											<td>${cate.cid }</td>
											<td colspan="2"><sf:form modelAttribute="category"
													action="${contextRoot}/admin/category/update"
													autocomplete="off" method="POST">
													<sf:hidden path="cid" value="${cate.cid}" />
													<div class="input-group">
														<span class="input-group-addon"><i
															class="icon-user"></i></span>
														<sf:input type="text" class="form-control"
															path="categoryName" placeholder="Enter Category Name"
															required="required" value="${cate.categoryName}" />
														<span class="input-group-btn"><button type="submit"
																class="form-control">Update</button></span>
														<sf:errors path="categoryName" cssStyle="color:red;" />
													</div>
												</sf:form></td>

										</c:when>
										<c:otherwise>

											<td>${cate.cid }</td>
											<td>${cate.categoryName }</td>
											<td class="td-actions"><a
												href="${contextRoot}/admin/category/${cate.cid}/edit"
												class="btn btn-small btn-primary"> <i
													class="btn-icon-only icon-ok"></i>
											</a> <a href="${contextRoot}/admin/category/${cate.cid}/remove"
												class="btn btn-small"> <i
													class="btn-icon-only icon-remove"></i>
											</a></td>

										</c:otherwise>
									</c:choose>
								</tr>

							</c:forEach>
						</tbody>
					</table>

				</div>
				<!-- /widget-content -->

			</div>
			<!-- /widget -->
		</div>

	</div>

</div>
</div>
</div>

</div>



<%@ include file="template/footer.jsp"%>