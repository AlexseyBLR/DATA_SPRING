<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
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
<div class="container">
    <form:form action="/registered" method="POST" modelAttribute="newUserFirstRegistration" class="form-signin">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h2 class="form-signin-heading" style="width: 310px;">Add info about yourself</h2>
        <input type="hidden" value="${pageContext.request.userPrincipal.name}" name="username"/>
        
        <spring:bind path="firstname">
            <label>First name</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstname" class="form-control" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="firstname"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="lastname">
            <label>Last name</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastname" class="form-control" placeholder="Last name"
                            autofocus="true"/>
                <form:errors path="lastname">
                </form:errors>
            </div>
        </spring:bind>
        <spring:bind path="patronymic">
            <label>Patronymic</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="patronymic" class="form-control" placeholder="Patronymic"
                            autofocus="true"/>
                <form:errors path="patronymic">
                </form:errors>
            </div>
        </spring:bind>
        <spring:bind path="age">
            <label>Age</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="age" class="form-control" placeholder="Age"
                            autofocus="true"/>
                <form:errors path="age">
                </form:errors>
            </div>
        </spring:bind>
        <spring:bind path="sex">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Select your sex:</label>
                <form:select path="sex" class="form-control">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </form:select>
            </div>
        </spring:bind>


        <div class="form-group">
            <form action="/registered" method="post">
                <input type="submit" value="Save" class="btn btn-lg btn-primary btn-block"/>
            </form>
            <form action="/main" method="get">
                <input type="submit" value="cancel" class="btn btn-lg btn-danger btn-block"/>
            </form>
        </div>

    </form:form>
</div>
</body>
</html>
