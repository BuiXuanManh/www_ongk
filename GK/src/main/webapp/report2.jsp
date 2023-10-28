<%@ page import="fit.se.gk.backend.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: bmanh
  Date: 10/28/2023
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container justify-content-center">
        <%
            List<Candidate> l= (List<Candidate>) request.getAttribute("canList");
            if(l!=null){
        %>
        <table class="table table-striped table-border table-hover mt-2">
            <thead>
            <tr>
                <th>Email</th>
                <th>Phone</th>
                <th>Full Name</th>
                <th>action</th>
            </tr>
            </thead>
            <tbody>
            <tr<%for(Candidate c:l){%>>
                <td><%=c.getEmail()%></td>
                <td><%=c.getPhone()%></td>
                <td><%=c.getFullName()%></td>
                <td><a href=<%="controller?action=view&&id="+c.getId()%>>View</a></td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%}%>
    </div>
</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>
