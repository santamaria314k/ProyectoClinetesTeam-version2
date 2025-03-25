
package Models;


public class Sector {
    private int id;
    private String descripcionSector;

    public Sector(int id, String descripcionSector) {
        this.id = id;
        this.descripcionSector = descripcionSector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdsector() {
        return id;
    }

    public void getIdsector(int id) {
        this.id = id;
    }
    
    public String getDescripcionSector() {
        return descripcionSector;
    }

    public void setDescripcionSector(String descripcionSector) {
        this.descripcionSector = descripcionSector;
    }
    
    
}
