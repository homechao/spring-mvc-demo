<!DOCTYPE html>

<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html >

<jsp:include page="fragments/headTag.jsp"/>

<body>
<div id="main" class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>
    
    <div id="page_signin">
	    <div class="page-header-top">
	       <div class="container">
	           <h1><fmt:message key="lable.head.signin"/> &amp; <fmt:message key="lable.head.signup"/><small><fmt:message key="lable.head.title"/></small></h1>
	       </div>
	    </div>
	    <div class="container">
	       <div class="content">
	       	   <!-- 
	       	   <div class="row">
	       	   	   <div class="span12">
                       <div class="alert alert-success alert-dismissable">
                           <a class="close" href="#">×</a>
                           <p class="title"><strong>Signup almost complete!</strong></p>
                           <p>Please check your inbox for your account activation email. You won't be able to proceed without activating your account.</p>
                       </div>
	       	   	   </div>
	       	   </div>
	       	   -->
	           <div class="row">
	           	   <div class="span2">
	           	   </div>
	               <div class="span5">
                       <div id="signin" class="panel panel-default">
                           <div class="panel-heading"><fmt:message key="label.signin.login.title"/>:</div>
                           <div class="panel-body">
	                           <form:form modelAttribute="account" method="post">
	                               <fieldset>
    								  <fmt:message key="label.signin.username" var="username"/>
                                      <stag:inputField label="${username}" name="userName" labelfor="iusername"/>
    								  <fmt:message key="label.signin.password" var="password"/>
                                      <stag:inputField label="${password}" name="password" labelfor="ipassword"/>
                                      <div class="actions">
                                         <button type="submit" class="btn primary large"><fmt:message key="label.signin.login"/></button>
                                         <fmt:message key="label.signin.username" var="resetusername"/>
                                         <p class="reset"><fmt:message key="label.signin.login.recover"/> <a tabindex="4" href="/signin/reset" title="Recover your username or password"><fmt:message key="label.signin.login.recover.info"/></a></p>
                                      </div>
	                               </fieldset>
	                           </form:form>
                           </div>
                       </div>
                   </div>
                   <div class="span5">
 					   <div id="signup" class="panel panel-default">
                            <div class="panel-heading"><fmt:message key="label.signin.create.title"/></div>
                            <div class="panel-body">
	                            <form:form modelAttribute="regAccount" action="/signup" method="post" class="form-stacked">
	                                <fieldset>
    								  <fmt:message key="label.signin.username" var="username"/>
                                      <stag:inputField label="${username}" name="userName" labelfor="iusername"/>
    								  <fmt:message key="label.signin.name" var="name"/>
                                      <stag:inputField label="${name}" name="name" labelfor="iname"/>
    								  <fmt:message key="label.signin.email" var="email"/>
                                      <stag:inputField label="${email}" name="email" labelfor="imail"/>
    								  <fmt:message key="label.signin.password" var="password"/>
                                      <stag:inputField label="${password}" name="password" labelfor="ipassword"/>
                                      <div class="clearfix">
                                         <div class="input">
                                             <ul class="inputs-list">
                                                <li>
                                                	<label>
                                                 	<form:checkbox path="subscribe" value="true" tabindex="8" />
                                                 	<span><fmt:message key="label.signin.create.subscribe"/></span>
                                                 	</label>
                                              	</li>
                                             </ul>
                                         </div>
                                      </div>
                                      <div class="actions">
                                     	<button type="submit" class="btn primary large" tabindex="9"><fmt:message key="label.signin.creataccount"/>
                                     	</button>
                                      </div>
	                                </fieldset>
	                            </form:form>
	                         </div>
                   		</div>
	               </div>
	           </div>
	       </div>
	    </div>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</div>
<jsp:include page="fragments/bootstrap-js.jsp"/>
</body>
</html>