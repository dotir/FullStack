package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.persistencia.ClienteDAO;

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
}
