

function login() {
    let email = $("#email").val();
    let password = $("#password").val();

    $.post("/empcontroller/login", { email: email, password: password }, function(data) {
        if (data) {
            localStorage.setItem("loggedInUser", JSON.stringify(data));
            window.location.href = "empdashboard.html";
        }
    }).fail(function() {
        alert("Invalid credentials!");
    });
}