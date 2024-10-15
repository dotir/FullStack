package servicios;

import entidades.Familia;
import persistencia.FamiliaDAO;
import java.util.List;

public class FamiliaService {
    private FamiliaDAO familiaDAO;

    public FamiliaService(FamiliaDAO familiaDAO) {
        this.familiaDAO = familiaDAO;
    }

    public List<Familia> obtenerTodasLasFamilias() throws Exception {
        return familiaDAO.listarFamilias();
    }

    public List<Familia> obtenerFamiliasConHijosYEdadMaxima() throws Exception {
        return familiaDAO.listarFamiliasConHijosYEdadMaxima();
    }

    public List<Familia> obtenerFamiliasConEmailHotmail() throws Exception {
        return familiaDAO.listarFamiliasConEmailHotmail();
    }
}
