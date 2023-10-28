<%@ page import="java.util.List" %>
<%@ page import="fit.se.gk.backend.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: bmanh
  Date: 10/28/2023
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
  <div class="container justify-content-center">
    <form action="controller?action=role" method="post">
      <div class="form-group">
        <label>Search</label>
        <select class="form-control mb-2" name="select">
          <option value="ADMINSTRATION">ADMINSTRATION</option>
          <option value="STAFF">STAFF</option>
          <option value="MANAGER">MANAGER</option>
          <option value="EXECUTIVE">EXECUTIVE</option>
        </select>
        <button class="btn btn-primary mt-2" type="submit" > Find</button>
      </div>
    </form>
    <%
      List<Candidate> l= (List<Candidate>) request.getAttribute("canList");
      if(l!=null){
    %>
    <table class="table table-striped table-border table-hover">
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
