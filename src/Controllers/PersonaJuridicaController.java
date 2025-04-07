
package Controllers;

import Models.PersonaJuridica;
import Services.PersonaJuridicaService;


public class PersonaJuridicaController {
    public PersonaJuridicaService personaJuridicaServicio;
    
    public PersonaJuridicaController(){
        this.personaJuridicaServicio = new PersonaJuridicaService();
    }
    
    public boolean insertarEmpresa(PersonaJuridica empresa){
        boolean respuesta;
        respuesta = personaJuridicaServicio.insertarEmpresa(empresa);
        return respuesta;
    }
}
