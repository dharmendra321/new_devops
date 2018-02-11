<%@ include file="template/header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="container" style="margin-top: 40px">


	<div class="row">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong> Sign in to continue</strong>
				</div>
				<div class="panel-body">
					<form role="form" action="${contextRoot}/login" method="POST" id="loginForm" >
						<fieldset>
							<div class="row">
								<c:if test="${not empty message}">
									<div class="alert alert-danger fade in">${message}</div>
								</c:if>
							</div>
							<div class="row">
								<div class="col-sm-12 col-md-10  col-md-offset-1 ">
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-user"></i>
											</span> <input class="form-control" placeholder="Email"
												name="username" id="username" type="email" autofocus required>
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-lock"></i>
											</span> <input class="form-control" placeholder="Password"
												name="password" type="password" id="password" value="" required>
										</div>
									</div>
									
									<div class="form-group">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										
									<input type="submit" class="btn btn-lg btn-primary btn-block"
											value="Sign in">
										
									</div>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="panel-footer ">
					Don't have an account! <a href="${contextRoot}/register" onClick=""> Sign Up Here </a>
				</div>
			</div>
		</div>
	</div>
</div>



<%@ include file="template/footer.jsp"%>
