package servicios;

import entidades.Casa;
import persistencia.CasaDAO;
import java.util.List;

public class CasaService {
    private CasaDAO casaDAO;

    public CasaService(CasaDAO casaDAO) {
        this.casaDAO = casaDAO;
    }

    public List<Casa> obtenerTodasLasCasas() throws Exception {
        return casaDAO.listarCasas();
    }

    public List<Casa> obtenerCasasDisponiblesAgosto2020() throws Exception {
        return casaDAO.listarCasasDisponiblesAgosto2020();
    }

    public void incrementarPrecioPorDia(double porcentaje) throws Exception {
        casaDAO.incrementarPrecioPorDia(porcentaje);
    }

}
