package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;
import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> obtenerTodosLosClientes() throws Exception {
        return clienteDAO.listarClientes();
    }
}
