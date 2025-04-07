package Services;
import java.sql.*;
import DB.DataBase;
import Models.PQRS;
import java.util.ArrayList;
import java.util.List;

public class PQRSService {

public void Registrarpqrs(PQRS pqrs) throws SQLException {
    // Obtener el próximo ID disponible
    int nextId = obtenerProximoIdPQRS();
    
    String sql1 = "INSERT INTO pqrs (idpqrs, tipoComentario) VALUES (?, ?)";
    String sql2 = "INSERT INTO pqrs_asignacion (idPQRS, idPersona, comentario) VALUES (?, ?, ?)";
    
    try (Connection conn = DataBase.conectar()) {
        conn.setAutoCommit(false); // Iniciar transacción
        
        // Insertar en tabla pqrs
        try (PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {
            pstmt1.setInt(1, nextId);
            pstmt1.setString(2, pqrs.getTipoComentario());
            pstmt1.executeUpdate();
        }
        
        // Insertar en tabla pqrs_asignacion
        try (PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
            pstmt2.setInt(1, nextId);
            pstmt2.setInt(2, pqrs.getIdPersona());
            pstmt2.setString(3, pqrs.getComentario());
            pstmt2.executeUpdate();
        }
        
        conn.commit(); // Confirmar transacción
    }
}

private int obtenerProximoIdPQRS() throws SQLException {
    String sql = "SELECT MAX(idpqrs) + 1 FROM pqrs";
    try (Connection conn = DataBase.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        return rs.next() ? rs.getInt(1) : 1; // Si no hay registros, empezar con 1
    }
}









public List<PQRS> obtenerListaPQRS() {
    List<PQRS> listaPQRS = new ArrayList<>();
    String sql = "SELECT p.idpqrs, p.tipoComentario, a.comentario, a.idPersona " +
                 "FROM pqrs p " +
                 "JOIN pqrs_asignacion a ON p.idpqrs = a.idPQRS";

    try (Connection conn = DataBase.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int idPQRS = rs.getInt("idpqrs");
            String tipoComentario = rs.getString("tipoComentario");
            String comentario = rs.getString("comentario");
            int idPersona = rs.getInt("idPersona");
            
            PQRS pqrs = new PQRS(idPQRS, tipoComentario, idPQRS, idPersona, comentario);
            pqrs.setIdPQRS(idPQRS);
            pqrs.setTipoComentario(tipoComentario);
            pqrs.setComentario(comentario);
            pqrs.setIdPersona(idPersona);
            
            listaPQRS.add(pqrs);
        }

    } catch (SQLException ex) {
        System.out.println("Error al obtener los PQRS: " + ex.getMessage());
        ex.printStackTrace();
    }

    return listaPQRS;
}





    
    public void ModificarPQRS(int idPQRS, String nuevoTipoComentario, String nuevoComentario, int idPersona) {
    // Iniciamos transacción para modificar ambas tablas
    Connection conn = null;
    try {
        conn = DataBase.conectar();
        conn.setAutoCommit(false); // Desactivamos autocommit
        
        // 1. Actualizar tabla pqrs
        String sqlPQRS = "UPDATE pqrs SET tipoComentario = ? WHERE idpqrs = ?";
        try (PreparedStatement pstmtPQRS = conn.prepareStatement(sqlPQRS)) {
            pstmtPQRS.setString(1, nuevoTipoComentario);
            pstmtPQRS.setInt(2, idPQRS);
            int rowsPQRS = pstmtPQRS.executeUpdate();
            
            if (rowsPQRS == 0) {
                throw new SQLException("PQRS con ID " + idPQRS + " no encontrado");
            }
        }
        
        // 2. Actualizar tabla pqrs_asignacion
        String sqlAsignacion = "UPDATE pqrs_asignacion SET comentario = ?, idPersona = ? WHERE idPQRS = ?";
        try (PreparedStatement pstmtAsignacion = conn.prepareStatement(sqlAsignacion)) {
            pstmtAsignacion.setString(1, nuevoComentario);
            pstmtAsignacion.setInt(2, idPersona);
            pstmtAsignacion.setInt(3, idPQRS);
            pstmtAsignacion.executeUpdate();
        }
        
        conn.commit(); // Confirmamos cambios
        System.out.println("PQRS modificado correctamente.");
        
    } catch (SQLException ex) {
        if (conn != null) {
            try {
                conn.rollback(); // Revertimos en caso de error
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback: " + e.getMessage());
            }
        }
        System.out.println("Error al modificar PQRS: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true); // Restauramos autocommit
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
    
    
    
    public void EliminarPQRS(int idPQRS) {
    // Iniciamos transacción para eliminar de ambas tablas
    Connection conn = null;
    try {
        conn = DataBase.conectar();
        conn.setAutoCommit(false); // Desactivamos autocommit
        
        // 1. Primero eliminamos de pqrs_asignacion (tabla hija)
        String sqlAsignacion = "DELETE FROM pqrs_asignacion WHERE idPQRS = ?";
        try (PreparedStatement pstmtAsignacion = conn.prepareStatement(sqlAsignacion)) {
            pstmtAsignacion.setInt(1, idPQRS);
            pstmtAsignacion.executeUpdate();
        }
        
        // 2. Luego eliminamos de pqrs (tabla padre)
        String sqlPQRS = "DELETE FROM pqrs WHERE idpqrs = ?";
        try (PreparedStatement pstmtPQRS = conn.prepareStatement(sqlPQRS)) {
            pstmtPQRS.setInt(1, idPQRS);
            int rowsAffected = pstmtPQRS.executeUpdate();
            
            if (rowsAffected == 0) {
                throw new SQLException("PQRS con ID " + idPQRS + " no encontrado");
            }
        }
        
        conn.commit(); // Confirmamos cambios
        System.out.println("PQRS eliminado correctamente.");
        
    } catch (SQLException ex) {
        if (conn != null) {
            try {
                conn.rollback(); // Revertimos en caso de error
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback: " + e.getMessage());
            }
        }
        System.out.println("Error al eliminar PQRS: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true); // Restauramos autocommit
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
    
    
    
    
    
    
    
    
}