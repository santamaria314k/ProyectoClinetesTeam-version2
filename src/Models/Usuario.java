
package Models;


public class Usuario {
    private int idUsuario;
    private String username;
    private String password;
    private Persona persona;
    private Rol rol;
    private boolean isAdmin;

    public Usuario(int idUsuario, String username, String password, Persona persona, Rol rol, boolean isAdmin) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.persona = persona;
        this.rol = rol;
        this.isAdmin = isAdmin;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
