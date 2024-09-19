package Excepciones.AdivinarNumero;
import java.util.Scanner;

public class PalabraClave {
    private String clave;

    public void ingresarPalabraClave() {
        Scanner scanner = new Scanner(System.in);
        boolean claveValida = false;

        while (!claveValida) {
            System.out.print("Ingrese una palabra clave: ");
            clave = scanner.nextLine();

            try {
                validarLongitud(clave);
                validarNumeros(clave);
                validarLetraZ(clave);
                claveValida = true;
                System.out.println("La palabra clave es válida para ser utilizada.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    private void validarLongitud(String palabra) throws Exception {
        if (palabra.length() < 8) {
            throw new Exception("La palabra clave debe tener al menos 8 caracteres.");
        }
    }

    private void validarNumeros(String palabra) throws Exception {
        int contadorNumeros = 0;
        for (char c : palabra.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorNumeros++;
            }
        }
        if (contadorNumeros != 4) {
            throw new Exception("La palabra clave debe contener exactamente 4 números.");
        }
    }

    private void validarLetraZ(String palabra) throws Exception {
        if (!palabra.toLowerCase().contains("z")) {
            throw new Exception("La palabra clave debe contener la letra 'z'.");
        }
    }

    public static void main(String[] args) {
        PalabraClave palabraClave = new PalabraClave();
        palabraClave.ingresarPalabraClave();
    }
}