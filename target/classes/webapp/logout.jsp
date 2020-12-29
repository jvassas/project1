<!DOCTYPE html>
<html>
<head>
  <title>Employee Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="resources/styles/custom.css">
</head>
<body>
    <%
        session.removeAttribute("email");
        session.removeAttribute("password");
        session.invalidate();
    %>

    <h2 class="text-center m-5">You have successfully logged out</h2>
   <h4 class="text-center">To log in again, <a href="index.jsp"> click here</a></h4>





</body>
</html>