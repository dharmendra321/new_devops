<%@include file="template/header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<c:forEach items="${products}" var="prod">					
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<h4 class="text-center">
						<span class="label label-info">${prod.brand}</span>
					</h4>
					<img src="<c:url value="/resources/images/product/${prod.pid}.jpg" />" class="img-responsive" height="50px" width="50px">
					<div class="caption">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<h3>${prod.productName }</h3>
							</div>
							<div class="col-md-6 col-xs-6 price">
								<h3>
									<label>${prod.unitprice}</label>
								</h3>
							</div>
						</div>
						<p>${prod.description}</p>
						<div class="row">
							<div class="col-md-6">
								<a class="btn btn-primary btn-product"><span
									class="glyphicon glyphicon-thumbs-up"></span> Like</a>
							</div>
							<div class="col-md-6">
								<a href="#" class="btn btn-success btn-product"><span
									class="glyphicon glyphicon-shopping-cart"></span> Buy</a>
							</div>
						</div>

						<p></p>
					</div>
				</div>
			</div>
			
			</c:forEach>
			
		</div>
	</div>
</div>


<%@include file="template/footer.jsp"%>
