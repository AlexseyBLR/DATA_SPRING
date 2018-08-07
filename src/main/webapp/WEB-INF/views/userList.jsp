<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorator="templates/layouts/admin-layout">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css"
          integrity="2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style>
        /*table{}*/
        /*tbody tr.selected{*/
            /*background: #1b6d85;*/
            /*color: seashell;*/
        /*}*/
        table tr.marked{
            background-color: #1b6d85;
            color: snow;
        }
    </style>

</head>
<body>

<script>
    $(document).ready(function(){
        $('table tr').on('click', function(e) {
            $('table tr').removeClass('marked');
            $(this).addClass('marked');
        });
    });
</script>


<div class="table-responsive">
    <table id="entityTable" class="table">
        <thead class="thead-inverse">
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Patronymic</th>
            <th>Email</th>
            <th>Age</th>
            <th>Sex</th>
            <th>Profile</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr name="entityRow">
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.patronymic}</td>
                    <td>${user.username}</td>
                    <td>${user.age}</td>
                    <td>${user.sex}</td>
                    <td>${user.profile}</td>
                    <form>
                        <input type="hidden" name="selectedEntitySingleId" value="${user.username}">
                    </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div id="clickedRowButtons" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <!-- Button to modal -->
                <div>
                    <input type="hidden" name="selectedEntitySingleId" value="-1">
                    <input type="submit" id="launchModalDelete" class="btn btn-danger" value="delete" data-toggle="modal"
                           data-target="#exampleModal"/>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><h2>Confirm deleting</h2></h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Are you sure?
                            </div>
                            <div class="modal-footer">

                                <form action="/admin/delete" method="post">
                                    <input type="hidden" name="selectedEntitySingleId" value="-1">
                                    <input type="submit" class="btn btn-primary" value="Delete">
                                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </div>
    <br/>

    <form action="/admin">
    <button type="submit" class="btn btn-group-lg btn-primary">Back</button>
    </form>

    <script src="/resources/myJSFunctions/select-row-plugin.js"></script>

</body>
</html>
