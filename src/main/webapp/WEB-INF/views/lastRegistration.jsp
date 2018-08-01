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
    <form:form action="/registeredLast" method="POST" modelAttribute="newUserSecondRegistration" class="form-signin">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h2 class="form-signin-heading" style="width: 350px; margin-bottom: 9%">Add info about your result</h2>

        <input type="hidden" value="${pageContext.request.userPrincipal.name}" name="username"/>

        <spring:bind path="profile">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Select your subject</label>
                <form:select path="profile" class="form-control">
                    <option value="mathphys">Physics-mathematics</option>
                    <option value="himbio">Chemistry-biology</option>
                    <option value="mathlang">Mathematics-english</option>
                </form:select>
            </div>
        </spring:bind>

        <spring:bind path="langResult">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Langusge</label>
                <form:input cssStyle="margin-top: -1%;" type="text" path="langResult" class="form-control"
                            placeholder="Language result"
                            autofocus="true"/>
                <form:errors path="langResult">
                </form:errors>
            </div>
        </spring:bind>

        <spring:bind path="mathResult">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Mathematic</label>
                    <form:input cssStyle="margin-top: -1%;" type="text" path="mathResult" class="form-control"
                                placeholder="Mathematics result"
                                autofocus="true"/>
                    <form:errors path="mathResult">
                </form:errors>
            </div>
        </spring:bind>

        <spring:bind path="physResult">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Physics</label>
                <form:input cssStyle="margin-top: -1%;" type="text" path="physResult" class="form-control"
                            placeholder="Physics result"
                            autofocus="true"/>
                <form:errors path="physResult">
                </form:errors>
            </div>
        </spring:bind>

        <spring:bind path="himResult">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Chemistry</label>
                <form:input cssStyle="margin-top: -1%;" type="text" path="himResult" class="form-control"
                            placeholder="Chemistry result"
                            autofocus="true"/>
                <form:errors path="himResult">
                </form:errors>
            </div>
        </spring:bind>

        <spring:bind path="biolResult">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Biology</label>
                <form:input cssStyle="margin-top: -1%;" type="text" path="biolResult" class="form-control"
                            placeholder="Biology result"
                            autofocus="true"/>
                <form:errors path="biolResult">
                </form:errors>
            </div>
        </spring:bind>

        <spring:bind path="englResult">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>English</label>
                <form:input cssStyle="margin-top: -1%;" type="text" path="englResult" class="form-control"
                            placeholder="English result"
                            autofocus="true"/>
                <form:errors path="englResult">
                </form:errors>
            </div>
        </spring:bind>


        <div class="form-group">
            <form action="/registeredLast" method="post">
                <input type="submit" value="Save" class="btn btn-lg btn-primary btn-block"/>
            </form>
            <form action="/goToRegistration" method="get">
                <input type="submit" value="Back" class="btn btn-lg btn-warning btn-block"/>
            </form>
            <form action="/main" method="get">
                <input type="submit" value="Cancel" class="btn btn-lg btn-danger btn-block"/>
            </form>
        </div>

    </form:form>
</div>
</body>
</html>
