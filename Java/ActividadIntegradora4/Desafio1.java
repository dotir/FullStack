package ActividadIntegradora4;

public class Desafio1 {

    public static void main(String[] args) {
        //Calculo del factorial
        //calculoDelFactorial();
        //Serie Fibonacci
        fibonacciMejorada();
    }

    public static void calculoDelFactorial(){
        
        System.out.print("Ingrese un numero: ");
        int numero = Integer.parseInt(System.console().readLine());
        int factorial = 1;
        do{
            factorial = factorial * numero;
            numero--;
        }while(numero > 0);
        System.out.println("El factorial es: " + factorial);
    }

    public static void fibonacciMejorada(){
        System.out.print("Ingrese la posición en la serie de Fibonacci: ");
        int posicion = Integer.parseInt(System.console().readLine());
        int primerNumero = 0, segundoNumero = 1;
        int fibonacci = 0;
    
        if (posicion == 0) {
            fibonacci = primerNumero;
        } else if (posicion == 1) {
            fibonacci = segundoNumero;
        } else {
            for (int i = 2; i <= posicion; i++) {
                fibonacci = primerNumero + segundoNumero;
                primerNumero = segundoNumero;
                segundoNumero = fibonacci;
            }
        }
        System.out.println("Posicion " + posicion + ": " + fibonacci);
    }
}