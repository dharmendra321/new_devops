<%@ include file="template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<c:if test="${not empty msg}">	
		<div class="row">			
			<div class="col-md-6">			
				<div class="alert alert-info fade in">${msg}</div>				
			</div>
		</div>
</c:if>
<div class="col-lg-6 col-sm-6">
        <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" id="product" class="btn btn-primary" href="#prod" data-toggle="tab">
            <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                <div class="hidden-xs">Product</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="supplier" class="btn btn-default" href="#supp" data-toggle="tab">
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <div class="hidden-xs">Supplier</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="category" class="btn btn-default" href="#cate" data-toggle="tab">
            <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
                <div class="hidden-xs">Category</div>
            </button>
        </div>
    </div>

   <div class="well">
      <div class="tab-content">
        <div class="tab-pane fade in " id="prod">
          <h3>This is tab 1</h3>
        </div>
        <div class="tab-pane fade in" id="supp">
  	        <div class="row">				 
					<div id="input">
						<sf:form modelAttribute="supplier" action="${contextRoot}/admin/supplier" autocomplete="off" method="POST">
						<div class="input-group">
						<span class="input-group-addon"><i class="icon-user"></i></span>
						<sf:input type="text" class="form-control" path="supplierName" placeholder="Enter Supplier Name" required="required" />
						<span class="input-group-btn"><button type="submit" class="form-control">Add</button></span>
						<sf:errors path="supplierName" cssStyle="color:red;"/>
						</div>
						</sf:form>
					</div>
				
			</div>
			<div class="row">
<div class="widget stacked widget-table action-table">
    			<div class="widget-header">
					<i class="icon-th-list"></i>
					<h3>Supplier List</h3>
				</div> <!-- /widget-header -->
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
					<c:forEach items="${supplierList}" var="supp">
					<tr>						
							<c:choose>
    							<c:when test="${cmd=='edit' && id==supp.sid}">
        							 <td>${supp.sid }</td>
        							 <td colspan="2">
        							 <sf:form modelAttribute="supplier" action="${contextRoot}/admin/supplier/update" autocomplete="off" method="POST">
									<sf:hidden path="sid" value="${supp.sid}"/>
									<div class="input-group">
										<span class="input-group-addon"><i class="icon-user"></i></span>
										<sf:input type="text" class="form-control" path="supplierName" 
										placeholder="Enter Supplier Name" required="required" value="${supp.supplierName}"/>
										<span class="input-group-btn"><button type="submit" class="form-control">Update</button></span>
										<sf:errors path="supplierName" cssStyle="color:red;"/>
									</div>
									</sf:form>
        							 </td>
        							 
        						  </c:when>    
    							 <c:otherwise>
       								
   										<td>${supp.sid }</td>
										<td>${supp.supplierName }</td>
										<td class="td-actions">
									<a href="${contextRoot}/admin/supplier/${supp.sid}/edit" class="btn btn-small btn-primary">
										<i class="btn-icon-only icon-ok"></i>										
									</a>
									
									<a href="${contextRoot}/admin/supplier/${supp.sid}/remove" class="btn btn-small">
										<i class="btn-icon-only icon-remove"></i>										
									</a>
								</td>
						
   								 </c:otherwise>
							</c:choose>
							</tr>
							
							</c:forEach>
														</tbody>
						</table>
					
				</div> <!-- /widget-content -->
			
			</div> <!-- /widget -->
         </div>
			
        </div>
       
       
        <div class="tab-pane fade in" id="cate">
          <div class="row">				 
					<div id="input">
						<sf:form modelAttribute="category" action="${contextRoot}/admin/category" autocomplete="off" method="POST">
						<div class="input-group">
						<span class="input-group-addon"><i class="icon-user"></i></span>
						<sf:input type="text" class="form-control" path="categoryName" placeholder="Enter Category Name" required="required" />
						<span class="input-group-btn"><button type="submit" class="form-control">Add</button></span>
						<sf:errors path="categoryName" cssStyle="color:red;"/>
						</div>
						</sf:form>
					</div>
				
			</div>
			<div class="row">
<div class="widget stacked widget-table action-table">
    			<div class="widget-header">
					<i class="icon-th-list"></i>
					<h3>Supplier List</h3>
				</div> <!-- /widget-header -->
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
					<c:forEach items="${categoryList}" var="cate">
					<tr>						
							<c:choose>
    							<c:when test="${cmd=='edit' && id==cate.cid}">
        							 <td>${cate.cid }</td>
        							 <td colspan="2">
        							 <sf:form modelAttribute="category" action="${contextRoot}/admin/category/update" autocomplete="off" method="POST">
									<sf:hidden path="cid" value="${cate.cid}"/>
									<div class="input-group">
										<span class="input-group-addon"><i class="icon-user"></i></span>
										<sf:input type="text" class="form-control" path="categoryName" 
										placeholder="Enter Category Name" required="required" value="${cate.categoryName}"/>
										<span class="input-group-btn"><button type="submit" class="form-control">Update</button></span>
										<sf:errors path="categoryName" cssStyle="color:red;"/>
									</div>
									</sf:form>
        							 </td>
        							 
        						  </c:when>    
    							 <c:otherwise>
       								
   										<td>${cate.cid }</td>
										<td>${cate.categoryName }</td>
										<td class="td-actions">
									<a href="${contextRoot}/admin/category/${cate.cid}/edit" class="btn btn-small btn-primary">
										<i class="btn-icon-only icon-ok"></i>										
									</a>
									
									<a href="${contextRoot}/admin/category/${cate.cid}/remove" class="btn btn-small">
										<i class="btn-icon-only icon-remove"></i>										
									</a>
								</td>
						
   								 </c:otherwise>
							</c:choose>
							</tr>
							
							</c:forEach>
														</tbody>
						</table>
					
				</div> <!-- /widget-content -->
			
			</div> <!-- /widget -->
         </div>
			
        </div>
    
        </div>
      </div>
    </div>
    
    </div>
            
    	
	
<%@ include file="template/footer.jsp" %>
	