package Metodos2;

public class NumerosAleatorios {
    
    public static int numeroAleatorio() {
        return (int) (Math.random() * 355) + 1;
    }

    public static void main(String[] args) {
        int numero = numeroAleatorio();
        System.out.println("Número aleatorio generado: " + numero);
    }
}
