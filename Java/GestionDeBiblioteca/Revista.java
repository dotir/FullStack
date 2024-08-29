package GestionDeBiblioteca;

public class Revista extends ItemBiblioteca implements Catalogable {
    private int nroEdicion;
    private int cantidadEjemplares;
    private String nombreRevista;

    public Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista) {
        this.nroEdicion = nroEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.nombreRevista = nombreRevista;
    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    @Override
    public void prestar() {
        if (cantidadEjemplares > 0) {
            cantidadEjemplares--;
            System.out.println("Revista prestada: " + nombreRevista);
        } else {
            System.out.println("No hay ejemplares disponibles para prestar.");
        }
    }

    @Override
    public void devolver() {
        cantidadEjemplares++;
        System.out.println("Revista devuelta: " + nombreRevista);
    }

    @Override
    public void calcularMultas() {
        System.out.println("No hay multas para revistas.");
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Nombre de la Revista: " + nombreRevista);
        System.out.println("Número de Edición: " + nroEdicion);
        System.out.println("Cantidad de Ejemplares: " + cantidadEjemplares);
    }
}
