<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/27/2020
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/Style.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <title>User Page</title>
</head>
<body>
<%String currentUser=null;
  String currentUserName = null;
  String currentUserFamily= null;

%>
<jsp:include page="masterHeaderMenu.jsp"></jsp:include>
<%
    if(request.getSession().getAttribute("username")!=null) {
        currentUser = (String) request.getSession().getAttribute("username");
        currentUserName = (String) request.getSession().getAttribute("name");
        currentUserFamily = (String) request.getSession().getAttribute("family");
    }
%>

<div class="container">

    <div class="row">
        <div class="col-md-12 col-sm-6">
            <div class="alert alert-info alert-position">You are Logged in as <%=currentUser%> </div>
            <p>Your Name: <%=currentUserName%></p>
            <p>Your Last Name: <%=currentUserFamily%></p>
            <p>Date of login : <%=new Date()%></p>
            <form method="post" action="Logout">
                <button type="submit" class="btn btn-danger">خروج</button>
            </form>
        </div>

        <div class="clearfix"></div>

        <div class="col-md-12 col-sm-6">
            <div class="search-form">
            <form>
                <div class="form-group row flex-row-reverse">

                    <label>مبدا : </label>
                        <input name="source" type="text" class="form-control"/>


                    <label>مقصد :</label>
                        <input name="destination" type="text" class="form-control"/>


                    <label>تاریخ :</label>
                        <input name="destination" type="text" class="form-control"/>


                    ‌<button type="submit" class="btn btn-info">Search</button>

                </div>


            </form>
            </div>

        </div>
    </div>

</div>

<jsp:include page="masterFooter.jsp"></jsp:include>



<script type="javascript" src="resources/js/jquery-3.4.1.slim.min.js"></script>
<script type="javascript" src="resources/js/popper.min.js"></script>
<script type="javascript" src="resources/js/bootstrap.js"></script>

</body>
</html>
