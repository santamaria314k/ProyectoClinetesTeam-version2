
package Services;

import DB.DataBase;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Usuario;
import Models.PersonaNatural;
import Models.PersonaJuridica;
import Models.Rol;

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
    
    
    public Usuario login(String username, String password) {
    Connection conexion = DataBase.conectar();
    if (conexion != null) {
        try {
            String query = "SELECT * FROM usuarios u " +
                           "JOIN roles r ON u.personaRol = r.idRol " +
                           "LEFT JOIN personas p ON u.identificacionPersona = p.identificacion " +
                           "WHERE u.username = ? AND u.clave = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idUsuario = rs.getInt("id");
                String rolNombre = rs.getString("nombreRol");
                int idRol = rs.getInt("idRol");

                Rol rol = new Rol(idRol, rolNombre);

                PersonaNatural personaNatural = null;
                PersonaJuridica personaJuridica = null;

                String apellido = rs.getString("apellidos");
                String genero = rs.getString("genero");
                Integer digito = rs.getObject("digitoVerificacion", Integer.class);
                String actividad = rs.getString("descripcionActividad");

                boolean esAdmin = rs.getBoolean("esAdmin");

                if (apellido != null && genero != null) {
                    personaNatural = new PersonaNatural(
                        apellido,
                        genero,
                        rs.getInt("identificacion"),
                        rs.getString("tipoIdentificacion"),
                        rs.getString("nombres"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getDate("fechaNacimiento"),
                        esAdmin
                    );
                } else if (digito != null && actividad != null) {
                    personaJuridica = new PersonaJuridica(
                        digito,
                        actividad,
                        rs.getInt("identificacion"),
                        rs.getString("tipoIdentificacion"),
                        rs.getString("nombres"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getDate("fechaNacimiento"),
                        esAdmin
                    );
                }

                return new Usuario(idUsuario, username, password, personaJuridica, personaNatural, rol, esAdmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBase.Desconectar(conexion);
        }
    }

    return null; // Login fallido
}

}
