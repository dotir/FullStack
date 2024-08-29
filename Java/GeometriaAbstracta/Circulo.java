package GeometriaAbstracta;

public class Circulo extends Figura implements Dibujable{

    private double radio;
    
    public Circulo(double radio){
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    public double getRadio(){
        return radio;
    }
    
    public void setRadio(double radio){
        this.radio = radio;
    }
    
    @Override
    public String toString(){
        return "Circulo: Radio = " + radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo con radio " + radio);
    }
    
}
