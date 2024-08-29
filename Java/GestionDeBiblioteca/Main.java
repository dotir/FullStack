package GestionDeBiblioteca;

public class Main {
    public static void main(String[] args) {
        Revista[] revistas = new Revista[3];
        revistas[0] = new Revista(1, 5, "Revista A");
        revistas[1] = new Revista(2, 3, "Revista B");
        revistas[2] = new Revista(3, 0, "Revista C");

        for (Revista revista : revistas) {
            revista.obtenerInformacion();
            revista.prestar();
            revista.devolver();
            revista.calcularMultas();
            System.out.println();
        }
    }
}
