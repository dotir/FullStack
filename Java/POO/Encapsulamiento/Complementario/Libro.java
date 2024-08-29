package POO.Encapsulamiento.Complementario;

public class Libro {
    private String titulo;
    private String autor;
    private int paginas;

    // Constructor
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters y Setters para título y autor
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Método para establecer el número de páginas
    public void setPaginas(int numeroIngresadoPorUsuario) {
        this.paginas = numeroIngresadoPorUsuario * 7;
    }

    // Método para imprimir detalles del libro
    public void imprimirDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + paginas);
    }
}
