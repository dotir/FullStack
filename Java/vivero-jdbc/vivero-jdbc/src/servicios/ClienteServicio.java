package servicios;
import persistencia.clienteDAO;
import entidades.Cliente;

public class ClienteServicio {
    private clienteDAO cd;
    public  ClienteServicio(){
        this.cd =  new clienteDAO();
    }
    public Cliente crearNuevoCliente(int codigoC, String nombre, String nombreContacto, String apellidoContacto,
            String telefono, String fax, String ciudad, String region, String pais, String codigoPostal,
            int idEmpleado, double limiteCredito) throws Exception {
        // Validaciones - Pueden estar metodo independiente.
       validacionesNyA(nombreContacto, apellidoContacto);
        Cliente cliente = new Cliente(codigoC, nombre, nombreContacto, apellidoContacto, telefono, fax, ciudad, region,
                pais, codigoPostal, idEmpleado, limiteCredito);
        cd.guardarCliente(cliente);
        return cliente;
    }
    public void validacionesNyA(String nombreContacto, String apellidoContacto) throws Exception{
        if (nombreContacto == null) {
            throw new Exception("El nombre del contacto no puede ser nulo.");
        }
        if (apellidoContacto == null) {
            throw new Exception("El apellido del contacto no puede ser nulo.");
        }
    }

    public void listarTodosLosClientes() throws Exception {
        cd.listarTodosLosClientes();
    }

    public void buscarClientePorCodigo(int codigo) throws Exception {
        //si codigo viene null
        if (codigo == 0) {
            throw new Exception("El código del cliente no puede ser nulo.");
        }
        cd.buscarClientePorCodigo(codigo);
    }
}
