package Metodos2;

public class ImprimirArrays {
    // Método para imprimir un array de tipo int
    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método para imprimir un array de tipo String
    public static void imprimirArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método para imprimir un array bidimensional de tipo int
    public static void imprimirArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    // Método para imprimir un array bidimensional de tipo String
    public static void imprimirArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3, 4, 5};
        String[] arrayString = {"Hola", "Mundo", "Java"};
        int[][] arrayBiInt = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[][] arrayBiString = {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}};

        System.out.println("Array de int:");
        imprimirArray(arrayInt);

        System.out.println("Array de String:");
        imprimirArray(arrayString);

        System.out.println("Array bidimensional de int:");
        imprimirArray(arrayBiInt);

        System.out.println("Array bidimensional de String:");
        imprimirArray(arrayBiString);
    }
}
