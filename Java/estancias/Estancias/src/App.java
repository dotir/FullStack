import persistencia.CasaDAO;
import persistencia.DAO;
import persistencia.FamiliaDAO;
import servicios.CasaService;
import servicios.FamiliaService;

import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        //menu java
        try {
            Connection connection = DAO.getConnection();
            FamiliaDAO familiaDAO = new FamiliaDAO(connection);
            CasaDAO casaDAO = new CasaDAO(connection);

            FamiliaService familiaService = new FamiliaService(familiaDAO);
            CasaService casaService = new CasaService(casaDAO);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Listar familias con al menos 3 hijos y edad máxima inferior a 10 años");
                System.out.println("2. Listar casas disponibles en Reino Unido en agosto de 2020");
                System.out.println("3. Listar familias con email de Hotmail");
                System.out.println("4. Incrementar precio por día en un 5% para casas en Reino Unido");
                System.out.println("0. Salir");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        familiaService.obtenerFamiliasConHijosYEdadMaxima().forEach(System.out::println);
                        break;
                    case 2:
                        casaService.obtenerCasasDisponiblesAgosto2020().forEach(System.out::println);
                        break;
                    case 3:
                        familiaService.obtenerFamiliasConEmailHotmail().forEach(System.out::println);
                        break;
                    case 4:
                        casaService.incrementarPrecioPorDia(5.0);
                        System.out.println("Precios actualizados.");
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DAO.getConnection().close();
        }
    }
}
