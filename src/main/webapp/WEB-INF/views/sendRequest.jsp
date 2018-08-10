<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>

<div>
    <div class="container">

        <form:form action="/register" method="POST" modelAttribute="specialityValue" class="form-signin">
            <h2 class="form-signin-heading">Add info about yourself</h2>

            <spring:bind path="specialityValue">
                <label>Select your profile</label>
                <form:select path="specialityValue" class="form-control" id="specialityValue">
                    <c:forEach items="${specialities}" var="speciality">
                        <option value="${speciality.specialityID}">${speciality.specialityName}</option>
                    </c:forEach>
                </form:select>
            </spring:bind>

            <form action="/register" method="post"class="form-signin">
                <input type="hidden" name="username" value="${pageContext.request.userPrincipal.name}"/>
                <input type="submit" value="Register you request" class="btn btn-lg btn-primary btn-block"/>
            </form>
        </form:form>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </div>
</div>
</body>
</html>