<%@ include file="managerHeader.jsp"%>


<br/>
<div class="container col-lg-10 col-md-10 col-sm-8 m-3">
    <div class="row">
        <div class="table-responsive">
            <h3>All Reimbursement Requests</h3>
            <br/>
            <table class="table table-bordered table-striped" id="allRequestsTable">
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

<div class="container col-lg-10 col-md-10 col-sm-8 m-3">
    <div class="row">
        <div class="table-responsive">
            <h3>Pending Reimbursement Requests</h3>
            <br/>
            <table class="table table-bordered table-striped" id="pendingRequestsTable">
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
<div class="container col-lg-10 col-md-10 col-sm-8 m-3">
    <div class="row">
        <div class="table-responsive">
            <h3>Resolved Reimbursement Requests</h3>
            <br/>
            <table class="table table-bordered table-striped" id="resolvedRequestsTable">
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




<script src = "resources/scripts/getAllRequests.js"></script>

