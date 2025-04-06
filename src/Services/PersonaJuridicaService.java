
package Services;

import DB.DataBase;
import Models.PersonaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PersonaJuridicaService {
    public boolean insertarEmpresa(PersonaJuridica empresa){
        boolean respuesta = false;
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "INSERT INTO Personas (identificacion, digitoVerificacion, descripcionActividad, tipoIdentificacion, nombres, telefono, correo, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, empresa.getIdentificacion());
                pstmt.setInt(2, empresa.getDigitoVerificacion());
                pstmt.setString(3, empresa.getDescripcionActividad());
                pstmt.setString(4, empresa.getTipoIdentificacion());
                pstmt.setString(5, empresa.getNombre());
                pstmt.setString(6, empresa.getTelefono());
                pstmt.setString(7, empresa.getCorreo());
                pstmt.setDate(8,empresa.getFechaNacimiento());
                pstmt.executeUpdate();
                System.out.println("Empresa registrada exitosamente");
                respuesta = true;
            } catch(SQLException ex){
                System.out.println("Error al registrar la empresa: " + ex.getMessage());
                ex.printStackTrace();
                respuesta = false;
            } finally {
                DataBase.Desconectar(conn);
            }
        }
        return respuesta;
    }
}
