
package Models;

import java.util.ArrayList;
import java.util.Date;

public class PersonaJuridica extends Persona{
    private int digitoVerificacion;
    private String descripcionActividad;

    public PersonaJuridica(int digitoVerificacion, String descripcionActividad, int identificacion, String tipoIdentificacion, String nombre, String telefono, String correo, java.sql.Date fechaNacimiento, boolean esAdmin) {
        super(identificacion, tipoIdentificacion, nombre, telefono, correo, fechaNacimiento, esAdmin);
        this.digitoVerificacion = digitoVerificacion;
        this.descripcionActividad = descripcionActividad;
    }

    public int getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(int digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }
    
    
}
