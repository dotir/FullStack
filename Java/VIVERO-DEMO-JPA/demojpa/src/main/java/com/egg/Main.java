package com.egg;

import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.entidades.GamaProducto;
import com.egg.servicios.GamaProductoServicio;
import com.egg.servicios.OficinaServicio;
import com.egg.servicios.ClienteServicio;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        // EntityManager em = emf.createEntityManager();

        // Instanciar la clase OficinaServicio para acceder a sus métodos
        OficinaServicio oficinaServicio = new OficinaServicio();
        // Instanciar la clase ClienteServicio para acceder a sus métodos
        ClienteServicio clienteServicio = new ClienteServicio();
        // Instanciar la clase GamaProductoServicio para acceder a sus métodos
        GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();

        // // Llamar al método del servicio para crear una nueva oficina
        // oficinaServicio.crearOficna("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111",
        //         "CP5000");

        // Crear un nuevo cliente
        // Empleado empleado = new Empleado(); // You need to set the appropriate fields for Empleado
        // clienteServicio.crearCliente("Perez", "Buenos Aires", 12345, "1000", "123456789", 50000.0,
        //         "Cliente S.A.", "Juan Perez", "Argentina", "Buenos Aires", "987654321", empleado);

        // Crear una nueva gama de producto
        // gamaProductoServicio.crearGamaProducto("Descripción HTML", "Descripción Texto", "Gama Alta", "imagen.jpg");
    
        //busquedas
        // Buscar un cliente por ID
        Cliente cliente = clienteServicio.buscarClientePorId(1); // Assuming the ID is 1
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNombre_cliente());
        } else {
            System.out.println("Cliente no encontrado.");
        }

        // Buscar una gama de producto por ID
        GamaProducto gamaProducto = gamaProductoServicio.buscarGamaProductoPorId(1); // Assuming the ID is 1
        if (gamaProducto != null) {
            System.out.println("Gama de producto encontrada: " + gamaProducto.getGama());
        } else {
            System.out.println("Gama de producto no encontrada.");
        }
    
    
    }
}