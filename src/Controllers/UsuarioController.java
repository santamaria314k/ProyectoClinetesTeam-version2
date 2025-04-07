package Controllers;

import Models.Usuario;
import Services.UsuarioService;

public class UsuarioController {
    private UsuarioService servicioUsuario;

    public UsuarioController() {
        this.servicioUsuario = new UsuarioService();
    }

    public boolean registrarUsuario(Usuario usuario) {
        return this.servicioUsuario.insertarUsuario(usuario);
    }

    public boolean validarUsuarioExistente(int identificacion) {
        return this.servicioUsuario.validarUsuarioExistente(identificacion);
    }

    public Usuario login(String username, String password) {
        return this.servicioUsuario.login(username, password);
    }

}
