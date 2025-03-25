
package Models;

import java.util.Date;


public class PersonaNatural extends Persona{
    private String apellido;
    private String genero;

    public PersonaNatural(String apellido, String genero, int identificacion, String tipoIdentificacion, String nombre, String telefono, String correo, Date fechaNacimiento, boolean esAdmin) {
        super(identificacion, tipoIdentificacion, nombre, telefono, correo, fechaNacimiento, esAdmin);
        this.apellido = apellido;
        this.genero = genero;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
