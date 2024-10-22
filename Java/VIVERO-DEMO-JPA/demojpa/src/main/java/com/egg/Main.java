package com.egg;

import java.text.SimpleDateFormat;

import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.entidades.GamaProducto;
import com.egg.servicios.GamaProductoServicio;
import com.egg.servicios.OficinaServicio;
import com.egg.servicios.PagoServicio;
import com.egg.servicios.ClienteServicio;
import com.egg.servicios.EmpleadoServicio;
import com.egg.servicios.PedidoServicio;
import com.egg.servicios.ProductoServicio;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        // EntityManager em = emf.createEntityManager();

        // Instanciar la clase OficinaServicio para acceder a sus métodos
        OficinaServicio oficinaServicio = new OficinaServicio();
        // Instanciar la clase ClienteServicio para acceder a sus métodos
        ClienteServicio clienteServicio = new ClienteServicio();
        // Instanciar la clase GamaProductoServicio para acceder a sus métodos
        GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();
        // Instanciar la clase EmpleadoServicio para acceder a sus métodos
        EmpleadoServicio empleadoServicio = new EmpleadoServicio();
        // Instanciar la clase PedidoServicio para acceder a sus métodos
        PedidoServicio pedidoServicio = new PedidoServicio();
        // Instanciar la clase ProductoServicio para acceder a sus métodos
        ProductoServicio productoServicio = new ProductoServicio();

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
        // // Buscar un cliente por ID
        // Cliente cliente = clienteServicio.buscarClientePorId(1); // Assuming the ID is 1
        // if (cliente != null) {
        //     System.out.println("Cliente encontrado: " + cliente.getNombre_cliente());
        // } else {
        //     System.out.println("Cliente no encontrado.");
        // }

        // // Buscar una gama de producto por ID
        // GamaProducto gamaProducto = gamaProductoServicio.buscarGamaProductoPorId(1); // Assuming the ID is 1
        // if (gamaProducto != null) {
        //     System.out.println("Gama de producto encontrada: " + gamaProducto.getGama());
        // } else {
        //     System.out.println("Gama de producto no encontrada.");
        // }
        
        // System.out.println("Listado de oficinas:");
        // System.out.println("Código - Ciudad - País");
        // try {
        //     oficinaServicio.listarOficinas();
        // } catch (Exception e) {
        //     System.out.println("Error al listar las oficinas.");
        // }

        // try {
        //     // Test listarEmpleadosPorOficina
        //     System.out.println("Listando empleados de la oficina con ID 1:");
        //     empleadoServicio.listarEmpleadosPorOficina(1);

        //     // Test listarClientesPorCiudad
        //     System.out.println("\nListando clientes en la ciudad de Buenos Aires:");
        //     clienteServicio.listarClientesPorCiudad("Buenos Aires");

        //     // Test listarPedidosRetrasados
        //     System.out.println("\nListando pedidos retrasados:");
        //     pedidoServicio.listarPedidosRetrasados();

        // } catch (Exception e) {
        //     System.out.println("Error en la ejecución: " + e.getMessage());
        // }


        // // Listar todos los productos que en su detalle tengan un producto específico que se pasa el nombre como parámetro
        // try {
        //     // Test listarProductosPorDetalle
        //     System.out.println("\nListando productos que contienen 'Flor' en su detalle:");
        //     productoServicio.listarProductosPorDetalle("Pala");

        //     // You can test with different product names
        //     System.out.println("\nListando productos que contienen 'Árbol' en su detalle:");
        //     productoServicio.listarProductosPorDetalle("Ajedrea");

        // } catch (Exception e) {
        //     System.out.println("Error en la ejecución: " + e.getMessage());
        // }

        // // Listar todos los pedidos de un cliente que se pasa por nombre como parámetro y que los pedidos están entre un rango de fechas que también se recibe como parámetro.
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // try {
        //     Date fechaInicio = sdf.parse("2006-01-01");
        //     Date fechaFin = sdf.parse("2010-12-31");

        //     pedidoServicio.listarPedidosPorClienteYFechas("Lasas S.A.", fechaInicio, fechaFin);
        // } catch (java.text.ParseException e) {
        //     System.out.println("Error parsing date: " + e.getMessage());
        // }

        // // Listar todos los clientes de un empleado de contacto específico que se pasa como parámetro. 
        // clienteServicio.listarClientesPorEmpleado(5);

        // // Listar todos los empleados de una oficina específica, la cual se pasa el código o nombre como parámetro.
        // empleadoServicio.listarEmpleadosPorOficinaCodigoONombre("BCN-ES"); // Usando codigo
        // // o
        // empleadoServicio.listarEmpleadosPorOficinaCodigoONombre("Barcelona"); // Usando nombre

        // // Listar todos los empleados que son jefes.
        // empleadoServicio.listarEmpleadosJefes();

        // // Listar los 10 productos más vendidos en los pedidos. Investiga cómo sumar los productos en el listado y cómo funcionan los límites en los listados.
        // productoServicio.listarTop10ProductosMasVendidos(); 

        // // Listar todos los pagos que se hicieron entre un rango de fechas que se recibe por parámetro.
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Date fechaInicio = sdf.parse("2004-01-01");
        // Date fechaFin = sdf.parse("2010-12-31");

        // PagoServicio pagoServicio = new PagoServicio();
        // pagoServicio.listarPagosPorRangoFechas(fechaInicio, fechaFin);

    
    }
}