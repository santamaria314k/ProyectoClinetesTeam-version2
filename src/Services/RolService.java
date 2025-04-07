package Services;

import java.sql.*;
import DB.DataBase;
import Models.Rol;
import java.util.ArrayList;
import java.util.List;

public class RolService {

    public void RegistrarRol(Rol rol) {
        String sql = "INSERT INTO roles (nombrerol) VALUES (?)";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rol.getNombrerol());

            int rowsAffected = pstmt.executeUpdate();
            
            System.out.println(rowsAffected > 0 ? "Rol creado exitosamente." : "No se insertó ningún registro.");

        } catch (SQLException ex) {
            System.out.println("Error al crear el rol: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

 
    public List<Rol> obtenerListaRoles() {
    List<Rol> listaRoles = new ArrayList<>();
    String sql = "SELECT * FROM roles";

    try (Connection conn = DataBase.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int id = rs.getInt("idrol");
            String nombre = rs.getString("nombrerol");
            Rol rol = new Rol(id, nombre);
            listaRoles.add(rol);
        }

    } catch (SQLException ex) {
        System.out.println("Error al obtener los roles: " + ex.getMessage());
    }

    return listaRoles;
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
    
    
    
    
    
    
    
    
    
    
    
    
}