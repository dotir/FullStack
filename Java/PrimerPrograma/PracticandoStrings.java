public class PracticandoStrings {
    
    public static void main(String[] args) {
        //mostrar la longitud de una cadena de texto
        System.out.println("Ingrese una cadena de texto: ");
        String cadena = System.console().readLine();
        System.out.println("La longitud de la cadena es: " + cadena.length());

        //concatenar nombre y apellido
        System.out.println("Ingrese su nombre: ");
        String nombre = System.console().readLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = System.console().readLine();
        String nombrecompleto="";
        System.out.println("Su nombre completo es: " + nombrecompleto.concat(nombre).concat(" ").concat(apellido));

        //solicitar un texto y dos numeros enteros
        System.out.println("Ingrese un texto: ");
        String texto1 = System.console().readLine();
        System.out.println("Ingrese un número entero: ");
        int num1 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese otro número entero: ");
        int num2 = Integer.parseInt(System.console().readLine());
        System.out.println("Subcadena resultante: " + texto1.substring(num1, num2));

        //pedir un texto y un caracter
        System.out.println("Ingrese un texto: ");
        String texto2 = System.console().readLine();
        System.out.println("Ingrese un caracter: ");
        char caracter = System.console().readLine().charAt(0);
        //validar si esta o no esta el caracter
        if (texto2.indexOf(caracter) != -1) {
            System.out.println("El caracter " + caracter + " está en la cadena de texto");
        } else {
            System.out.println("El caracter " + caracter + " no está en la cadena de texto");
        }

        //convertir texto a mayusculas y minusculas
        System.out.println("Ingrese un texto: ");
        String texto3 = System.console().readLine();
        System.out.println("Texto en mayúsculas: " + texto3.toUpperCase());
        System.out.println("Texto en minúsculas: " + texto3.toLowerCase());

    }
}
