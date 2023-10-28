<%@ page import="fit.se.gk.backend.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="fit.se.gk.backend.models.Experience" %>
<html>
<head>
    <title>Candidate Details</title>
    <%
        Candidate c = (Candidate) request.getAttribute("candidate");
        List<Experience> l = (List<Experience>) request.getAttribute("listExpr");
    %>
</head>
<body>
<div class="container">
    <%--    <table class="table table-striped table-border table-hover">--%>
    <%--        <thead>--%>
    <%--        <tr>--%>
    <%--            <th>Email</th>--%>
    <%--            <th>Phone</th>--%>
    <%--            <th>Full Name</th>--%>
    <%--            <th>Expr</th>--%>
    <%--            <th>Company Name</th>--%>
    <%--            <th>Work Description</th>--%>
    <%--            <th>From Date</th>--%>
    <%--            <th>To Date</th>--%>
    <%--            <th>Role</th>--%>
    <%--        </tr>--%>
    <%--        </thead>--%>
    <%--        <tbody>--%>
    <%--        <tr<%for(Experience e:l){%>>--%>
    <%--            <td><%=c.getEmail()%></td>--%>
    <%--            <td><%=c.getPhone()%></td>--%>
    <%--            <td><%=c.getFullName()%></td>--%>
    <%--            <td><%=e.getCompanyName()%></td>--%>
    <%--            <td><%=e.getWorkDescription()%></td>--%>
    <%--            <td><%=e.getFromDate()%></td>--%>
    <%--            <td><%=e.getToDate()%></td>--%>
    <%--            <td><%=e.getRole()%></td>--%>
    <%--        </tr>--%>
    <%--        <%}%>--%>
    <%--        </tbody>--%>
    <%--    </table>--%>
    <div class="row">
        <div class="col-md-3">
            <h2>Candidate:</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <label>Email:</label>
        </div>
        <div class="col-md-3">
            <label><%=c.getEmail()%>
            </label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <label>Phone:</label>
        </div>
        <div class="col-md-3">
            <label><%=c.getPhone()%>
            </label>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3">
            <label>Full Name:</label>
        </div>
        <div class="col-md-3">
            <label><%=c.getFullName()%>
            </label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <h2>Experience:</h2>
        </div>
    </div>
    <%
        int i = 0;
        for (Experience e : l) {
            i++;%>
    <div class="row mt-2">
        <div class="col-md-3">
            <label><%="Experience" + i + ":"%>
            </label>
        </div>
        <div class="col-md-3">
            <label><%=e.getCompanyName()%>
            </label>
        </div>
        <div class="col-md-3">
            <label><%=e.getWorkDescription()%>
            </label>
        </div>
        <div class="col-md-3">
            <label><%=e.getFromDate()%>
            </label>
        </div>
        <div class="col-md-3">
            <label><%=e.getToDate()%>
            </label>
        </div>
        <div class="col-md-3">
            <label><%=e.getRole()%>
            </label>
        </div>
    </div>
    <%}%>
</div>
</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>
