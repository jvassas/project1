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
<style>


</style>
<style>

.form-container{

padding: 12px;
}

label {
padding-bottom: 7px;
}

button {
text-align:center;
}

</style>
</head>
<body>

<div class="form-container col-md-5 col-sm-8 m-4" id="form-container" >
    <h1 class="text-center">Employee Login</h1>
    <form method="post" action="EmployeeLoginServlet">
      <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email" name="email" required>

      </div>
      <div class="form-group">
        <label for="Password">Password</label>
        <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>


</body>
</html>