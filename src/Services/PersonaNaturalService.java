
package Services;

import DB.DataBase;
import Models.PersonaNatural;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonaNaturalService {
    public boolean insertarCliente(PersonaNatural cliente){
        boolean respuesta = false;
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "INSERT INTO Personas (identificacion, tipoIdentificacion, nombres, apellidos, genero, telefono, correo, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, cliente.getIdentificacion());
                pstmt.setString(2, cliente.getTipoIdentificacion());
                pstmt.setString(3, cliente.getNombre());
                pstmt.setString(4, cliente.getApellido());
                pstmt.setString(5, cliente.getGenero());
                pstmt.setString(6, cliente.getTelefono());
                pstmt.setString(7, cliente.getCorreo());
                pstmt.setDate(8,cliente.getFechaNacimiento());
                pstmt.executeUpdate();
                System.out.println("Cliente registrado exitosamente");
                respuesta = true;
            } catch(SQLException ex){
                System.out.println("Error al registrar el Cliente: " + ex.getMessage());
                ex.printStackTrace();
                respuesta = false;
            } finally {
                DataBase.Desconectar(conn);
            }
        }
        return respuesta;
    }
}
