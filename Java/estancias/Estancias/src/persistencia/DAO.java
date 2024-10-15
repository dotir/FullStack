package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    private static Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "estancias_exterior";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Método para obtener la conexión única
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conexion == null || conexion.isClosed()) {
            try {
                Class.forName(DRIVER);
                String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
                conexion = DriverManager.getConnection(url, USER, PASSWORD);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        return conexion;
    }

    protected void connectarDataBase() throws SQLException, ClassNotFoundException {
        conexion = getConnection();
        System.out.println("Conexión exitosa a la base de datos.");
    }

    protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    protected void insertarModificarEliminarDataBase(String sql) throws SQLException, ClassNotFoundException {
        try {
            connectarDataBase();
            statement = conexion.createStatement();
            statement.executeUpdate(sql);
        } finally {
            desconectarDataBase();
        }
    }

    protected ResultSet consultarDataBase(String sql) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        try {
            connectarDataBase();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } 
        return resultSet;
    }
}
