<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!--
PetClinic :: a Spring Framework demonstration
-->


    <title>PetDemo :: a Spring Framework demonstration</title>


    <spring:url value="/webjars/bootstrap/2.3.2/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/petdemo.css" var="petDemoCss"/>
    <link href="${petDemoCss}" rel="stylesheet"/>

    <spring:url value="/webjars/jquery/2.0.3/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

	<!-- jquery-ui.js file is really big so we only load what we need instead of loading everything -->
    <spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.core.js" var="jQueryUiCore"/>
    <script src="${jQueryUiCore}"></script>

	<spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.datepicker.js" var="jQueryUiDatePicker"/>
    <script src="${jQueryUiDatePicker}"></script>
    
    <!-- jquery-validation file is  -->
    <spring:url value="/webjars/jquery-validation/1.11.1/jquery.validate.js" var="jQueryValidate"/>
    <script src="${jQueryValidate}"></script>
    
    <!-- jquery-validation file is  -->
    <spring:url value="/webjars/jquery-validation/1.11.1/localization/messages_zh.js" var="jQueryValidateMessage"/>
    <script src="${jQueryValidateMessage}"></script>
   
    <!-- jquery-ui.css file is not that big so we can afford to load it -->
    <spring:url value="/webjars/jquery-validation/1.11.1/validate.css" var="jQueryValidateCss"/>
   	<link href="${jQueryValidateCss}" type="text/css" rel="stylesheet" />
    
    <!-- jquery-ui.css file is not that big so we can afford to load it -->
    <spring:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet"></link>
    
    <spring:url value="/webjars/bootstrap/2.3.2/css/bootstrap-responsive.min.css" var="bootstrapResponsiveCss"/>
    <link href="${bootstrapResponsiveCss}" rel="stylesheet">



