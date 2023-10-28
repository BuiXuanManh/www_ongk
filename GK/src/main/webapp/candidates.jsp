<%@ page import="java.util.List" %>
<%@ page import="fit.se.gk.backend.models.Candidate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <%
    List<Candidate> l= (List<Candidate>) request.getAttribute("canList");
  %>
</head>
<body>
  <div class="container justify-content-center">
    <h1>List Candidate</h1>
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
  </div>
</body>
</html>
