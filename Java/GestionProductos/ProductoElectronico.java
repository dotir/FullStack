package GestionProductos;

public class ProductoElectronico extends Producto {
    private String marca;
    private String modelo;
    private String color;

    public ProductoElectronico() {
    }

    public ProductoElectronico(String nombre, double precio, int cantidad, String descripcion, String marca, String modelo, String color) {
        super(nombre, precio, cantidad, descripcion);
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
