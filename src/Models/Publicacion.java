
package Models;


public class Publicacion {
    private int idoferta;
    private String descripcionOferta;

    public Publicacion(int idoferta, String descripcionOferta) {
        this.idoferta = idoferta;
        this.descripcionOferta = descripcionOferta;
    }
    

    public int getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(int idoferta) {
        this.idoferta = idoferta;
    }

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }
    
    
}
