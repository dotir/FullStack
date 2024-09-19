package Excepciones;

import java.util.Scanner;

public class saludoUsuario {
    public static void main(String[] args) {
        try {
            solicitarnombre();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void solicitarnombre() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            System.out.println(nombre.length());
            if(nombre.length()<2){
                throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres");
            }else{
                System.out.println("Hola " + nombre);
            }
        }finally{
            scanner.close();
        }
    }
}
