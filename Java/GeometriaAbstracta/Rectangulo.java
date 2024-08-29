package GeometriaAbstracta;

public class Rectangulo extends Figura implements Dibujable{
    
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
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
        return "Rectangulo: Base = " + base + ", Altura = " + altura;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo con base " + base + " y altura " + altura);
    }
    
}
