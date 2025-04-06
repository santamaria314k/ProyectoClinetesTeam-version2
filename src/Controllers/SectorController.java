
package Controllers;

import Models.Sector;
import Services.SectorService;
import java.util.List;


public class SectorController {
    public SectorService servicioSector;
    
    public SectorController(){
        this.servicioSector = new SectorService();
    }
    
    public List<Sector> obtenerSectores(){
        return servicioSector.obtenerSectores();
    }
    
    public boolean ingresarPersonaSector (int usuario, int idSector){
        boolean respuesta;
        respuesta = this.servicioSector.ingresarPersonaSector(usuario, idSector);
        return respuesta;
    }
}
