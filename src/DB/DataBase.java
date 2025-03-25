package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static final String url = "jdbc:mysql://localhost:3306/gestionclientes";
    private static final String usuario = "root";
    private static final String clave = "";

    private static Connection conexion = null; 

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave); 
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: el driver mysql no se encuentra");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("ERROR de conexión");
            ex.printStackTrace();
        }
        return conexion;
    }



  public static void Desconectar(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException ex) {
                System.out.println("ERROR al cerrar la conexión");
                ex.printStackTrace();
            }
        }
    }
}




