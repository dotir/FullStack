package POO.Encapsulamiento.figurasgeometricas.modelos;

public class Circulo {
    
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public Circulo() {
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double Area() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double Perimetro() {
        return 2 * Math.PI * radio;
    }

    public void ImprimirArea() {
        System.out.println("El area del circulo es: " + Area());
    }

    public void ImprimirPerimetro() {
        System.out.println("El perimetro del circulo es: " + Perimetro());
    }
}
