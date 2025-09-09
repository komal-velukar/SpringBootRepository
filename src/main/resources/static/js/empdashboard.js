function saveEmp(){
    var empname = document.getElementById('empname').value;
    var empaddress = $('#empaddr').val();
    var empsal = $('#empsal').val();
    var empphno = $('#empphno').val();
    var empemail = $('#empemail').val();
    var empdept = $('#empdept').val();
    var empdoj = $('#empdoj').val();

    var empsaverequest = {
        "url":"/empcontroller/saveEmp",
        "method":"POST",
        "headers":{"Content-Type":"application/json"},
        "data": JSON.stringify({
            "empName": empname,
            "empAddress": empaddress,
            "email": empemail,
            "salary": empsal,
            "phno": empphno,
            "department": empdept,
            "doj": empdoj
        })
    };

    $.ajax(empsaverequest).done(function (response) {
        alert(response);
        loadEmployees();
    });
}

function loadEmployees() {
    $.get("/empcontroller/getAll", function(data) {
        let rows = "";
        data.forEach(emp => {
            rows += `<tr>
                <td>${emp.id}</td>
                <td>${emp.empName}</td>
                <td>${emp.department}</td>
                <td>${emp.email}</td>
                <td><button disabled>Edit</button> <button disabled>Delete</button></td>
            </tr>`;
        });
        $("#empTable tbody").html(rows);
    });
}

$(document).ready(function () {
    loadEmployees();
});