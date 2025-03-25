
package Models;


public class PQRS {
    private int idPQRS;
    private String tipoComentario;

    public PQRS(int idPQRS, String tipoComentario) {
        this.idPQRS = idPQRS;
        this.tipoComentario = tipoComentario;
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
    
    
    
}
