
package Controllers;

import Models.Usuario;
import Services.UsuarioService;


public class UsuarioController {
    public UsuarioService servicioUsuario;
    
    public UsuarioController(){
        this.servicioUsuario = new UsuarioService();
    }
    
    public boolean registrarUsuario(Usuario usuario){
        boolean respuesta;
        respuesta = this.servicioUsuario.insertarUsuario(usuario);
        return respuesta;
    }
    
    public boolean validarUsuarioExistente(int identificacion){
        boolean respuesta;
        respuesta = this.servicioUsuario.validarUsuarioExistente(identificacion);
        return respuesta;
    }
}
