package Metodos2;

import java.util.Scanner;

public class ValidacionContrasena {
    public static boolean tieneLongitudCorrecta(String contraseña) {
        return contraseña.length() >= 8;
    }

    public static boolean tieneMayuscula(String contraseña) {
        return !contraseña.equals(contraseña.toLowerCase());
    }

    public static boolean tieneMinuscula(String contraseña) {
        return !contraseña.equals(contraseña.toUpperCase());
    }

    public static boolean tieneNumero(String contraseña) {
        return contraseña.matches(".*\\d.*");
    }

    public static boolean tieneCaracterEspecial(String contraseña) {
        return contraseña.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    public static boolean esSegura(String contraseña) {
        return tieneLongitudCorrecta(contraseña) &&
               tieneMayuscula(contraseña) &&
               tieneMinuscula(contraseña) &&
               tieneNumero(contraseña) &&
               tieneCaracterEspecial(contraseña);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una contraseña: ");
        String contraseña = scanner.nextLine();

        if (esSegura(contraseña)) {
            System.out.println("La contraseña es segura.");
        } else {
            System.out.println("La contraseña no cumple con los criterios de seguridad.");
        }

        scanner.close();
    }
}
