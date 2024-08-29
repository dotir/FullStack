package POO.Encapsulamiento.figurasgeometricas.modelos;

public class Rectangulo {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public Rectangulo() {
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double Area() {
        return ancho * alto;
    }

    public double Perimetro() {
        return 2 * (ancho + alto);
    }

    public void ImprimirArea() {
        System.out.println("El area del rectangulo es: " + Area());
    }

    public void ImprimirPerimetro() {
        System.out.println("El perimetro del rectangulo es: " + Perimetro());
    }
}
