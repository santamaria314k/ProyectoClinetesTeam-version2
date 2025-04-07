
package Services;

import DB.DataBase;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioService {
    public boolean insertarUsuario (Usuario usuario){
        boolean respuesta = false;
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
                respuesta = true;
            } catch(SQLException ex){
                System.out.println("Error al registrar el usuario: " + ex.getMessage());
                ex.printStackTrace();
                respuesta = false;
            } finally {
                DataBase.Desconectar(conn);
            }
        }
        return respuesta;
    }
    
    public boolean validarUsuarioExistente(int identificacion){
        boolean respuesta = true;
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "SELECT identificacionPersona FROM usuarios WHERE identificacionPersona = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, identificacion);
                ResultSet cantidadResultados = pstmt.executeQuery();
                if(!cantidadResultados.next()){
                    respuesta = false;
                }
            } catch(SQLException ex){
                System.out.println("Error al buscar el usuario: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
        return respuesta;
    }
    
    
    
    public boolean insertarUsuarioNatural (Usuario usuario){
        boolean respuesta = false;
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "INSERT INTO usuarios (username, clave, identificacionPersona, personaRol) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, usuario.getUsername());
                pstmt.setString(2, usuario.getPassword());
                pstmt.setInt(3, usuario.getPersonaNatural().getIdentificacion());
                pstmt.setInt(4, usuario.getRol().getIdrol());
                pstmt.executeUpdate();
                System.out.println("Usuario registrado exitosamente");
                respuesta = true;
            } catch(SQLException ex){
                System.out.println("Error al registrar el usuario: " + ex.getMessage());
                ex.printStackTrace();
                respuesta = false;
            } finally {
                DataBase.Desconectar(conn);
            }
        }
        return respuesta;
    }
    
}
