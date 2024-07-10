public class Desafio1 {
    
    public static void main(String[] args) {

        double temp = 0;
        String unidad = "";
        
        System.out.println("Ingresa una temperatura:");
        try {
            temp = Double.parseDouble(System.console().readLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Temperatura no válida. Ingrese una temperatura numérica.");
            return;
        }
        System.out.println("Ingresa la unidad de medida: Celsius (C), Fahrenheit (F):");
        unidad = System.console().readLine();
        //convertir si es celsius a fahrenheit y si es fahrenheit a celsius
        if (unidad.equals("F")) {
            double c = (temp * 9/5) + 32;
            System.out.println((int)temp+" grados Celsius equivale a "+(int)c+" Fahrenheit");
        } else if (unidad.equals("C")) {
            double f = (temp - 32) * 5/9;
            System.out.println((int)temp+" grados Fahrenheit equivale a" +(int) f + " Celsius");
        } else {
            System.out.println("Error: Unidad de medida no válida. Ingrese C para Celsius o F para Fahrenheit.");
        }
    }
}
