public class BucleFor1 {
    
    public static void main(String[] args) {
        
        //1.  Imprimiendo elementos
        int[] numeros = {10, 20, 30, 40, 50};
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        //2. Encontrando el valor mínimo
        int[] numeros2 = {50, 40, 30, 20, 10};
        int min = numeros2[0];
        for (int i = 1; i < numeros2.length; i++) {
            if (numeros2[i] < min) {
                min = numeros2[i];
            }
        }
        System.out.println("El valor mínimo del array es: " + min);

        //3.Imprimiendo elementos en orden inverso
        int[] numeros3 = {10, 20, 30, 40, 50};
        for (int i = numeros3.length - 1; i >= 0; i--) {
            System.out.println(numeros3[i]);
        }

        //Ejercicios Complementarios
        //1. Invertir un array
        int[] numeros4 = {10, 20, 30, 40, 50};
        int[] invertido = new int[numeros4.length];
        for (int i = 0; i < numeros4.length; i++) {
            invertido[i] = numeros4[numeros4.length - 1 - i];
        }
        for (int i = 0; i < invertido.length; i++) {
            System.out.println(invertido[i]);
        }

        //2. Calcular suma acumulada
        int[] numeros5 = {10, 20, 30, 40, 50};
        int[] sumaAcumulada = new int[numeros5.length];
        int suma = 0;
        for (int i = 0; i < numeros5.length; i++) {
            suma += numeros5[i];
            sumaAcumulada[i] = suma;
        }
        for (int i = 0; i < sumaAcumulada.length; i++) {
            System.out.println(sumaAcumulada[i]);
        }

    }
}
