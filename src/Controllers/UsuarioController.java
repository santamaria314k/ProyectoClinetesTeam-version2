
package Controllers;

import Models.Usuario;
import Services.UsuarioService;


public class UsuarioController {
    public UsuarioService servicioUsuario;
    
    public UsuarioController(){
        this.servicioUsuario = new UsuarioService();
    }
    
    public void registrarUsuario(Usuario usuario){
        this.servicioUsuario.insertarUsuario(usuario);
    }
}
