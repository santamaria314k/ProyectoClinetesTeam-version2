
package Services;

import java.sql.*;
import DB.DataBase;
import Models.PersonaNatural;

public class PersonaNaturalService {
    
    
    public void RegistrarPersonaNatural(PersonaNatural personaNatural) {
        String sql = "INSERT INTO personas (identificacion,tipoIdentificacion,nombres,apellidos,genero,telefono,correo,fechaNacimiento,esAdmin) VALUES (?,?,?,?,?,?,?,?)";

        
        try (Connection conn = DataBase.conectar();
             PreparedStatement pstm = conn.prepareStatement(sql)  ){
            pstm.setInt(0,personaNatural.getIdentificacion());
            pstm.setString(1,personaNatural.getTipoIdentificacion());
            pstm.setString(2,personaNatural.getNombre());
            pstm.setString(3, personaNatural.getApellido());
            pstm.setString(3, personaNatural.getGenero());
            pstm.setString(3, personaNatural.getTelefono());
            pstm.setString(3, personaNatural.getCorreo());
           // pstm.setDate(3, personaNatural.getFechaNacimiento());
            pstm.setBoolean(3, personaNatural.isEsAdmin());
            
            int columAfec=pstm.executeUpdate();
            
            System.out.println(columAfec >0 ? "persona creada ": "No se creo una persona");
             
        } catch (Exception ex) {
        System.out.println("Error al crear una Persona: " + ex.getMessage());
        ex.printStackTrace();
        }
        
    }
        
        public void ImprimirPersonasNaturales(){
        String sql ="SELECT * FROM personas";
        
            try (Connection conn = DataBase.conectar();
                    Statement stmt=conn.createStatement();
                    ResultSet rs =stmt.executeQuery(sql)
                    ){
                while (rs.next()) {
                    System.out.println("Identificasion: "+rs.getInt("identificacion"));
                    System.out.println("tipo identificasion :"+rs.getString("tipoIdentificacion"));
                    System.out.println("nombres :"+rs.getString("nombres"));
                    System.out.println("apelidos :"+rs.getString("apellidos"));
                    
                }
                
        
                
            } catch (Exception e) {
                System.out.println("Eror al imprimir la persona Natural"+e.getMessage());
                e.printStackTrace();
            }
        
        
        }
        


    public void EliminarRol(int idRol) {
        String sql = "DELETE FROM roles WHERE idrol = ?";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idRol);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println(rowsAffected > 0 ? "Rol eliminado correctamente." : "Rol con ID " + idRol + " no encontrado.");

        } catch (SQLException ex) {
            System.out.println("Error al eliminar el rol: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void ModificarRol(String nuevoNombre, int idRol) {
        String sql = "UPDATE roles SET nombrerol = ? WHERE idrol = ?";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, idRol);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected > 0 ? "Rol modificado correctamente." : "Rol con ID " + idRol + " no encontrado.");

        } catch (SQLException ex) {
            System.out.println("Error al modificar el rol: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
    
}
