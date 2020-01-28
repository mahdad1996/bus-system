<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2020
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/Style.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <title>Login</title>
</head>
<body>

<jsp:include page="masterHeaderMenu.jsp"></jsp:include>
<%String msg=null;%>
<%
    if(request.getSession().getAttribute("mok")!=null){
        msg = (String) request.getSession().getAttribute("mok");%>
        <div class="alert alert-success alert-position "><%=msg%></div>
<%}%>

 <% if(request.getSession().getAttribute("wi")!=null){
        msg = (String) request.getSession().getAttribute("wi");%>
        <div class="alert alert-warning alert-position "><%=msg%></div>
   <% }%>








<div class="sign-up-form">
    <div class="container">
        <div class="col-md-5 col-sm-6 float-md-right">
            <div class="text-center">ورود</div>
            <form method="post" action="Login">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Username" name="username">
                    <input type="password" class="form-control" placeholder="Password" name="password">

                    <button type="submit" class="btn btn-info align-self-md-center">Login</button>

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
