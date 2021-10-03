<%--
  Created by IntelliJ IDEA.
  User: A E S T H E T I C
  Date: 21.09.2021
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-6">
            <div>
                <ol class="list-group list-group m-3">
                    <c:forEach var="math_operation" items="${history_list}">
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <div class="ms-2 me-auto">
                                <div class="fw-bold">Operation: ${math_operation.type}.</div>
                                Num: ${math_operation.numOne}.
                                Num: ${math_operation.numTwo}.
                                Name: ${math_operation.user.name}.
                            </div>
                            <span class="badge bg-primary rounded-pill">Result: ${math_operation.result}.</span>
                        </li>
                    </c:forEach>
                </ol>
            </div>
        </div>
    </div>
</div>
</body>
</html>
