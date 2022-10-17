<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Edit my account</title>

</head>
<body class="bg-light">
<jsp:include page="header.jsp"></jsp:include>
<h2 class="text-center mt-3">Edit my account</h2>
<div class="container mt-3">

    <form:form action="${pageContext.request.contextPath}/account" method="post" modelAttribute="userDTO">

        <div class="mb-3">
            <label class="form-label" for="lastName">Lastname</label>
            <form:input type="lastname" class="form-control" id="lastName" placeholder="Enter your lastname" path="lastName" required="true"/>
                <%--        <form:errors path="lastName" cssClass="alert alert-danger"></form:errors>--%>
        </div>

        <div class="mb-3">
            <label class="form-label" for="firstName">Firstname</label>
            <form:input type="firstName" class="form-control" id="firstName" placeholder="Enter your firstname" path="firstName" required="true"/>
                <%--        <form:errors path="firstName" cssClass="alert alert-danger"></form:errors>--%>
        </div>

        <div class="mb-3">
            <label class="form-label" for="email">Email</label>
            <form:input  id="email" type="email" class="form-control" placeholder="Enter your email" path="email" required="true"/>
            <form:errors path="email" cssClass="alert alert-danger"></form:errors>
        </div>


        <div class="mb-3">
            <label class="form-label" for="password">Password</label>
            <form:input type="password" class="form-control" id="password" placeholder="Enter your password" path="password" required="true"/>
            <form:errors path="password" cssClass="alert alert-danger"></form:errors>
        </div>


        <div class="mb-3">
            <label class="form-label" for="image">Profile picture</label>
            <form:input type="text" class="form-control" id="image" placeholder="Enter a profile picture url" path="image" required="true"/>
                <%--        <form:errors path="image" cssClass="alert alert-danger"></form:errors>--%>
        </div>


        <div class="text-center mb-3">
            <form:button type="submit" class="btn btn-primary">Sign up</form:button>
        </div>



        <!--<spring:hasBindErrors name="createUser">
        <c:forEach var="error" items="${errors.allErrors}">
            <spring:message code="${error.code}"
                            arguments="${error.arguments}"
                            text="${error.defaultMessage}"/><br/>
        </c:forEach>
    </spring:hasBindErrors>-->


    </form:form>
</div>
</body>
</html>