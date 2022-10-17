<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
</head>
<body>
<!--Main Navigation-->
<header>
    <!-- Animated navbar-->
    <nav class="navbar navbar-expand-lg fixed-top navbar-scroll">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="background-color: #1D1D1D">
                    <li class="nav-item active">
                        <a class="nav-link text-white" aria-current="page"
                           href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a
                                class="nav-link text-white"
                                href="${pageContext.request.contextPath}/add"
                        >Add a contact</a
                        >
                    </li>
                    <li class="nav-item">
                        <a
                                class="nav-link text-white"
                                href="${pageContext.request.contextPath}/account"
                        ><sec:authorize access="isAuthenticated()">
                            <sec:authentication property="principal.username" />
                        </sec:authorize></a
                        >
                    </li>
                    <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <form:form action="/login" method="post">
                        <button class="nav-link text-white border-none" type="submit"
                                style="background-color: #1D1D1D; line-height: normal">
                            Login
                        </button>
                        </form:form>
                        </sec:authorize>
                    <li class="nav-item">
                        <sec:authorize access="isAuthenticated()">
                            <form:form action="/logout" method="post">
                                <button class="nav-link text-white border-none" type="submit"
                                        style="background-color: #1D1D1D; line-height: normal">
                                    Logout
                                </button>
                            </form:form>
                        </sec:authorize>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Animated navbar -->

    <!-- Background image -->
    <div
            id="intro"
            class="bg-image"
            style="
              background-image: url(https://images.pexels.com/photos/205414/pexels-photo-205414.jpeg);
              background-size: cover;
              height: 100vh;
              "
    >
        <div class="mask text-white" style="background-color: rgba(0, 0, 0, 0.8)">
            <div class="container d-flex align-items-center text-center h-100">
                <div>
                    <h1 class="mb-5">My Contact list</h1>
                    <p>
                        Welcome to your contact list. Here you can see all your relationships centered in one and one only unique tool. Edit your contacts' information, see everyone you love and why not try to reach out to them?
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- Background image -->
</header>
<!--Main Navigation-->

</body>
</html>