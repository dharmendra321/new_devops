<%@ include file="template/header.jsp"%>
					<script>
							window.category ='${category}';
						</script>
<h2>Product List</h2>
<div class="row">
	<div class="col-xs-offset-2 col-xs-8">
		<table id="productlist" class="table table-striped table-borderd">
			<thead>
				<tr>
					<th></th>
					<th>ProductName</th>
					<th>Brand</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>			
		</table>
	</div>
</div>
<hr/>
<br/>
<%@ include file="template/footer.jsp"%>
