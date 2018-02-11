<%@ include file="template/header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="col-sm-6 col-sm-offset-3 ">
<c:if test="${not empty message}">
	<div class='alert'>${message}</div>
</c:if>

<div class="panel panel-primary">
	<div class="panel-heading text-center"><h3>User Registration</h3></div>
	<sf:form class="form-horizontal" method="post"
		action="${contextRoot}/register" modelAttribute="userdetails">
		<div class="panel-body">
			<div class="form-group">
				<label for="name" class="cols-sm-2 control-label">Your Name</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user"
							aria-hidden="true"></i></span>
						<sf:input type="text" class="form-control" path="userName"
							id="name" placeholder="Enter your Name" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="mobile" class="cols-sm-2 control-label">Your
					Mobile</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
						<sf:input type="text" class="form-control" path="mobile"
							id="mobile" placeholder="Enter your Mobile" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="cols-sm-2 control-label">Your
					Email</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope" aria-hidden="true"></i></span>
						<sf:input type="email" class="form-control" path="email"
							id="email" placeholder="Enter your Email" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="cols-sm-2 control-label">Password</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user"
							aria-hidden="true"></i></span>
						<sf:input type="password" class="form-control" path="password"
							id="password" placeholder="Enter your Password" />
					</div>
				</div>
			</div>

		</div>
		<div class="panel-footer">
			<div class="form-group ">
				<button type="submit"
					class="btn btn-primary btn-lg btn-block login-button">Register</button>
			</div>
		</div>
	</sf:form>
</div>
</div>
<%@ include file="template/footer.jsp"%>