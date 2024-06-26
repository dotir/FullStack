public class MiPrimerPrograma {
    public static void main(String[] args) {
        saludar();
        tresVariables();
        datos();
    }

    public static void saludar() {
        System.out.println("Hola Mundo");
    }

    public static void tresVariables() {
        int a = 10;
        String b = "Hola";
        float c = 3.14f;
        System.out.println("El valor de a es: " + a);
        System.out.println("El valor de b es: " + b);
        System.out.println("El valor de c es: " + c);
    }

    public static void datos() {
        String nombre = "Irving";
        int edad = 28;
        System.out.println("Mi nombre es: " + nombre + " y tengo " + edad + " años");
    }
}