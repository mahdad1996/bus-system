<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2020
  Time: 6:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/Style.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">

    <title>Sign up page</title>
</head>
<body>
<%@ page pageEncoding="UTF-8" %>

<jsp:include page="masterHeaderMenu.jsp"></jsp:include>

<div class="sign-up-form">
<div class="container">
    <div class="col-md-5 col-sm-6 float-md-right">
        <div class="text-center">ثبت نام</div>
        <form method="post" action="Signup">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Username" name="username">
                <input type="password" class="form-control" placeholder="Password" name="password">
                <input type="email" class="form-control" placeholder="Email" name="email">
                <input type="text" class="form-control" placeholder="First Name" name="firstname">
                <input type="text" class="form-control" placeholder="Last Name" name="lastname">
                <button type="submit" class="btn btn-info align-self-md-center">Signup</button>

            </div>
        </form>
    </div>

</div>
</div>



<jsp:include page="masterFooter.jsp"></jsp:include>



<script type="javascript" src="resources/js/jquery-3.4.1.slim.min.js"></script>
<script type="javascript" src="resources/js/popper.min.js"></script>
<script type="javascript" src="resources/js/bootstrap.js"></script>


</body>
</html>
