package POO.IntroaPoo.Actividad2;

public class Applicarion {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Toyota", "Corolla", 2020);
        Auto auto2 = new Auto("Nissan", "Sentra");
        Auto auto3 = new Auto("Ford");
        Auto auto4 = new Auto();
        System.out.println("--------------------");
        auto1.imprimirDatos();
        System.out.println("--------------------");
        auto2.imprimirDatos();
        System.out.println("--------------------");
        auto3.imprimirDatos();
        System.out.println("--------------------");
        auto4.imprimirDatos();

    }
}
