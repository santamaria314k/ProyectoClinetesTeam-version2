
package Services;

import DB.DataBase;
import Models.Sector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SectorService {
    public List<Sector> obtenerSectores(){
        List<Sector> sectores = new ArrayList <>();
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "SELECT idSector, descripcionSector FROM sectores";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    int idSector = rs.getInt("idSector");
                    String descripcionSector = rs.getString("descripcionSector");
                    System.out.println(descripcionSector);
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                DataBase.Desconectar(conn);
            } 
        }
        return sectores;
    }
    
    public boolean ingresarPersonaSector(int usuario, int idSector){
        boolean respuesta = false;
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
              String sql = "INSERT INTO persona_sector (idPersona, idSector) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, usuario);
                pstmt.setInt(2, idSector);
                pstmt.executeUpdate();
                System.out.println("Sectores de la empresa registrados exitosamente");
                respuesta = true;
            } catch(SQLException ex){
                System.out.println("Error al registrar la empresa: " + ex.getMessage());
                ex.printStackTrace();
                respuesta = false;
            } finally{
                DataBase.Desconectar(conn);
            }
        }
        return respuesta;
    }
}
