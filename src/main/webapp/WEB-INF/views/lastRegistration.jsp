<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>

    <style>
        /* Popup container - can be anything you want */
        .popup {
            position: relative;
            display: inline-block;
            cursor: pointer;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        /* The actual popup */
        .popup .popuptext {
            visibility: hidden;
            width: 160px;
            background-color: #555;
            color: #fff;
            text-align: center;
            border-radius: 6px;
            padding: 8px 0;
            position: absolute;
            z-index: 1;
            bottom: 125%;
            left: 50%;
            margin-left: -80px;
        }

        /* Popup arrow */
        .popup .popuptext::after {
            content: "";
            position: absolute;
            top: 100%;
            left: 50%;
            margin-left: -5px;
            border-width: 5px;
            border-style: solid;
            border-color: #555 transparent transparent transparent;
        }

        /* Toggle this class - hide and show the popup */
        .popup .show {
            visibility: visible;
            -webkit-animation: fadeIn 1s;
            animation: fadeIn 1s;
        }

        /* Add animation (fade in the popup) */
        @-webkit-keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
    </style>

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
    <script src="/resources/myJSFunctions/selectDisabled.js"></script>
</head>
<body onload="onLoad()">
<div class="container">
    <form:form action="/registeredLast" method="POST" modelAttribute="newUserSecondRegistration" class="form-signin">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h2 class="form-signin-heading" style="width: 350px; margin-bottom: 9%">Add info about your result</h2>

        <input type="hidden" value="${pageContext.request.userPrincipal.name}" name="username"/>


        <spring:bind path="profile">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>Select your subject</label>
                <form:select path="profile" class="form-control" id="profile" onchange="onChange()">
                    <option value="chose" id="chose">Chose speciality...</option>
                    <option value="mathphys" id="mathphys">Physics-mathematics</option>
                    <option value="himbio">Chemistry-biology</option>
                    <option value="mathlang">Mathematics-english</option>
                </form:select>
            </div>
        </spring:bind>

        <div id="cert">
            <spring:bind path="certResult">
                <label>Certificate result</label>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input cssStyle="margin-top: -1%;" type="text" path="certResult" class="form-control"
                                autofocus="true" id="certResult"/>
                    <form:errors path="certResult">
                    </form:errors>
                </div>
            </spring:bind>
        </div>

        <div id="lang">
            <spring:bind path="langResult">
                <label>Language result</label>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input cssStyle="margin-top: -1%;" type="text" path="langResult" class="form-control"
                                autofocus="true" id="langResult"/>
                    <form:errors path="langResult">
                    </form:errors>
                </div>
            </spring:bind>
        </div>


        <div id="math">
            <spring:bind path="mathResult">
                <label>Mathematics result</label>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input cssStyle="margin-top: -1%;" type="text" path="mathResult" class="form-control"
                                autofocus="true" id="mathResult"/>
                    <form:errors path="mathResult">
                    </form:errors>
                </div>
            </spring:bind>
        </div>

        <div id="phys">
            <spring:bind path="physResult">
                <label>Physics result</label>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input cssStyle="margin-top: -1%;" type="text" path="physResult" class="form-control"
                                autofocus="true" id="physResult"/>
                    <form:errors path="physResult">
                    </form:errors>
                </div>
            </spring:bind>
        </div>

        <div id="him">
            <spring:bind path="himResult">
                <label>Chemistry result</label>
                <div class="form-group ${status.error ? 'has-error' : ''}" id="12">
                    <form:input cssStyle="margin-top: -1%;" type="text" path="himResult" class="form-control"
                                autofocus="true" id="himResult"/>
                    <form:errors path="himResult">
                    </form:errors>
                </div>
            </spring:bind>
        </div>

        <div id="biol">
            <spring:bind path="biolResult">
                <label>Biology result</label>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input cssStyle="margin-top: -1%;" type="text" path="biolResult" class="form-control"
                                autofocus="true" id="biolResult"/>
                    <form:errors path="biolResult">
                    </form:errors>
                </div>
            </spring:bind>
        </div>

        <div id="engl">
            <spring:bind path="englResult">
                <label>English result</label>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input cssStyle="margin-top: -1%;" type="text" path="englResult" class="form-control"
                                autofocus="true" id="englResult"/>
                    <form:errors path="englResult">
                    </form:errors>
                </div>
            </spring:bind>
        </div>

        <div>
            <form action="/registeredLast" method="post">
                <input id="buttonSave" type="submit" value="Save" class="btn btn-lg btn-primary btn-block"/>
            </form>
            <form action="/goToRegistration" method="get">
                <input id="buttonBack" type="submit" value="Back" class="btn btn-lg btn-warning btn-block"/>
            </form>
            <form action="/main" method="get">
                <input id="buttonCancel" type="submit" value="Cancel" class="btn btn-lg btn-danger btn-block"/>
            </form>
        </div>

    </form:form>
</div>
</body>
</html>
