
package Models;

public class Rol {
    private int  idrol;
    private String nombrerol;


    public Rol(int idrol, String nombrerol) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }
}
