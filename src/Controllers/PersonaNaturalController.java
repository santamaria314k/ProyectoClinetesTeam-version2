
package Controllers;

import Models.PersonaNatural;
import Services.PersonaNaturalService;


public class PersonaNaturalController {
    public PersonaNaturalService personaNaturalServicio;
    //hola
    public PersonaNaturalController(){
        this.personaNaturalServicio = new PersonaNaturalService();
    }
    
    public boolean insertarCliente(PersonaNatural cliente){
        boolean respuesta;
        respuesta = personaNaturalServicio.insertarCliente(cliente);
        return respuesta;
    }
}
