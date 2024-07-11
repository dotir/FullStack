public class PracticandoArrays {
    
    public static void main(String[] args) {

        //1.SUMANDO ELEMENTOS DE UN ARRAY
        // //crear un array int
        // int[] numeros = {10, 20, 30};
        // //sumar los elementos del array
        // int suma = 0;
        // for (int i = 0; i < numeros.length; i++) {
        //     suma += numeros[i];
        // }
        // System.out.println("La suma de los elementos del array es: " + suma);

        //2. PROMEDIO DE ELEMENTOS DE UN ARRAY
        // //crear un array int
        // int[] numeros = {10, 20, 30, 40};
        // //sumar los elementos del array
        // int suma = 0;
        // for (int i = 0; i < numeros.length; i++) {
        //     suma += numeros[i];
        // }
        // //calcular el promedio
        // double promedio = suma / numeros.length;
        // System.out.println("El promedio de los elementos del array es: " + promedio);

        //3. ENCONTRAR EL MAYOR ELEMENTO DE UN ARRAY
        // //crear un array int
        // int[] numeros = {10, 20, 30, 40, 50};
        // //encontrar el mayor elemento del array
        // int mayor = numeros[0];
        // for (int i = 1; i < numeros.length; i++) {
        //     if (numeros[i] > mayor) {
        //         mayor = numeros[i];
        //     }
        // }
        // System.out.println("El mayor elemento del array es: " + mayor);

        //4. BUSCAR UN ELEMENTO EN UN ARRAY
        // //crear un array int
        // int[] numeros = {10, 20, 30};
        // //buscar un elemento en el array
        // System.out.println("Ingrese un número a buscar:");
        // int numero = Integer.parseInt(System.console().readLine());
        // boolean encontrado = false;
        // for (int i = 0; i < numeros.length; i++) {
        //     if (numeros[i] == numero) {
        //         encontrado = true;
        //         break;
        //     }
        // }
        // if (encontrado) {
        //     System.out.println("El número " + numero + " se encuentra en el array.");
        // } else {
        //     System.out.println("El número " + numero + " no se encuentra en el array.");
        // }

        //5. COPIAR ELEMENTOS DE UN ARRAY A OTRO ARRAY
        // //crear un array int
        // int[] numeros = {10, 20, 30};
        // //crear un array de la misma longitud
        // int[] copia = new int[5];
        // //copiar los elementos del array original al array copia
        // for (int i = 0; i < numeros.length; i++) {
        //     copia[i] = numeros[i];
        // }
        // //solicitar 2 numeros al usuario
        // System.out.println("Ingrese un número:");
        // copia[3] = Integer.parseInt(System.console().readLine());
        // System.out.println("Ingrese otro número:");
        // copia[4] = Integer.parseInt(System.console().readLine());
        // //mostrar los elementos del array copia
        // for (int i = 0; i < copia.length; i++) {
        //     System.out.println("Elemento " + (i+1) + ": " + copia[i]);
        // }

        //EJERCICIOS COMPLEMENTARIOS
        // //1. CONTAR ELEMENTOS PARES DE UN ARRAY
        // //crear un array int
        // int[] numeros = new int[6];
        // //llenar array con numeros aleatorios de 10 a 50
        // for (int i = 0; i < numeros.length; i++) {
        //     numeros[i] = (int)(Math.random() * 41) + 10;
        // }
        // //mostrar los elementos del array
        // for (int i = 0; i < numeros.length; i++) {
        //     System.out.println("Elemento " + (i+1) + ": " + numeros[i]);
        // }
        // //contar los elementos pares del array
        // int pares = 0;
        // for (int i = 0; i < numeros.length; i++) {
        //     if (numeros[i] % 2 == 0) {
        //         pares++;
        //     }
        // }
        // System.out.println("El array tiene " + pares + " elementos pares.");

        //2. SUMAR ELEMENTOS EN POSICIONES PARES DE UN ARRAY
        // //crear un array int
        // int[] numeros = new int[5];
        // //llenar array con numeros aleatorios de 10 a 50
        // for (int i = 0; i < numeros.length; i++) {
        //     numeros[i] = (int)(Math.random() * 41) + 10;
        // }
        // //mostrar los elementos del array
        // for (int i = 0; i < numeros.length; i++) {
        //     System.out.println("Elemento " + (i+1) + ": " + numeros[i]);
        // }
        // //sumar los elementos en posiciones pares del array
        // int suma = 0;
        // for (int i = 0; i < numeros.length; i++) {
        //     if (i % 2 == 0) {
        //         suma += numeros[i];
        //     }
        // }
        // System.out.println("La suma de los elementos en posiciones pares del array es: " + suma);

        //3. ORDENAR NOMBRES ALFABETICAMENTE EN UN ARRAY
        //crear un array de strings
        String[] nombres = new String[4];
        //llenar array con nombres
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Ingrese un nombre:");
            nombres[i] = System.console().readLine();
        }
        //ordenar los nombres alfabeticamente
        for (int i = 0; i < nombres.length - 1; i++) {
            for (int j = i + 1; j < nombres.length; j++) {
                if (nombres[i].compareTo(nombres[j]) > 0) {
                    String temp = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = temp;
                }
            }
        }
        //mostrar los nombres ordenados
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Nombre " + (i+1) + ": " + nombres[i]);
        }

    }
}
