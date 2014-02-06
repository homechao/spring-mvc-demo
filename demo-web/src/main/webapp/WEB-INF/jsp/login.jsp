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
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>
    <h2><fmt:message key="accountlogin"/></h2>
    
    <form:form modelAttribute="account"  method="post" class="form-horizontal" id="login-form">
    	<fmt:message key="label.username" var="username"/>
        <stag:inputField label="${username}" name="userName"/>
        <fmt:message key="label.password" var="password"/>
        <stag:passwordField label="${password}" name="password"/>
        
        <div class="form-actions">
            <button type="submit">login</button>
        </div>
    </form:form>
    
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>