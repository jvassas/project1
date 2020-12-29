<%@ include file="employeeHeader.jsp"%>

<h1 class="m-3">Reimbursement Requests</h1>

<form action="EmployeeRequestServlet" method="POST" class="col-md-6 col-sm-8 m-3">
<h3>Submit a New Request</h3>
<br/>
  <div class="form-group">
      <label for="exampleFormControlInput1">Request Amount</label>
      <input type="text" class="form-control" id="amount" name="amount" placeholder="100">
   </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Description</label>
    <textarea class="form-control" id="description" name="description" rows="3"></textarea>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<br/>
<h1 class="m-3">Employee Requests</h1>
<br/>

<div class="container col-lg-10 col-md-10 col-sm-8 m-3">
    <div class="row">
        <div class="table-responsive">
            <h3>Request History</h3>
            <br/>
            <table class="table table-bordered table-striped" id="empRequestsTable">
                <tr>
                    <th>Request ID</th>
                    <th>Employee ID</th>
                    <th>Employee Email</th>
                    <th>Description</th>
                    <th>Amount</th>
                    <th>Approved</th>
                </tr>
            </table>
        </div>
    </div>
</div>












<br/>

<h3 class="m-3">Pending Requests</h3>
<br/>



<script src="resources/scripts/getEmpRequests.js"></script>



