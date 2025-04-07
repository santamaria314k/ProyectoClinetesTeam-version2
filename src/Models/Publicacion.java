
package Models;


public class Publicacion {
    private int idPublicacion;
    private String descripcionPublicacion;
    private int idUsuarioCrea  ;

    public Publicacion(int idPublicacion, String descripcionPublicacion, int idUsuarioCrea) {
        this.idPublicacion = idPublicacion;
        this.descripcionPublicacion = descripcionPublicacion;
        this.idUsuarioCrea  =idUsuarioCrea;
    }
    

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getDescripcionPublicacion() {
        return descripcionPublicacion;
    }
 
    public void setDescripcionPublicacion(String descripcionPublicacion) {
        this.descripcionPublicacion = descripcionPublicacion;
    }

    public int getIdUsuarioCrea() {
        return idUsuarioCrea;
    }

    public void setIdUsuarioCrea(int idUsuarioCrea) {
        this.idUsuarioCrea = idUsuarioCrea;
    }
    
    
    
    
    
}
