<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/resources/images/logo20.png" var="banner"/>


		<!-- topbar starts -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
	            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="brand" href="#"><span>Pet Demo Web </span></a>
				<div class="nav-collapse collapse">
					<ul class="nav">
		              <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="lable.language"/><b class="caret"></b></a>
		                <ul class="dropdown-menu">
		                  <li><a href="<spring:url value="?lang=en" htmlEscape="true" />"><fmt:message key="lable.lang_en"/></a></li>
		                  <li><a href="<spring:url value="?lang=zh_CN" htmlEscape="true" />"><fmt:message key="lable.lang_cn"/></a></li>
		                </ul>
		              </li>
					</ul>
					<ul class="nav pull-right">
					  <button onclick="window.location.href='/login'" class="btn">Sign in</button>
					  <button type="submit" class="btn">Sign up</button>
					</ul>
				</div>
				<!-- 
				<span class="">
					<a href="<spring:url value="?lang=en" htmlEscape="true" />">EN</a>
					|<a href="<spring:url value="?lang=zh_CN" htmlEscape="true" />">CN</a>
				</span>
 				-->
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

<img src="${banner}"/>

<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li style="width: 100px;"><a href="<spring:url value="/welcome" htmlEscape="true" />"><i class="icon-home"></i>
                Home</a></li>
            <li style="width: 130px;"><a href="<spring:url value="/owners/find.html" htmlEscape="true" />"><i
                    class="icon-search"></i> Find owners</a></li>
            <li style="width: 140px;"><a href="<spring:url value="/vets.html" htmlEscape="true" />"><i
                    class="icon-th-list"></i> Veterinarians</a></li>
            <li style="width: 90px;"><a href="<spring:url value="/oups.html" htmlEscape="true" />"
                                        title="trigger a RuntimeException to see how it is handled"><i
                    class="icon-warning-sign"></i> Error</a></li>
            <li style="width: 80px;"><a href="#" title="not available yet. Work in progress!!"><i
                    class=" icon-question-sign"></i> Help</a></li>
        </ul>
    </div>
</div>
	
