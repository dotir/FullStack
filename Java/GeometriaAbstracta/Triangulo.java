package GeometriaAbstracta;

public class Triangulo extends Figura implements Dibujable {
    
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 3 * base;
    }
    
    public double getBase(){
        return base;
    }
    
    public void setBase(double base){
        this.base = base;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    @Override
    public String toString(){
        return "Triangulo: Base = " + base + ", Altura = " + altura;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un triángulo con base " + base + " y altura " + altura);
    }
}
