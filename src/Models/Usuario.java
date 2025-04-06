
package Models;


public class Usuario {
    private int idUsuario;
    private String username;
    private String password;
    private PersonaJuridica personaJuridica;
    private PersonaNatural personaNatural;
    private Rol rol;
    private boolean isAdmin;

    public Usuario(int idUsuario, String username, String password, PersonaJuridica personaJuridica, PersonaNatural personaNatural, Rol rol, boolean isAdmin) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.personaJuridica = personaJuridica;
        this.personaNatural = personaNatural;
        this.rol = rol;
        this.isAdmin = isAdmin;
    }

    public Usuario(String username, String password, PersonaJuridica personaJuridica, PersonaNatural personaNatural, Rol rol) {
        this.username = username;
        this.password = password;
        this.personaJuridica = personaJuridica;
        this.personaNatural = personaNatural;
        this.rol = rol;
    }

    public Usuario(String username, String password, PersonaJuridica personaJuridica, Rol rol) {
        this.username = username;
        this.password = password;
        this.personaJuridica = personaJuridica;
        this.rol = rol;
    }

    public Usuario(String username, String password, PersonaNatural personaNatural, Rol rol) {
        this.username = username;
        this.password = password;
        this.personaNatural = personaNatural;
        this.rol = rol;
    }
    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonaJuridica getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public PersonaNatural getPersonaNatural() {
        return personaNatural;
    }

    public void setPersonaNatural(PersonaNatural personaNatural) {
        this.personaNatural = personaNatural;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    
    
}
