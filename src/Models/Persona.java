
package Models;

import java.util.ArrayList;
import java.util.Date;


public class Persona {
    private int identificacion;
    private String tipoIdentificacion;
    private String nombre;
    private String telefono;
    private String correo;
    private Date fechaNacimiento;
    private ArrayList <Sector> sector = new ArrayList<>();
    private boolean esAdmin;

    public Persona(int identificacion, String tipoIdentificacion, String nombre, String telefono, String correo, Date fechaNacimiento, boolean esAdmin) {
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.esAdmin = esAdmin;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList <Sector> getSector() {
        return sector;
    }

    public void setSector(ArrayList <Sector> sector) {
        this.sector = sector;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    
    
}
