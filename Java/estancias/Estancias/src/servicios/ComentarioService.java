package servicios;
import entidades.Comentario;
import persistencia.ComentarioDAO;
import java.util.List;

public class ComentarioService {
    private ComentarioDAO comentarioDAO;

    public ComentarioService(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    public List<Comentario> obtenerTodosLosComentarios() throws Exception {
        return comentarioDAO.listarComentarios();
    }
}
