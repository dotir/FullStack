public class PracticandoMath {
    
    public static void main(String[] args) {
        //ejercicios video
        // //valor absoluto
        System.out.println(Math.abs(-5));
        // //valor random
        System.out.println(Math.random());
        System.out.println(Math.random()*5);
        // //ramdom entero
        System.out.println((int) (Math.random()*(1000-995+1)+995));

        //calcular el valor absoluto
        System.out.println("Ingrese un número: ");
        int num = Integer.parseInt(System.console().readLine());
        System.out.println("El valor absoluto de " + num + " es: " + Math.abs(num));

        //Redondear numeros
        System.out.println("Ingrese un número decimal: ");
        double num2 = Double.parseDouble(System.console().readLine());
        System.out.println("El número redondeado es: " + Math.round(num2));

        //numero aleatorio del 1 al 355
        System.out.println("Número aleatorio entre 1 y 355: " + (int) (Math.random()*(355-1+1)+1));

        //calculando la potencia
        System.out.println("Ingrese un número: ");
        int num3 = Integer.parseInt(System.console().readLine());
        System.out.println("Ingrese la potencia: ");
        int potencia = Integer.parseInt(System.console().readLine());
        System.out.println("El resultado de elevar " + num3 + " a la potencia " + potencia + " es: " + Math.pow(num3, potencia));
        
        //calcular la raiz cuadrada si es negativo muestra un mensaje
        System.out.println("Ingrese un número: ");
        double num4 = Double.parseDouble(System.console().readLine());
        if (num4 < 0) {
            System.out.println("No se puede calcular la raíz cuadrada de un número negativo");
        } else {
            System.out.println("La raíz cuadrada de " + num4 + " es: " + Math.sqrt(num4));
        }

    }
}
