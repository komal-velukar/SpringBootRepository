function login() {
    var req = {
        "url": "/userLogin",
        "method": "POST",
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        "data": {
            "username": $('#username').val(),
            "password": $('#password').val()
        }
    };
    $.ajax(req).done(function (res) {
        if (res === "success") {
            window.location.href = "empdashboard.html";
        } else {
            alert("Login failed");
        }
    });
}