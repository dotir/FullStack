public class Desafio2 {
    public static void main(String[] args) {

        String password = "";
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        System.out.println("Ingresa una contraseña:");
        password = System.console().readLine();
        // contraseña debe tener al menos 8 caracteres
        if (password.length() >= 8) {
            // verificar que contraseña tenga al menos una letra mayúscula y una minúscula
            hasUppercase = !password.equals(password.toLowerCase());
            hasLowercase = !password.equals(password.toUpperCase());
            if (hasUppercase || hasLowercase) {
                // verificar que contraseña tenga al menos un número
                hasNumber = password.matches(".*\\d.*");
                if (hasNumber) {
                    // verificar que contraseña tenga al menos un caracter especial
                    hasSpecialChar = !password.matches("[A-Za-z0-9 ]*");
                    if (hasSpecialChar) {
                        System.out.println("¡Contraseña segura! Cumple con todos los criterios.");
                        return;
                    }else{
                        System.out.println("Error: Contraseña no válida. Debe tener al menos un caracter especial.");
                    }
                }else{
                    System.out.println("Error: Contraseña no válida. Debe tener al menos un número.");
                }
            }else{
                System.out.println("Error: Contraseña no válida. Debe tener al menos una letra mayúscula y una minúscula.");
            }
        }else{
            System.out.println("La contraseña debe tener al menos 8 caracteres.");
        }

    }
}
