
package Services;

import DB.DataBase;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioService {
    public void insertarUsuario (Usuario usuario){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "INSERT INTO usuarios (username, clave, identificacionPersona, personaRol) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, usuario.getUsername());
                pstmt.setString(2, usuario.getPassword());
                pstmt.setInt(3, usuario.getPersonaJuridica().getIdentificacion());
                pstmt.setInt(4, usuario.getRol().getIdrol());
                pstmt.executeUpdate();
                System.out.println("Usuario registrado exitosamente");
            } catch(SQLException ex){
                System.out.println("Error al registrar el usuario: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }
}
