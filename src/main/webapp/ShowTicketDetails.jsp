<%@ page import="main.com.team3d.busTravelingSystem.Persistent.Models.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2020
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/Style.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <title>ticket details</title>
</head>
<body>
<jsp:include page="masterHeaderMenu.jsp"></jsp:include>
<%Ticket ticket = null;%>
<%if (request.getSession().getAttribute("tDetailsID")!=null){
     ticket = (Ticket) request.getSession().getAttribute("tDetailsID");%>

            <table class="table-striped">
                <tr>
                    <td>شناسه بلیط</td>
                    <td><%=ticket.getId()%></td>
                </tr>
                <tr>
                    <td>نام</td>
                    <td><%=ticket.getUser().getLastName() + " " + ticket.getUser().getFirstName()%></td>
                </tr>

                <tr>
                    <td>جنسیت</td>
                    <td><%=ticket.getSex()%></td>
                </tr>

                <tr>
                    <td>مبدا</td>
                    <td><%=ticket.getTravel().getSource()%></td>
                </tr>
                <tr>
                    <td>مقصد</td>
                    <td><%=ticket.getTravel().getDestination()%></td>
                </tr>
                <tr>
                    <td>تاریخ حرکت</td>
                    <td><%=ticket.getTravel().getPersianDate()%></td>
                </tr>
                <tr>
                    <td>ساعت حرکت</td>
                    <td><%=ticket.getTravel().getHour()%></td>
                </tr>

                <tr>
                    <td>شناسه سفر</td>
                    <td><%=ticket.getTravel().getId()%></td>
                </tr>

            </table>


            <form method="post" action="DeleteTicket">
                <button class="btn btn-info">لغو بلیط</button>
            </form>


<%};%>


<jsp:include page="masterFooter.jsp"></jsp:include>

</body>
</html>
