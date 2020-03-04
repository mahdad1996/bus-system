<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="main.com.team3d.busTravelingSystem.Persistent.Models.Travel" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/28/2020
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="resources/datepicker/css/persianDatepicker-default.css" />

    <link rel="stylesheet" href="resources/css/Style.css"/>
    <link rel="stylesheet" href="resources/css/bootstrap.css"/>
    <script type="text/javascript" src="resources/datepicker/js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="resources/datepicker/js/persianDatepicker.js"></script>

    <script type="text/javascript">
        $(function() {
            $("#myDate, #span1").persianDatepicker();
        });
    </script>
    <title>Admin Page</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");%>
<%String currentUser=null;
    String currentUserName = null;
    String currentUserFamily= null;
    String currentUserRole=null;
%>

<jsp:include page="masterHeaderMenu.jsp"></jsp:include>
<%
    if(request.getSession().getAttribute("username")!=null) {
        currentUser = (String) request.getSession().getAttribute("username");
        currentUserName = (String) request.getSession().getAttribute("name");
        currentUserFamily = (String) request.getSession().getAttribute("family");
        currentUserRole = (String) request.getSession().getAttribute("role");
    }


%>

<%
    if(request.getAttribute("adt")!=null){
       String savedAdt = (String) request.getAttribute("adt");%>
        <div class="alert alert-success alert-position "><%=savedAdt%></div>
<%}%>


<div class="container">

    <div class="row">
        <div class="col-md-12 col-sm-6">
            <div class="alert alert-info alert-position">You are Logged in as <%=currentUser%></div>
            <p>Wellcome : </p>
            <p>Your Name: <%=currentUserName%></p>
            <p>Your Last Name: <%=currentUserFamily%></p>
            <p>Logged in as : <%=currentUserRole%></p>
            <p>Date of login : <%=new Date()%></p>
            <form method="post" action="Logout">
                <button type="submit" class="btn btn-danger">خروج</button>
            </form>
        </div>

    </div>
</div>
<div class="sign-up-form">
    <div class="container">



            <div class="col-md-5 col-sm-6 float-md-right">
                <div class="text-right">فرم ورود اطلاعات سفر</div>

                <form method="post" action="AddTravel">
                    <div class="form-group row flex-row-reverse">
                        <input name="source" type="text" class="form-control" placeholder="اطلاعات مبدا"/>
                        <input name="destination" type="text" class="form-control" placeholder="اطلاعات مقصد" />
                        <input name="dateOfTravel" id="myDate" type="text" class="form-control"/>
                        <span id="span1"></span>

                        <input name="hourOfTravel" type="text" class="form-control" placeholder="ساعت حرکت"/>

                        ‌<button type="submit" class="btn btn-info">افزودن</button>

                    </div>


                </form>
            </div>

        </div>

    </div>
<div class="clearfix"></div>
<div class="table">
<div class="container">

    <form action="ShowTravels" method="post">

        <button type="submit">show All</button>
        <% if(request.getAttribute("listTravels")!=null){%>
        <table class="table-striped">
            <thead>
            <tr>
                <th scope="col">شناسه سفر</th>
                <th scope="col">مبدا سفر</th>
                <th scope="col">مقصد سفر</th>
                <th scope="col">تاریخ سفر</th>
                <th scope="col">ساعت سفر</th>
            </tr>

            </thead>

            <%
                List<Travel> travels = (List<Travel>) request.getAttribute("listTravels");
                for (Travel travel : travels) {%>
            <tbody>
                <tr>
                    <td><%=travel.getId()%></td>
                    <td><%=travel.getSource()%></td>
                    <td><%=travel.getDestination()%></td>

                    <td><%=travel.getPersianDate()%></td>
                    <td><%=travel.getHour()%></td>
                </tr>
            </tbody>
            <%
                }
            %>

        </table>
        <%
            }
        %>

    </form>

</div>
</div>

<jsp:include page="masterFooter.jsp"></jsp:include>


<%--<script type="javascript" src="resources/js/jquery-3.4.1.slim.min.js"></script>--%>
<script type="javascript" src="resources/js/popper.min.js"></script>
<script type="javascript" src="resources/js/bootstrap.js"></script>


</body>
</html>
