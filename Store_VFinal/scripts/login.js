document.querySelector('.show-password').addEventListener('click', function() {
    var passwordInput = document.getElementById('password');
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        this.textContent = "Ocultar";
    } else {
        passwordInput.type = "password";
        this.textContent = "Mostrar";
    }
});