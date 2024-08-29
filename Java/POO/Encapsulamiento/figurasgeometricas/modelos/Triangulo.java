package POO.Encapsulamiento.figurasgeometricas.modelos;

public class Triangulo {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo() {
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double Area() {
        return (base * altura) / 2;
    }

    public double Perimetro() {
        return base * 3;
    }

    public void ImprimirArea() {
        System.out.println("El area del triangulo es: " + Area());
    }

    public void ImprimirPerimetro() {
        System.out.println("El perimetro del triangulo es: " + Perimetro());
    }
}