<%--
  Created by IntelliJ IDEA.
  User: A E S T H E T I C
  Date: 21.09.2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4 m5 bg-success p-2 text-dark bg-opacity-10 rounded">
        <s:form method="post" action="/calc" modelAttribute="mathOperation">
            <s:label path="numOne" class="col-sm col-form-label" >Num one</s:label>
            <s:input path="numOne" class="form-control"/>
            <s:errors path="numOne"/>
            <s:label path="numTwo" cclass="col-sm col-form-label">Num two</s:label>
            <s:input path="numTwo" class="form-control"/>
            <s:errors path="numTwo"/>
            <s:label path="type" class="col-sm col-form-label">Type operation</s:label>
            <s:select path="type" class="form-select form-select-sm-3" items="${operations}"/>
            <s:button class="btn btn-primary m-2">Submit</s:button>
        </s:form>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-sm-5">
            <c:if test="${result_operation != null}">
                <div class="alert alert-info m-3" role="alert">
                    Result: ${result_operation.result}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
