package persistencia;

import entidades.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO {
    private Connection connection;

    public ComentarioDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Comentario> listarComentarios() throws Exception {
        List<Comentario> comentarios = new ArrayList<>();
        String query = "SELECT * FROM comentarios";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("id_comentario"));
                comentario.setIdCasa(rs.getInt("id_casa"));
                comentario.setComentario(rs.getString("comentario"));
                comentarios.add(comentario);
            }
        }
        return comentarios;
    }
}
