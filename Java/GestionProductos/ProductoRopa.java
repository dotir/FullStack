package GestionProductos;

public class ProductoRopa extends Producto {
    private String talla;
    private String color;
    private String material;

    public ProductoRopa() {
    }

    public ProductoRopa(String nombre, double precio, int cantidad, String descripcion, String talla, String color, String material) {
        super(nombre, precio, cantidad, descripcion);
        this.talla = talla;
        this.color = color;
        this.material = material;
    }

    public String getTalla() {
        return talla;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
}
