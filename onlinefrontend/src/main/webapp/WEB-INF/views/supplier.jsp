<%@ include file="template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<c:if test="${not empty msg}">	
		<div class="row">			
			<div class="col-md-6">			
				<div class="alert alert-info fade in">${msg}</div>				
			</div>
		</div>
	</c:if>

<div class="row">
<div class="col-md-6"> 
	<div id="input">
	<sf:form modelAttribute="supplier" action="${contextRoot}/supplier" autocomplete="off" method="POST">
					<div class="input-group">
						<span class="input-group-addon"><i class="icon-user"></i></span>
						<sf:input type="text" class="form-control" path="supplierName" placeholder="Enter Supplier Name" required="required" />
						<span class="input-group-btn"><button type="submit" class="form-control">Add</button></span>
						<sf:errors path="supplierName" cssStyle="color:red;"/>
					</div>
	</sf:form>
	</div>
</div>
</div>
<div class="row">
<div class="col-md-6">   
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
        							 <sf:form modelAttribute="supplier" action="${contextRoot}/supplier/update" autocomplete="off" method="POST">
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
									<a href="${contextRoot}/supplier/${supp.sid}/edit" class="btn btn-small btn-primary">
										<i class="btn-icon-only icon-ok"></i>										
									</a>
									
									<a href="${contextRoot}/supplier/${supp.sid}/remove" class="btn btn-small">
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
<%@ include file="template/footer.jsp" %>
