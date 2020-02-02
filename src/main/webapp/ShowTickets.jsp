<%@ page import="main.com.team3d.busTravelingSystem.Persistent.Models.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2020
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/Style.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <title>my tickets</title>
</head>
<body>

<jsp:include page="masterHeaderMenu.jsp"></jsp:include>


<% if(request.getSession().getAttribute("tickets")!=null){%>

<table class="table-striped">
    <%
        List<Ticket> tickets = (List<Ticket>) request.getSession().getAttribute("tickets");

    %>
    <thead>
    <tr>
        <th>انتخاب</th>
        <th>شناسه بلیط</th>
        <th>تاریخ</th>
    </tr>

    </thead>
   <%

    for (Ticket ticket : tickets) {%>

    <tbody>
    <tr>
        <td>
            <a href="">انتخاب</a>
        </td>

        <td>
            <%=ticket.getId()%>
        </td>

        <td>

            <%=ticket.getTravel().getPersianDate()%>
        </td>
    </tr>
    </tbody>


    <%
        }
    %>

</table>
<%
    }



%>

<jsp:include page="masterFooter.jsp"></jsp:include>
<script type="javascript" src="resources/js/jquery-3.4.1.slim.min.js"></script>
<script type="javascript" src="resources/js/popper.min.js"></script>
<script type="javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>
