package POO.Encapsulamiento.Complementario;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Lista para almacenar las instancias de Libro
        List<Libro> libros = new ArrayList<>();

        // Crear instancias de Libro
        Libro libro1 = new Libro("El Gran Gatsby", "F. Scott Fitzgerald");
        libro1.setPaginas(20); // 20 * 7 = 140 páginas
        libros.add(libro1);

        Libro libro2 = new Libro("1984", "George Orwell");
        libro2.setPaginas(30); // 30 * 7 = 210 páginas
        libros.add(libro2);

        // Imprimir detalles de un libro
        libro1.imprimirDetalles();

        // Imprimir todos los libros disponibles (solo su título)
        imprimirTodosLosLibros(libros);
    }

    // Método estático para imprimir todos los libros disponibles (solo su título)
    public static void imprimirTodosLosLibros(List<Libro> libros) {
        System.out.println("Libros disponibles:");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo());
        }
    }
}
