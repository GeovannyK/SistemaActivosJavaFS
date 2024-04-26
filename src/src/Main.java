package src;

import java.sql.Connection;
import java.sql.SQLException;
import Vistas.Interfaz;
import Vistas.Login;

public class Main {
    public static void main(String[] args) {
        
        Conn conexion = new Conn();

                try {
            Connection con = conexion.getConexion();
            if (con != null) {
                System.out.println("Conexion exitosa a la base de datos.");

        
                Login login = new Login();
                login.setVisible(true);

        
                while (login.isVisible()) {
                    Thread.sleep(100); 
                }

                
                if (login.isLoginSuccessful()) {
                
                    Interfaz interfaz = new Interfaz();
                    interfaz.setVisible(true);
                } else {
                    System.out.println("Inicio de sesión fallido. La ventana de Interfaz no se mostrará.");
                }
            } else {
                System.out.println("Error al conectar a la base de datos.");
            }
        } catch (SQLException | InterruptedException e) {
                        e.printStackTrace();
        }
    }
}
