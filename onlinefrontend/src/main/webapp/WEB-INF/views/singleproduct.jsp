<%@ include file="template/header.jsp"%>

<div class="col-sm-4 col-lg-4 col-md-4">
			<div class="thumbnail">
				<img src="${contextRoot}/resources/images/product/${product.pid}.jpg" alt="" >
				<div class="caption">
					<h4 class="pull-right">&#8377;${product.unitprice}</h4>
					<h4>
						<a href="#">${product.productName}</a>
					</h4>
					<p>${product.description}</p>
				</div>
				<div class="ratings">
					<p class="pull-right">${product.userView} views</p>
					<p>
				<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star-empty"></span>
				 
					</p>
				</div>
				<a href="${contextRoot}/product/all" class='btn btn-primary'>Continue Shoping</a>
				<a href="" class='btn btn-primary'>Add to Cart</a>
				
			</div>
			<br/>
<%@ include file="template/footer.jsp"%>
