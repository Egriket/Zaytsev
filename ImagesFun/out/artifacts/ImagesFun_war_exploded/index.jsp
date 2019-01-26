<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 18.01.19
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    request.getServletContext().getRequestDispatcher("/ServletImage").forward(request, response);
  %>
  </body>
</html>
