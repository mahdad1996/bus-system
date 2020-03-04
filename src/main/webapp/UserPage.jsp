
<%@ page import="java.util.Date" %>
<%@ page import="main.com.team3d.busTravelingSystem.Persistent.Models.Travel" %>
<%@ page import="java.util.List" %><%--
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
            <form method="post" action="ShowTickets">
                <button type="submit" class="btn btn-block">مشاهده بلیط</button>
            </form>
        </div>

        <div class="clearfix"></div>

    </div>

</div>

<div class="container">

    <div class="col-md-12 col-sm-6">
        <div class="search-form">
            <form method="post" action="Search">
                <div class="form-group row flex-row-reverse">

                    <label>مبدا : </label>
                    <input name="source" type="text" class="form-control"/>


                    <label>مقصد :</label>
                    <input name="destination" type="text" class="form-control"/>


                    <label>تاریخ :</label>
                    <input name="date" type="text" class="form-control"/>


                    ‌<button type="submit" class="btn btn-info">Search</button>

                </div>


            </form>
        </div>

    </div>

    <div class="clearfix"></div>

    <% if(request.getAttribute("listTravels")!=null){%>

    <table class="table-striped">
        <%
            List<Travel> travels = (List<Travel>) request.getAttribute("listTravels");

            %>
        <thead>
        <tr>
            <th colspan="2" scope="col" class="text-right">
                مسیر :
                <%=request.getParameter("source")%>
                -
                <%=request.getParameter("destination")%>
            </th>

            <th scope="col" class="text-left">
                تاریخ حرکت :
                <%=request.getParameter("date")%>

            </th>

        </tr>

        </thead>
        <tbody>
        <tr>
            <th>انتخاب</th>
            <th>ساعت</th>
            <th>شناسه سفر</th>
        </tr>
        </tbody><%

            for (Travel travel : travels) {%>

        <tbody>
        <tr>
            <td>
                <form action="Confirm" method="post">
                    <button class="btn btn-info">خرید</button>
<%--                    <%--%>
<%--                        request.getSession().setAttribute("tid",travel.getId());--%>
<%--                    %>--%>
                    <input type="hidden" value="<%=travel.getId()%>" name="tid" />
                </form>
            </td>

            <td><%=travel.getHour()%></td>

            <td><%=travel.getId()%></td>
        </tr>
        </tbody>


        <%
            }
        %>

    </table>
    <%
        }



    %>


</div>

<jsp:include page="masterFooter.jsp"></jsp:include>




<script type="javascript" src="resources/js/jquery-3.4.1.slim.min.js"></script>
<script type="javascript" src="resources/js/popper.min.js"></script>
<script type="javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>
