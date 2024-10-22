package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

import java.util.List;

public class GamaProductoServicio {

    private final GamaProductoDAO daoGamaProducto;

    public GamaProductoServicio() {
        this.daoGamaProducto = new GamaProductoDAO();
    }

    public void crearGamaProducto(String descripcionHtml, String descripcionTexto, String gama, String imagen) {
        try {
            // Crear una nueva instancia de GamaProducto
            GamaProducto gamaProductoNuevo = new GamaProducto();

            gamaProductoNuevo.setDescripcion_html(descripcionHtml);
            gamaProductoNuevo.setDescripcion_texto(descripcionTexto);
            gamaProductoNuevo.setGama(gama);
            gamaProductoNuevo.setImagen(imagen);

            // Llamar al método de GamaProductoDAO para guardar la nueva gama de producto
            daoGamaProducto.guardarGamaProducto(gamaProductoNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + " No se guardó la nueva gama de producto de manera correcta");
        }
    }

    public GamaProducto buscarGamaProductoPorId(int idGama) {
        return daoGamaProducto.buscarGamaProductoPorId(idGama);
    }

    public void modificarGamaProducto(int idGama, String descripcionHtml, String descripcionTexto, String gama, String imagen) {
        try {
            GamaProducto gamaProducto = daoGamaProducto.buscarGamaProductoPorId(idGama);
            if (gamaProducto != null) {
                gamaProducto.setDescripcion_html(descripcionHtml);
                gamaProducto.setDescripcion_texto(descripcionTexto);
                gamaProducto.setGama(gama);
                gamaProducto.setImagen(imagen);

                daoGamaProducto.modificarGamaProducto(gamaProducto);
            } else {
                System.out.println("Gama de producto no encontrada.");
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " No se pudo modificar la gama de producto.");
        }
    }

    public void listarGamasProducto() throws Exception {
        List<GamaProducto> todasGamas = daoGamaProducto.listarTodos();
        imprimirLista(todasGamas);
    }

    private void imprimirLista(List<GamaProducto> gamas) {
        for (GamaProducto gama : gamas) {
            System.out.println(gama.getId_gama() + " - " + gama.getGama());
        }
    }

}
