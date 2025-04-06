
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
    
    public void ingresarPersonaSector (int usuario, int idSector){
        this.servicioSector.ingresarPersonaSector(usuario, idSector);
    }
}
