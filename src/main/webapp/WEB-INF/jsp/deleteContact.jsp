<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="../../resources/static/css/style.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Add a book</title>
</head>
<body class="bg-light">
<jsp:include page="header.jsp"></jsp:include>
<h2 class="text-center mt-3">Are you sure you want to delete ${contact.firstName} ${contact.lastName} ?</h2>
<div class="container mt-3">
    <form method="post" action="${pageContext.request.contextPath}/delete/${contact.id}">
        <div class="text-center mb-3">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input hidden name="contactId" value="${contact.id}">
            <button class="btn btn-primary mt-2" type="submit">Yes</button>
        </div>
    </form>
    <div class="text-center mb-3">
        <form action="${pageContext.request.contextPath}/" method="get">
            <button class="btn btn-danger mt-2" type="submit">No</button>
        </form>
    </div>
    </form>
</div>
</body>
</html>