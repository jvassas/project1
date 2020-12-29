<%@ include file="managerHeader.jsp"%>

<style>
table {
border: .5px solid black;

}

th {
text-align:center;
padding: 8px;
}

td {
text-align:center;
padding: 8px;
}

</style>


<h1 class="m-2">Employees</h1>

<br/>
<div class="container col-md-6 col-sm-8 m-2">
    <div class="table-responsive">
        <h3>Employee Roster</h3>
        <br/>
        <table class="table table-bordered table-striped" id="empTable">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
        </table>
    <div>
</div>


<br/>


<form action="RegisterEmployeeServlet" method="POST" class="col-lg-7 col-md-8 col-sm-9 m-2">
<h3>Register a New Employee</h3>
<br/>
  <div class="form-group">
      <label for="exampleFormControlInput1">Email</label>
      <input type="email" class="form-control" id="email" name="email" placeholder="email@mail.com">
   </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">First Name</label>
    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
  </div>
  <div class="form-group">
      <label for="exampleFormControlInput1">Last Name</label>
      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
   </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="password"></textarea>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<script src = "resources/scripts/getEmployees.js"></script>