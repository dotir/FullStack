// validar si es mayor de edad por la edad
function validarEdad() {
    var edad = document.getElementById("edad").value;
    if (edad < 18) {
        //cree un mensaje arriba del input tipo spam
        document.getElementById("mensaje").innerHTML = "Eres menor de edad";
        //alert("Eres menor de edad");
        //limpie los inputs
        document.getElementById("edad").value = "";
        document.getElementById("nombre").value = "";
        return false;
    }
    return true;
}

//cuando detecte cambios en el input de la edad, se ejecuta la funcion validarEdad
document.getElementById("edad").addEventListener("change", validarEdad);