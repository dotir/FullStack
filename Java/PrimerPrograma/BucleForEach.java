public class BucleForEach {
    
    public static void main(String[] args) {
        
        //1. Contando Elementos Pares usando ForEach
        int[] numeros = {10, 20, 30, 40, 50};
        int contador = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                contador++;
            }
        }
        System.out.println("La cantidad de números pares es: " + contador);

        //2. Calculando el promedio array de 20 elementos
        float[] numeros2 = new float[20];
        //inicializar el array
        for (int i = 0; i < numeros2.length; i++) {
            numeros2[i] = i + 1;
        }
        //calcular la suma y el promedio
        float suma = 0;
        for (float numero : numeros2) {
            suma += numero;
        }
        float promedio = suma / numeros2.length;
        System.out.println("El promedio de los elementos del array es: " + promedio);

        //3. Concatenando elementos
        String[] palabras = {"Hola", "Mundo", "Java"};
        String concatenado = "";
        for (String palabra : palabras) {
            concatenado += palabra + " ";
        }
        System.out.println("El texto concatenado es: " + concatenado);

        // Ejercicio Complementario
        //1. Contar ocurrencias
        char[] letras = new char[50];
        //colocar la palabra "aprendiendo java" en letras en el array
        String palabra = "aprendiendo java";
        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = palabra.charAt(i);
        }
        //solicitar una letra y mostrar la cantidad de ocurrencias
        System.out.println("Ingrese una letra:");
        char letra = System.console().readLine().charAt(0);
        int ocurrencias = 0;
        for (char l : letras) {
            if (l == letra) {
                ocurrencias++;
            }
        }
        System.out.println("La letra " + letra + " aparece " + ocurrencias + " veces en la palabra.");
        

    }
}
