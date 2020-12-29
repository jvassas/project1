const getAllRequests = async () => {
    const reimbursements = await fetch("//localhost:8080/Project_1/all-reimbursements");
    res = await reimbursements.json();
    console.log(res);

    var request_data = '';

    $.each(res, function(key, value) {
        request_data += '<tr>';
        request_data += '<td>'+value.expenseId+'</td>';
        request_data += '<td>'+value.employeeId+'</td>';
        request_data += '<td>'+value.employeeEmail+'</td>';
        request_data += '<td>'+value.description+'</td>';
        request_data += '<td>'+value.amount+'</td>';
        request_data += '<td>'+value.approved+'</td>';

        request_data += '</tr>';

    });

    $('#allRequestsTable').append(request_data);
}

getAllRequests();
