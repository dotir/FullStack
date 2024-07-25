package ActividadIntegradora4;

public class Desafio2 {
    
    public static void main(String[] args) {
        
        //numeros Primos
        //numerosPrimos();
        //dibujando cuadrados
        // dibujarCuadrados();
        //grafica de barras
        graficaBarras();
    }

    public static void numerosPrimos(){
        System.out.print("Ingrese un numero: ");
        int numero = Integer.parseInt(System.console().readLine());
        int contador = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                contador++;
            }
        }
        if (contador == 2) {
            System.out.println("El numero " + numero + " es primo");
        } else {
            System.out.println("El numero " + numero + " no es primo");
        }
    }

    public static void dibujarCuadrados(){
        System.out.print("Ingrese un numero: ");
        int numero = Integer.parseInt(System.console().readLine());
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                if (i == 0 || i == numero - 1) {
                    System.out.print("*");
                } 
                else {
                    if (j == 0 || j == numero - 1) {
                        System.out.print("*");
                    } 
                    else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void graficaBarras(){
        System.out.print("Ingrese un numero (1-20): ");
        int numero = Integer.parseInt(System.console().readLine());
        System.out.print("Ingrese un segundo numero (1-20): ");
        int numero2 = Integer.parseInt(System.console().readLine());
        System.out.print("Ingrese un tercer numero (1-20): ");
        int numero3 = Integer.parseInt(System.console().readLine());
        System.out.print("Ingrese un cuarto numero (1-20): ");
        int numero4 = Integer.parseInt(System.console().readLine());
        //mostrar grafica
        System.out.print(numero);
        for (int i = 0; i < numero; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print(numero2);
        for (int i = 0; i < numero2; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print(numero3);
        for (int i = 0; i < numero3; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print(numero4);
        for (int i = 0; i < numero4; i++) {
            System.out.print("*");
        }


    }
}
