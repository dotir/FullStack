
public class BucleWhile {
    public static void main(String[] args) {
        

        // //1. Menu de opciones
        // int opcion = 0;
        // while (opcion != 5) {
        //     System.out.println("Menú de opciones");
        //     System.out.println("1. Comprar producto.");
        //     System.out.println("2. Realizar devolución.");
        //     System.out.println("3. Ver mis pedidos.");
        //     System.out.println("4. Preguntas frecuentes");
        //     System.out.println("5. Salir");
        //     System.out.println("Seleccione una opción:");
        //     opcion = Integer.parseInt(System.console().readLine());

        //     switch (opcion) {
        //         case 1:
        //             System.out.println("Usted ha seleccionado la opción de comprar producto.");
        //             System.out.println("------------------------------------------------------");
        //             break;
        //         case 2:
        //             System.out.println("Usted ha seleccionado la opción de realizar devolución.");
        //             System.out.println("------------------------------------------------------");
        //             break;
        //         case 3:
        //             System.out.println("Usted ha seleccionado la opción de ver sus pedidos.");
        //             System.out.println("------------------------------------------------------");
        //             break;
        //         case 4:
        //             System.out.println("Usted ha seleccionado la opción de preguntas frecuentes.");
        //             System.out.println("------------------------------------------------------");
        //             break;
        //         case 5:
        //             System.out.println("Gracias por usar nuestro sistema.");
        //             break;
        //         default:
        //             System.out.println("Opción no válida.");
        //             break;
        //     }
        // }

        // //2. Adivinar un numero que es del 1 al 20 usando do while
        // int numero = (int) (Math.random() * 20) + 1;
        // int intentos = 0;
        // int numeroUsuario = 0;
        // do {
        //     System.out.println("Ingrese un número entre 1 y 20:");
        //     numeroUsuario = Integer.parseInt(System.console().readLine());
        //     intentos++;
        //     if (numeroUsuario < numero) {
        //         System.out.println("El número a adivinar es mayor.");
        //     } else if (numeroUsuario > numero) {
        //         System.out.println("El número a adivinar es menor.");
        //     }
        // } while (numero != numeroUsuario);
        // System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");


        // //3. Validacion de contraseña "secreto"
        // System.out.println("Ingrese la contraseña:");
        // String contrasena = System.console().readLine();
        // while (!contrasena.equals("secreto")) {
        //     System.out.println("Contraseña incorrecta. Intente nuevamente:");
        //     contrasena = System.console().readLine();
        // }

        // //4. Calcular numero de digitos de un numero
        // System.out.println("Ingrese un número entero:");
        // int numero = Integer.parseInt(System.console().readLine());
        // int digitos = 0;
        // while (numero != 0) {
        //     numero = numero / 10;
        //     digitos++;
        // }
        // System.out.println("El número tiene " + digitos + " dígitos.");

        //Ejercicios Complementarios
        //1. Tabla de multiplicar y cuando le ponga 0 finaliza
        int number;
        do {
           
            System.out.print("Ingrese un numero: ");
            number = Integer.parseInt(System.console().readLine());

            if (number != 0) {
                System.out.println("Tabla de multiplicar" + number + ":");
                int i = 1;
                while (i <= 12) {
                    System.out.println(number + " x " + i + " = " + (number * i));
                    i++;
                }
                System.out.println();
            }
        } while (number != 0);

    }
}
