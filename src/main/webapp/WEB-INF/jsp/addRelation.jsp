<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Add a relationship</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body class="bg-light">
<h2 class="text-center mt-3">Add a Contact</h2>
<div class="container mt-3">
<form action="${pageContext.request.contextPath}/addRelation/${contact.id}" method="post">
<div class="mb-3">
    <%--@declare id="form"--%><label for="form" class="form-label">Add a relationship to this contact</label>
    <select class="form-select" aria-label="Default select example" name="idTargetContact">
        <option selected>-- Find a contact in your list -- </option>
        <c:forEach items="${contacts}" var="addContact"><option value="${addContact.id}">${addContact.firstName} ${addContact.lastName}</option></c:forEach>
    </select>
</div>
<div class="mb-3">
    <label for="relationType" class="form-label">Relationship with ${contact.firstName}</label>
    <input class="form-control" type="text" id="relationType" name="relationType">
</div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="text-center mb-3">
        <button type="submit" class="btn btn-primary">Save the relationship</button>
    </div>
</form>
</div>
</body>
</html>