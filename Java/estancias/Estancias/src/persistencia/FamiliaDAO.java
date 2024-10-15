package persistencia;

import entidades.Familia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO {
    private Connection connection;

    public FamiliaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Familia> listarFamilias() throws Exception {
        List<Familia> familias = new ArrayList<>();
        String query = "SELECT * FROM familias";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Familia familia = new Familia();
                familia.setId(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdad_minima(rs.getInt("edad_minima"));
                familia.setEdad_maxima(rs.getInt("edad_maxima"));
                familia.setNum_hijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familias.add(familia);
            }
        }
        return familias;
    }

    public List<Familia> listarFamiliasConHijosYEdadMaxima() throws Exception {
        List<Familia> familias = new ArrayList<>();
        String query = "SELECT * FROM familias WHERE num_hijos >= 3 AND edad_maxima < 10";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Familia familia = new Familia();
                familia.setId(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdad_minima(rs.getInt("edad_minima"));
                familia.setEdad_maxima(rs.getInt("edad_maxima"));
                familia.setNum_hijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familias.add(familia);
            }
        }
        return familias;
    }

    public List<Familia> listarFamiliasConEmailHotmail() throws Exception {
        List<Familia> familias = new ArrayList<>();
        String query = "SELECT * FROM familias WHERE email LIKE '%hotmail%'";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Familia familia = new Familia();
                familia.setId(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdad_minima(rs.getInt("edad_minima"));
                familia.setEdad_maxima(rs.getInt("edad_maxima"));
                familia.setNum_hijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familias.add(familia);
            }
        }
        return familias;
    }
}
