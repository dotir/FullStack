const edad = Number(prompt('¿Cuántos años tienes?'));

if (edad >= 18) {
  alert('Eres mayor de edad');
}else if(edad > 0) {
  alert('Eres menor de edad');
} else {
  alert('Introduce una edad válida');
}