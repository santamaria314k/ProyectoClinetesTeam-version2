
package Models;


public class PQRS {
    private int idpqrs ;
    private String tipoComentario;
    //--------------------------//-------------
    private int idPQRS;
    private int idPersona;
    private String comentario;
            

    public PQRS(int idpqrs, String tipoComentario  ,int idPQRS ,int idPersona,String comentario) {
        this.idpqrs = idpqrs;
        this.tipoComentario = tipoComentario;
        
        this.idPQRS=idPQRS;
        this.idPersona=idPersona;
        this.comentario=comentario;
    }

    public int getIdPQRS() {
        return idPQRS;
    }

    public void setIdPQRS(int idPQRS) {
        this.idPQRS = idPQRS;
    }

    public String getTipoComentario() {
        return tipoComentario;
    }

    public void setTipoComentario(String tipoComentario) {
        this.tipoComentario = tipoComentario;
    }

    public int getIdpqrs() {
        return idpqrs;
    }

    public void setIdpqrs(int idpqrs) {
        this.idpqrs = idpqrs;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
    
    
    
    
    
}
