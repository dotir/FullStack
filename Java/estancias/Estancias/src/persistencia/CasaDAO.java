package persistencia;

import entidades.Casa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CasaDAO {
    private Connection connection;

    public CasaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Casa> listarCasas() throws Exception {
        List<Casa> casas = new ArrayList<>();
        String query = "SELECT * FROM casas";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Casa casa = new Casa();
                casa.setIdCasa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                // Set other fields as needed
                casas.add(casa);
            }
        }
        return casas;
    }

    public List<Casa> listarCasasDisponiblesAgosto2020() throws Exception {
        List<Casa> casas = new ArrayList<>();
        String query = "SELECT * FROM casas WHERE pais = 'Reino Unido' AND fecha_desde <= '2020-08-01' AND fecha_hasta >= '2020-08-31'";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Casa casa = new Casa();
                casa.setIdCasa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCodigoPostal(rs.getString("codigo_postal"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPais(rs.getString("pais"));
                casa.setFechaDesde(rs.getDate("fecha_desde"));
                casa.setFechaHasta(rs.getDate("fecha_hasta"));
                casa.setTiempoMinimo(rs.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(rs.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(rs.getDouble("precio_habitacion"));
                casa.setTipoVivienda(rs.getString("tipo_vivienda"));
                casas.add(casa);
            }
        }
        return casas;
    }

    public void incrementarPrecioPorDia(double porcentaje) throws Exception {
        String query = "UPDATE casas SET precio_habitacion = precio_habitacion * (1 + ? / 100) WHERE pais = 'Reino Unido'";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, porcentaje);
            stmt.executeUpdate();
        }
    }
}
