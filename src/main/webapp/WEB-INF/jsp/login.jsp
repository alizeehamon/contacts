<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign in</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2 class="text-center mt-3">Sign in</h2>
<div class="container mt-3">
    <form method="post" action="${pageContext.request.contextPath}/login">
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
            <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
    </form>
</div>
</body>
</html>