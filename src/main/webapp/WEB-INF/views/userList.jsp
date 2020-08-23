<%@ taglib prefix="jstl" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gentelella Alela! | </title>

    <link href="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <link href="/resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <link href="/resources/build/css/custom.min.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <style>
        .highlight {
            background: red;
        }
    </style>
</head>

<div class="col-md-6 col-sm-6  ">
    <div class="x_panel">
        <div class="x_title">
            <h2>Hover rows <small>Try hovering over the rows</small></h2>
            <ul class="nav navbar-right panel_toolbox">
                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">Settings 1</a>
                        <a class="dropdown-item" href="#">Settings 2</a>
                    </div>
                </li>
                <li><a class="close-link"><i class="fa fa-close"></i></a>
                </li>
            </ul>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}" varStatus="status">
                        <tr id="${user.username}">
                            <th scope="row">${status.index + 1}</th>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.username}</td>
                        </tr>
                    </c:forEach>
                <%--<tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                </tr>--%>
                </tbody>
            </table>
        </div>
    </div>

    <button type="button" class="btn btn-round btn-success" onclick="addUser();">Add User</button>
    <button type="button" class="btn btn-round btn-success" onclick="findMe();">Find Me</button>
</div>
</html>

<script>
    function addUser() {
        $.ajax({
            url: '/userAdd',
            data: {
                firstName: 'Steve',
                lastName: 'Jobs',
                username: 'apple man',
            },
            type: 'POST',
            error: function (error) {
                console.log(error)
                alert('Fail to save... | error msg : ' + error.responseText);
            },
            success: function (result) {
                alert(result);
                location.reload();
            }
        });
    }

    function findMe() {

        $("tr[id*='minssogi']").toggleClass('highlight')

    }
</script>
