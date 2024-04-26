package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    private Connection con = null;
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3308/Activos";

    public Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC no encontrado", e);
        } catch (SQLException e) {
                        throw new SQLException("Error al conectar con la base de datos", e);
        }
    }
    
    
    public void desconectar() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

