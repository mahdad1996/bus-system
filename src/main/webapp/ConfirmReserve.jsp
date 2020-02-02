<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2020
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="resources/css/Style.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">

    <title>Confirm Reserve</title>
</head>
<body>
<jsp:include page="masterHeaderMenu.jsp"></jsp:include>

<div class="clearfix"></div>
<div class="container col-md-12">

    <div class="row col-md-4 col-md-offset-4">
        <table class="table-striped">
            <tr>
                <td>نام و نام خانوادگی</td>
                <td><%=request.getSession().getAttribute("family") + " " + request.getSession().getAttribute("name")%></td>
            </tr>

            <tr>
                <td>شناسه سفر</td>
                <td><%=request.getSession().getAttribute("tid")%></td>
            </tr>

            <tr>
                <td>جنسیت :</td>
                <td>
                    <form class="justify-content-between" method="post" action="ConfirmOk">
                        <label class="radio-inline">
                            <input value="male" type="radio" name="op" checked>مرد
                        </label>
                        <label class="radio-inline">
                            <input value="female" type="radio" name="op">زن
                        </label>

                    <button class="btn btn-info   align-self-md-center">تایید</button>

                    </form>
                </td>
            </tr>


        </table>


    </div>


    </div>




<jsp:include page="masterFooter.jsp"></jsp:include>


<script type="javascript" src="resources/js/jquery-3.4.1.slim.min.js"></script>
<script type="javascript" src="resources/js/popper.min.js"></script>
<script type="javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>
