<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/resources/images/logo20.png" var="banner"/>

	<header>
	<!-- topbar starts -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
	            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="brand brand-bootbus" href="#"><span>Pet Demo Web </span></a>
				<div class="nav-collapse collapse">
					<ul class="nav">
		              <li class="dropdown dropdown-small">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><small><fmt:message key="label.head.language"/></small><b class="caret"></b></a>
		                <ul class="dropdown-menu inline">
		                  <li><a href="<spring:url value="?lang=en" htmlEscape="true" />"><small><i class="intl-flag-us"></i>&nbsp;<fmt:message key="label.head.lang_en"/></small></a></li>
		                  <li><a href="<spring:url value="?lang=zh_CN" htmlEscape="true" />"><small><i class="intl-flag-cn"></i>&nbsp;<fmt:message key="label.head.lang_cn"/> </small></a></li>
		                </ul>
		              </li>
					</ul>
					<shiro:guest>
					<ul class="nav pull-right">
					  <a class="btn btn-small" href="/login"><i class="icon-user"></i> <fmt:message key="lable.head.signin"/></a>
					  <a class="btn btn-small" href="/login"><i class="icon-tag"></i> <fmt:message key="lable.head.signup"/></a>
					</ul>
					</shiro:guest>
					<shiro:authenticated>
					<ul class="nav pull-right">
					  <a class="brand" href="#"><span>Hello, <shiro:principal/> </span></a>
					  <button onclick="window.location.href='/logout'" class="btn"><fmt:message key="lable.head.logout"/></button>
					</ul>
					</shiro:authenticated>
				</div>
			</div>
		</div>
	</div>
	</header>

<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li style="width: 100px;">
            	<a href="<spring:url value="/welcome" htmlEscape="true" />">
            	<i class="icon-home"></i>&nbsp;<fmt:message key="label.home.menu.home"/></a></li>
            <li style="width: 135px;">
            	<a href="<spring:url value="/owners/find.html" htmlEscape="true" />">
            	<i class="icon-search"></i>&nbsp;<fmt:message key="label.home.menu.section1"/></a></li>
            <li style="width: 135px;">
            	<a href="<spring:url value="/vets.html" htmlEscape="true" />">
            	<i class="icon-th-list"></i>&nbsp;<fmt:message key="label.home.menu.section2"/></a></li>
            <li style="width: 135px;">
            	<a href="<spring:url value="/oups.html" htmlEscape="true" />" title="trigger a RuntimeException to see how it is handled">
            	<i class="icon-warning-sign"></i>&nbsp;<fmt:message key="label.home.menu.section3"/></a>
           	</li>
            <li style="width: 135px;">
            	<a href="<spring:url value="/vets.html" htmlEscape="true" />">
            	<i class="icon-th-list"></i>&nbsp;<fmt:message key="label.home.menu.section4"/></a></li>
            <li style="width: 80px;"><a href="#" title="not available yet. Work in progress!!">
            	<i class=" icon-question-sign"></i>&nbsp;<fmt:message key="label.home.menu.help"/></a></li>
        </ul>
    </div>
</div>
	
