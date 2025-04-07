package Services;
import java.sql.*;
import DB.DataBase;
import Models.Publicacion;
import java.util.ArrayList;
import java.util.List;

public class PublicacionService {
    
    
    
    public void RegistrarPublicacion(Publicacion publicacion) {
        String sql = "INSERT INTO publicaciones (descripcionPublicacion,idUsuarioCrea) VALUES (?,?)";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, publicacion.getDescripcionPublicacion());
            pstmt.setInt(2, publicacion.getIdUsuarioCrea());
            

            int rowsAffected = pstmt.executeUpdate();
            
            System.out.println(rowsAffected > 0 ? "Publicacion creado exitosamente." : "No se insertó ningún registro.");

        } catch (SQLException ex) {
            System.out.println("Error al crear el Publicacion: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

 
    public List<Publicacion> obtenerListaPublicaciones() {
    List<Publicacion> listaPublicaciones = new ArrayList<>();
    String sql = "SELECT * FROM publicaciones";

    try (Connection conn = DataBase.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int id = rs.getInt("idPublicacion");
            String descripcionPublicacion = rs.getString("descripcionPublicacion");
            int idUsuarioCrea = rs.getInt("idUsuarioCrea");
            
            Publicacion publicacion = new Publicacion(id, descripcionPublicacion,idUsuarioCrea);
            listaPublicaciones.add(publicacion);
        }

    } catch (SQLException ex) {
        System.out.println("Error al obtener las publicaciones: " + ex.getMessage());
    }

    return listaPublicaciones;
}
    
    
    



    public void ModificarPublicacion(String nuevadescripcionPublicacion, int idPublicacion) {
        String sql = "UPDATE publicaciones SET descripcionPublicacion = ? WHERE idPublicacion = ?";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevadescripcionPublicacion);
            pstmt.setInt(2, idPublicacion);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected > 0 ? "publicacion modificada correctamente." : "publicacion con ID " + idPublicacion + " no encontrado.");

        } catch (SQLException ex) {
            System.out.println("Error al modificar el Publicacion: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
        public void EliminarPublicacion(int idPublicacion) {
        String sql = "DELETE FROM publicaciones WHERE idPublicacion = ?";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPublicacion);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println(rowsAffected > 0 ? "Publicacion eliminado correctamente." : "Publicacion con ID " + idPublicacion + " no encontrado.");

        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Publicacion: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
