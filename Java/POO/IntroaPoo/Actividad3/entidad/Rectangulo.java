package POO.IntroaPoo.Actividad3.entidad;

public class Rectangulo {

    //atributos ancho y alto numeros decimales
    private double ancho;
    private double alto;
    static private int contadorRectangulos;

    //constructor con parametros ancho y alto
    public Rectangulo(double ancho, double alto){
        this.ancho = ancho;
        this.alto = alto;
        contadorRectangulos++;
    }

    //metodo calcular area
    public double Area(){
        return ancho * alto;
    }

    //metodo calcular perimetro
    public double Perimetro(){
        return 2 * (ancho + alto);
    }

    //metodo imprimir Area
    public void ImprimirArea(){
        System.out.println("El area del rectangulo es: " + Area());
    }

    //metodo imprimir Perimetro
    public void ImprimirPerimetro(){
        System.out.println("El perimetro del rectangulo es: " + Perimetro());
    }

    //metodo imprimir contador de rectangulos
    public static void ImprimirContador(){
        System.out.println("El numero de rectangulos creados es: " + contadorRectangulos);
    }    
}
