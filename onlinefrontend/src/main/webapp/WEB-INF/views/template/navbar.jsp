<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <nav class="navbar navbar-inverse " role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li id="supplier">
                        <a href="${contextRoot}/admin/view">Admin</a>
                    </li>
					
					<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">Product List<span class="caret"></span></a>
					<ul class="dropdown-menu">
						   <c:forEach items="${category}" var="cate">
						   <li><a href="${contextRoot}/category/${cate.cid}">${cate.categoryName}</a> </li>
						   </c:forEach>
					
					</ul>
					</li>                
               
                    <li id="about">
                        <a href="${contextRoot}/about">About</a>
                    </li>

                    <li id="contact">
                        <a href="${contextRoot}/contact">Contact</a>
                    </li>
                </ul>
			    <ul class="nav navbar-nav navbar-right">
			    </ul>                
                
            </div>
          </div>    
    </nav>

