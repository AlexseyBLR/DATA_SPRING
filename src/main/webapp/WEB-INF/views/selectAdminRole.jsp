<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <title>Select user role</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>

<div>
    <form action="/main" method="get" class="form-signin">
        <button type="submit" style="font-weight: bold;" class="btn btn-lg btn-primary btn-block">USER MODE</button>
    </form>

    <form action="/admin" method="get" class="form-signin">
        <button type="submit" style="font-weight: bold;" class="btn btn-lg btn-primary btn-block">ADMIN MODE</button>
    </form>

</div>
</body>
</html>
