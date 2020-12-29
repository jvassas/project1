
const getEmployees = async () => {
    const employees = await fetch("//localhost:8080/Project_1/all-employees");
    res = await employees.json();
    console.log(res);

    var employee_data = '';

    $.each(res, function(key, value) {
        employee_data += '<tr>';
        employee_data += '<td>'+value.id+'</td>';
        employee_data += '<td>'+value.firstName+'</td>';
        employee_data += '<td>'+value.lastName+'</td>';
        employee_data += '<td>'+value.email+'</td>';
        employee_data += '</tr>';

    });

    $('#empTable').append(employee_data);
}

getEmployees();
