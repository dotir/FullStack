package POO.Encapsulamiento.planoxy;

public class Application {
    
    public static void main(String[] args) {
        // Declarar una variable global como un arreglo de objetos 'Punto'
        Punto[] puntos = new Punto[3];

        // Crear instancias de Punto
        puntos[0] = new Punto(1, 2);
        puntos[1] = new Punto(3, 4);
        puntos[2] = new Punto(5, 6);

        // Ejemplo de uso de los métodos
        System.out.println("Distancia desde el origen del punto (1, 2): " + puntos[0].distanciaDesdeOrigen());
        System.out.println("Distancia entre los puntos (1, 2) y (3, 4): " + Punto.calcularDistancia(puntos[0], puntos[1]));
        System.out.println("¿Están alineados los puntos (1, 2), (3, 4) y (5, 6)? " + Punto.estanAlineados(puntos[0], puntos[1], puntos[2]));
    }
}
