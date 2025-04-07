package Controllers;

import Models.Rol;
import Services.RolService;
import java.util.List;

public class RolController {
    private RolService rolService;

    public RolController() {
        this.rolService = new RolService();
    }

    public void RegistrarRol(Rol rol) {
        rolService.RegistrarRol(rol);
    }

    public List<Rol> obtenerListaRoles() {
    return rolService.obtenerListaRoles();
    }

    public void EliminarRol(int idRol) {
        rolService.EliminarRol(idRol);
    }

    public void ModificarRol(String nuevoNombre, int idRol) {
        rolService.ModificarRol(nuevoNombre, idRol);
    }
}