<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<jsp:include page="../fragments/headTag.jsp"/>
</head>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <c:choose>
        <c:when test="${owner['new']}"><c:set var="method" value="post"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>
    <h2>
        <c:if test="${owner['new']}">New </c:if> Owner
    </h2>
    <form:form modelAttribute="owner" method="${method}" class="form-horizontal" id="add-owner-form">
    	<fmt:message key="label.firstname" var="firstname"/>
        <petclinic:inputField label="${firstname}" name="firstName"/>
        <fmt:message key="label.lastname" var="lastname"/>
        <petclinic:inputField label="${lastname}" name="lastName"/>
        <fmt:message key="label.address" var="address"/>
        <petclinic:inputField label="${address}" name="address"/>
        <fmt:message key="label.city" var="city"/>
        <petclinic:inputField label="${city}" name="city"/>
        <fmt:message key="label.telephone" var="telephone"/>
        <petclinic:inputField label="${telephone}" name="telephone"/>

        <div class="form-actions">
            <c:choose>
                <c:when test="${owner['new']}">
                    <button type="submit">Add Owner</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Owner</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
</div>
<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../fragments/bootstrap-js.jsp"/>
</body>

</html>
