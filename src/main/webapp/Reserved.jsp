<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2020
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="masterHeaderMenu.jsp"></jsp:include>
<div class="col-md-12 align-self-md-center text-info text-center" style="direction: rtl;">
<% if (request.getSession().getAttribute("gender").equals("male")){
    String male = (String) request.getSession().getAttribute("gender");
    %>

    آقای<%}


    else if(request.getSession().getAttribute("gender").equals("female"))

    {
        String female = (String) request.getSession().getAttribute("gender");
%> خانوم <%

    }

%>

    <%=request.getSession().getAttribute("name") + " " + request.getSession().getAttribute("family")%>
    خرید بلیط شما با موفقیت انجام شد
<p class="text-info text-center" style="direction: rtl"> شناسه بلیط : <%=request.getSession().getAttribute("ticketId")%>  </p>
</div>

<jsp:include page="masterFooter.jsp"></jsp:include>

</body>
</html>
