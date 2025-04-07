
import DB.DataBase;
 import java.sql.*; 

import Controllers.RolController;

import Models.Rol;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.x.protobuf.MysqlxPrepare;



//packages
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.text.ParseException;




public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

          Scanner escanear = new Scanner(System.in);
       
       
        RolController rolControl = new RolController();

           try {
     

            System.out.println("Ingrese el id del rol que desea modificar: ");
            int idModificacion = escanear.nextInt();
            escanear.nextLine(); // Consumir nueva línea pendiente

            System.out.println("Ingrese el nuevo nombre del rol: ");
            String nuevoNombre = escanear.nextLine();

            rolControl.ModificarRol(nuevoNombre, idModificacion);
            rolControl.obtenerListaRoles();

            System.out.println("Ingrese el id del rol a eliminar: ");
            int idEliminar = escanear.nextInt();
            rolControl.EliminarRol(idEliminar);
            rolControl.obtenerListaRoles();

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            escanear.nextLine();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            System.out.println("--------//------ROL FIN-------//---------");
            escanear.nextLine();
        }
       
  
         
           
           
       
        
               
                
  
        
        
        
        
        
        
        
        
    }
    
}
