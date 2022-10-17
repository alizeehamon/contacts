<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Add a contact</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body class="bg-light">
<h2 class="text-center mt-3">Add a Contact</h2>
<div class="container mt-3">
    <form method="post" action="${pageContext.request.contextPath}/add" enctype="multipart/form-data">
        <div class="mb-3">
            <label class="form-label" for="firstName">Contact's first name</label>
            <input type="text" class="form-control" id="firstName" placeholder="Paul" name="firstName">
        </div>
        <div class="mb-3">
            <label class="form-label" for="lastName">Contact's last name</label>
            <input type="text" class="form-control" id="lastName" placeholder="Jones" name="lastName">
        </div>
        <div class="mb-3">
            <label class="form-label" for="email">Contact's email</label>
            <input type="email" class="form-control" id="email" placeholder="paul.jones@gmail.com" name="email">
        </div>
        <div class="mb-3">
            <label class="form-label" for="phone">Contact's phone</label>
            <input type="text" class="form-control" id="phone" placeholder="0671184953" name="phone">
        </div>
        <div class="mb-3">
            <label class="form-label" for="address1">Contact's address</label>
            <input type="text" class="form-control" id="address1" placeholder="15 rue des Lilas" name="address1">
        </div>
        <div class="mb-3">
            <label class="form-label" for="address2">Contact's address complement</label>
            <input type="text" class="form-control" id="address2" placeholder="Batiment B Appartement 12" name="address2">
        </div>

        <div class="mb-3">
            <label class="form-label" for="zipCode">Contact's zipcode</label>
            <input type="number" class="form-control" id="zipCode" placeholder="44000" name="zipCode">
        </div>
        <div class="mb-3">
            <label class="form-label" for="city">Contact's city</label>
            <input type="text" class="form-control" id="city" placeholder="Nantes" name="city">
        </div>

        <div class="mb-3">
            <label class="form-label" for="country">Contact's country</label>
            <input type="text" class="form-control" id="country" placeholder="France" name="country">
        </div>

        <div class="mb-3">
            <label class="form-label" for="birthdate">Contact's birthdate</label>
            <input type="date" class="form-control" id="birthdate" name="birthdate">
        </div>
        <div class="mb-3">
            <label class="form-label" for="webSite">Contact's website</label>
            <input type="text" class="form-control" id="webSite" placeholder="http/mysite.com" name="webSite">
        </div>
        <div class="mb-3">
            <label class="form-label" for="encounterSummary">How you two met</label>
            <input type="text" class="form-control" id="encounterSummary" placeholder="At work during a seminar" name="encounterSummary">
        </div>
        <div class="mb-3">
            <label class="form-label" for="company">Contact's work place</label>
            <input type="text" class="form-control" id="company" placeholder="Capgemini" name="company">
        </div>
        <div class="mb-3">
            <label class="form-label" for="companyRole">Contact's role in his/her company</label>
            <input type="text" class="form-control" id="companyRole" placeholder="Software engineer" name="companyRole">
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Picture of the contact</label>
            <input class="form-control" type="file" id="image" name="image">
        </div>

        <div class="text-center mb-3">
            <button type="submit" class="btn btn-primary">Save the contact</button>
        </div>
    </form>
</div>
</body>
</html>