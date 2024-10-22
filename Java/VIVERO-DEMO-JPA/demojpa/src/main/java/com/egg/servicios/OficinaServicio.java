package com.egg.servicios;


import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;
import java.util.List;


public class OficinaServicio {


    private final OficinaDAO daoOficina;// Instancio a la unidad d persistencia para acceder a los metodos del EM


    public OficinaServicio() {
       this.daoOficina = new OficinaDAO();
    }


    public void crearOficna(String codigodOficina, String ciudad, String pais,
            String region, String telefono, String codigoPostal) {

        try {
            // Crear una nueva instancia de Oficina
            Oficina oficinaNueva = new Oficina();
            oficinaNueva.setCodigo_oficina(codigodOficina);
            oficinaNueva.setCiudad(ciudad);
            oficinaNueva.setPais(pais);
            oficinaNueva.setRegion(region);
            oficinaNueva.setTelefono(telefono);
            oficinaNueva.setCodigo_postal(codigoPostal);
            // Llamar al método de OficinaDAO para guardar la nueva oficina
            daoOficina.guardaOficina(oficinaNueva);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva oficina de manera correcta");
        }


    }

    public void listarOficinas() throws Exception{
        List<Oficina> todasOficinas = daoOficina.listarTodas();
        imprimirLista(todasOficinas);
    }

    private void imprimirLista(List<Oficina> listaRecibida) {
        for (Oficina unitariaOficina : listaRecibida) {
            System.out.println(unitariaOficina.getCodigo_oficina()+"-" + unitariaOficina.getCiudad() + "-"
                                + unitariaOficina.getPais());
        }
    }
}


