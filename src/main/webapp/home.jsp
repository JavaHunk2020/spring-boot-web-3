<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<header style="height: 30px;background-color: yellow"></header>

<div class="container">

<img alt="" src="data:image/png;base64,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">
<hr/>
 <h2 style="color:red;font-weight: bold;">${message}!!!!!!!</h2>
 
 <a href="auth">
 <button type="button" class="btn btn-danger">Login</button>
 </a>
 &nbsp;&nbsp;
 <a href="auth">
 <button type="button" class="btn btn-warning">Logout</button>
 </a> 
  &nbsp;&nbsp;
 <a href="signup">
<button type="button" class="btn btn-success">Signup</button>
</a>

<hr/>
<h3 style="background-color: yellow;">SignUp List:</h3>            
  <table class="table table-bordered">
    <thead style="background-color: pink;">
      <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Record Date</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${signups}">
      <tr>
        <td>${item.username}</td>
        <td>${item.password}</td>
        <td>${item.email}</td>
        <td>${item.gender}</td>
        <td>${item.timestamp}</td>
        <td>
          <a href="deleteSignup?upname=${item.username}">
               <button type="button" class="btn btn-danger">Delete</button>
            </a>
             <a href="editSignup?upname=${item.username}">
               <button type="button" class="btn btn-primary">Edit</button>
            </a>
            
            
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
 
</div>



</body>
</html>