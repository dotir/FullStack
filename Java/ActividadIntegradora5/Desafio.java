package ActividadIntegradora5;

public class Desafio {
    public static void main(String[] args) {
        manipulandoOraciones();
    }

    public static void manipulandoOraciones() {
        int e = 0;
        String oracion = "";
        String[] palabras;
        // menu de opciones
        do {
            System.out.println("-----------------------------");
            System.out.println("Menu de opciones");
            if (oracion.equals("")) {
                System.out.println("1. Crear oracion: ");
            } else {
                System.out.println("1. Borrar oracion");
            }
            System.out.println("2. Cantidad de caracteres: ");
            System.out.println("3. Cantidad de palabras: ");
            System.out.println("4. Mostrar palabras ordenadas: ");
            System.out.println("5. Mostrar un numero y devolver la palabra: ");
            System.out.println("6. Buscar palabra en la oracion: ");
            System.out.println("7. Modificar palabra: ");
            System.out.println("8. Agregar contenido a la oracion: ");
            System.out.println("9. Salir");
            System.out.println("-----------------------------");
            System.out.print("Ingrese una opcion: ");
            e = Integer.parseInt(System.console().readLine());

            switch (e) {
                case 1:
                    if (oracion.equals("")) {
                        System.out.print("Ingrese una oracion: ");
                        oracion = System.console().readLine();
                    } else {
                        oracion = "";
                    }
                case 2:
                    System.out.println("La cantidad de caracteres es: " + oracion.length());
                    break;
                case 3:
                    palabras = oracion.split(" ");
                    System.out.println("La cantidad de palabras es: " + palabras.length);
                    break;
                case 4:
                    palabras = oracion.split(" ");
                    // ordena alfabeticamente
                    for (int i = 0; i < palabras.length; i++) {
                        for (int j = 0; j < palabras.length; j++) {
                            if (palabras[i].compareTo(palabras[j]) < 0) {
                                String aux = palabras[i];
                                palabras[i] = palabras[j];
                                palabras[j] = aux;
                            }
                        }
                    }
                    for (int i = 0; i < palabras.length; i++) {
                        System.out.print(palabras[i] + " ");
                    }
                    System.out.println();
                    break;
                case 5:
                    palabras = oracion.split(" ");
                    System.out.print("Ingrese un numero: ");
                    int num = Integer.parseInt(System.console().readLine());
                    num--;
                    if (num >= 0 && num < palabras.length) {
                        System.out.println("La palabra en la posicion " + (num + 1) + " es: " + palabras[num]);
                    } else {
                        System.out.println("Número inválido. Intente nuevamente");
                    }
                    break;
                case 6:
                    palabras = oracion.split(" ");
                    int posicion = 0;
                    System.out.print("Ingrese una palabra: ");
                    String palabra = System.console().readLine();
                    boolean encontrado = false;
                    for (int i = 0; i < palabras.length; i++) {
                        if (palabras[i].equals(palabra)) {
                            posicion = i;
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("La palabra " + palabra + " se encuentra en la oracion en la posicion "
                                + (posicion + 1));
                    } else {
                        System.out.println("La palabra " + palabra + " no se encuentra en la oracion");
                    }
                    break;
                case 7:
                    boolean existe = false;
                    palabras = oracion.split(" ");
                    System.out.print("Ingrese una palabra: ");
                    String palabra1 = System.console().readLine();
                    // verificar si palabra existe
                    for (int i = 0; i < palabras.length; i++) {
                        if (palabras[i].equals(palabra1)) {
                            existe = true;
                        }
                    }
                    if (existe) {
                        System.out.print("Ingrese una palabra nueva: ");
                        String palabra2 = System.console().readLine();
                        //validacion solo letras y espacios
                        if (palabra2.matches("^[a-zA-Z ]*$")) {
                            oracion = oracion.replace(palabra1, palabra2);
                            System.out.println("La oracion modificada es: " + oracion);
                        } else {
                            System.out.println("La palabra no es válida. Intente nuevamente");
                        }
                    } else {
                        System.out.println("La palabra no existe en la oracion");
                    }
                    break;
                case 8:
                    System.out.print("Ingrese contenido a agregar: ");
                    String contenido = System.console().readLine();
                    //validacion solo letras y espacios
                    if (contenido.matches("^[a-zA-Z ]*$")) {
                        oracion += " " + contenido;
                        System.out.println("La oracion modificada es: " + oracion);
                    } else {
                        System.out.println("El contenido no es válido. Intente nuevamente");
                    }
                    break;
            }
        } while (e != 9);

    }
}
