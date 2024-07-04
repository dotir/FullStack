public class ManejoErrores {

    public static void main(String[] args) {
        
        // ingrese dos números enteros y realice la división del primer número entre el segundo número. Implementa un bloque "try-catch"
        System.out.println("Ingrese dos números enteros: ");
        System.out.println("Ingrese el primer número: ");
        int num1 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese el segundo número: ");
        int num2 = Integer.parseInt(System.console().readLine());
        try {
            System.out.println("El resultado de la división es: " + num1/num2);
        } catch (ArithmeticException e) {
            System.out.println("Error no es posible dividir por cero");
        }

        //Implementa un bloque "try-catch" para manejar las excepciones que puedan surgir en caso de que el usuario no ingrese números
        try {
            System.out.println("Ingrese dos números enteros: ");
            System.out.println("Ingrese el primer número: ");
            int num3 = Integer.parseInt(System.console().readLine());
            System.out.println("Ingrese el segundo número: ");
            int num4 = Integer.parseInt(System.console().readLine());
            System.out.println("El resultado de la resta es: " + (num3 - num4));
        } catch (NumberFormatException e) {
            System.out.println("Error, no ingresó un número");
        }

        // Escribe un programa que solicite al usuario ingresar una cadena de caracteres que represente un número entero. Utiliza el método Integer.parseInt() para convertir la cadena en un número entero. Implementa un bloque "try-catch" para manejar la excepción en caso de que la cadena ingresada no pueda ser convertida en un número entero.
        try {
            System.out.println("Ingrese una cadena de caracteres que represente un número entero: ");
            String cadena = System.console().readLine();
            int num5 = Integer.parseInt(cadena);
            System.out.println("El número ingresado es: " + num5);
        } catch (NumberFormatException e) {
            System.out.println("Error, la cadena ingresada no es un número entero");
        }
    }


    
}
