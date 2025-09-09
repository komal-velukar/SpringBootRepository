function register() {
    var req = {
        "url": "/registerUser",
        "method": "POST",
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        "data": {
            "username": $('#reguser').val(),
            "password": $('#regpass').val()
        }
    };
    $.ajax(req).done(function (res) {
        alert(res);
    });
}