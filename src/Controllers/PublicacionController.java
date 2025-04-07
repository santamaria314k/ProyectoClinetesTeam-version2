package Controllers;

import Models.Publicacion;
import Services.PublicacionService;
import java.util.List;

public class PublicacionController {

    private PublicacionService publicacionService;

    public PublicacionController(){
        this.publicacionService = new PublicacionService();
    }

    public void RegistrarPublicacion(Publicacion publicacion) {
        publicacionService.RegistrarPublicacion(publicacion);
    }

    public List<Publicacion> obtenerListaPublicaciones() {
        return publicacionService.obtenerListaPublicaciones();
    }

    public void ModificarPublicacion(String nuevadescripcionPublicacion , int idPublicacion) {
        publicacionService.ModificarPublicacion(nuevadescripcionPublicacion, idPublicacion);
    }

    public void EliminarPublicacion(int idPublicacion) {
        publicacionService.EliminarPublicacion(idPublicacion);
    }


}