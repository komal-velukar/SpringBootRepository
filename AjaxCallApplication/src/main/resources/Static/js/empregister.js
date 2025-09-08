function registerEmp() {
    let emp = {
        empName: $("#empName").val(),
        empAddress: $("#empAddress").val(),
        email: $("#email").val(),
        salary: $("#salary").val(),
        phno: $("#phno").val(),
        department: $("#department").val(),
        doj: $("#doj").val(),
        password: $("#password").val()
    };

    $.ajax({
        url: "/empcontroller/saveEmp",
        type: "POST",
        data: JSON.stringify(emp),
        contentType: "application/json",
        success: function(response) {
            alert("Registration successful!");
            window.location.href = "index.html";
        },
        error: function(xhr) {
            alert("Registration failed: " + xhr.responseText);
        }
    });
}