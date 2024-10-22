package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.persistencia.ClienteDAO;

import java.util.List;

public class ClienteServicio {

    private final ClienteDAO daoCliente;

    public ClienteServicio() {
        this.daoCliente = new ClienteDAO();
    }

    public void crearCliente(String apellidoContacto, String ciudad, int codigoCliente, String codigoPostal,
                             String fax, double limiteCredito, String nombreCliente, String nombreContacto,
                             String pais, String region, String telefono, Empleado empleado) {
        try {
            // Crear una nueva instancia de Cliente
            Cliente clienteNuevo = new Cliente();

            clienteNuevo.setApellido_contacto(apellidoContacto);
            clienteNuevo.setCiudad(ciudad);
            clienteNuevo.setCodigo_cliente(codigoCliente);
            clienteNuevo.setCodigo_postal(codigoPostal);
            clienteNuevo.setFax(fax);
            clienteNuevo.setLimite_credito(limiteCredito);
            clienteNuevo.setNombre_cliente(nombreCliente);
            clienteNuevo.setNombre_contacto(nombreContacto);
            clienteNuevo.setPais(pais);
            clienteNuevo.setRegion(region);
            clienteNuevo.setTelefono(telefono);
            clienteNuevo.setEmpleado(empleado);

            // Llamar al método de ClienteDAO para guardar el nuevo cliente
            daoCliente.guardarCliente(clienteNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + " No se guardó el nuevo cliente de manera correcta");
        }
    }

    public Cliente buscarClientePorId(int idCliente) {
        return daoCliente.buscarClientePorId(idCliente);
    }

    public void listarClientes() throws Exception {
        List<Cliente> todosClientes = daoCliente.listarTodos();
        imprimirLista(todosClientes);
    }

    public void listarClientes(String nombreRecibido) throws Exception {
        List<Cliente> clientesNombre = daoCliente.listarClientesPorNombre(nombreRecibido);
        imprimirLista(clientesNombre);
    }

    private void imprimirLista(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getId_cliente() + " - " + cliente.getNombre_cliente() + " - " + cliente.getApellido_contacto());
        }
    }

    public void listarClientesPorCiudad(String ciudad) throws Exception {
        List<Cliente> clientesCiudad = daoCliente.listarClientesPorCiudad(ciudad);
        System.out.println("Clientes en la ciudad de " + ciudad + ":");
        imprimirLista(clientesCiudad);
    }

    public void listarClientesPorEmpleado(int idEmpleado) throws Exception {
        List<Cliente> clientes = daoCliente.listarClientesPorEmpleado(idEmpleado);
        System.out.println("Clientes del empleado con ID " + idEmpleado + ":");
        imprimirLista(clientes);
    }
    
}
