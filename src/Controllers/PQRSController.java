package Controllers;

import Models.PQRS;
import Services.PQRSService;
import java.util.List;
import java.sql.SQLException;

public class PQRSController {
    
    private PQRSService pqrsService;

    public PQRSController() {
        this.pqrsService = new PQRSService();
    }

public void registrarPQRS(PQRS pqrs) throws SQLException {
    pqrsService.Registrarpqrs(pqrs);
}

    public List<PQRS> obtenerListaPQRS() {
        return pqrsService.obtenerListaPQRS();
    }

    public void modificarPQRS(int idPQRS, String nuevoTipoComentario, String nuevoComentario, int idPersona) {
        pqrsService.ModificarPQRS(idPQRS, nuevoTipoComentario, nuevoComentario, idPersona);
    }

    public void eliminarPQRS(int idPQRS) {
        pqrsService.EliminarPQRS(idPQRS);
    }
}