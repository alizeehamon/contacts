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
    <title>Sign up</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2 class="text-center mt-3">Create an account</h2>
<div class="container mt-3">
     <form method="post" action="${pageContext.request.contextPath}/register">
         <div class="mb-3">
             <label class="form-label" for="email">Username</label>
             <input type="text" class="form-control" id="username" placeholder="Enter your username" name="username" required>
         </div>
         <div class="mb-3">
             <label class="form-label" for="email">Email</label>
             <input type="email" class="form-control" id="email" placeholder="Enter your email" name="email" required>
         </div>
         <div class="mb-3">
             <label class="form-label" for="password">Password</label>
             <input type="password" class="form-control" id="password" name="password" required>
         </div>
         <div class="text-center mb-3">
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
             <button type="submit" class="btn btn-primary">Sign up</button>
         </div>
     </form>
   <%-- <form:form method="post" action="${pageContext.request.contextPath}/register" modelAttribute="userDTO">
        <div class="mb-3">
            <label class="form-label" for="email">Email</label>
            <form:input type="email" class="form-control" id="email" placeholder="Enter your email" required="true"
                        path="email"/>
            <form:errors path="email" cssClass="alert alert-danger"></form:errors>
        </div>
        <div class="mb-3">
            <label class="form-label" for="password">Password</label>
            <form:input type="password" class="form-control" id="password" required="true" path="password"/>
            <form:errors path="password" cssClass="alert alert-danger"></form:errors>
        </div>
        <div class="text-center mb-3">
            <button type="submit" class="btn btn-primary">Sign up</button>
        </div>
    </form:form>--%>
</div>
</body>
</html>