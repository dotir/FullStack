package entidades;

public class DetallePedido {
    private int idDetallePedido;
    private int idPedido;
    private int idProducto;
    private int cantidad;
    private double precioUnidad;
    private int numeroLinea;

    // Constructor completo
    public DetallePedido(int idDetallePedido, int idPedido, int idProducto, int cantidad, double precioUnidad, int numeroLinea) {
        this.idDetallePedido = idDetallePedido;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.numeroLinea = numeroLinea;
    }

    // Constructor sin idDetallePedido
    public DetallePedido(int idPedido, int idProducto, int cantidad, double precioUnidad, int numeroLinea) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.numeroLinea = numeroLinea;
    }

    // Constructor vacío
    public DetallePedido() {
    }

    // Getters y Setters
    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "idDetallePedido=" + idDetallePedido +
                ", idPedido=" + idPedido +
                ", idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                ", precioUnidad=" + precioUnidad +
                ", numeroLinea=" + numeroLinea +
                '}';
    }
}
