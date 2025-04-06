
package Controllers;

import Models.PersonaJuridica;
import Services.PersonaJuridicaService;


public class PersonaJuridicaController {
    public PersonaJuridicaService personaJuridicaServicio;
    
    public PersonaJuridicaController(){
        this.personaJuridicaServicio = new PersonaJuridicaService();
    }
    
    public void insertarEmpresa(PersonaJuridica empresa){
        personaJuridicaServicio.insertarEmpresa(empresa);
    }
}
