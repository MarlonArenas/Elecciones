package Controladores;

import Clases.ClsCandidato;
import Clases.ClsMensaje;
import Modelos.MdlCandidato;
import java.util.LinkedList;

public class CtlCandidato {

    //MdlCandidato modelcandidato;
    MdlCandidato modeloCandidato;

    public LinkedList<ClsCandidato> obtenerCandidatos() {
        
        LinkedList<ClsCandidato> listaCandidatos = this.modeloCandidato.obtenerCandidatos();
        return listaCandidatos; 
       
    }
    
    public ClsMensaje eliminarCandidato(String id) {

        ClsMensaje mensaje = this.modeloCandidato.eliminarCandidato(id);

        return mensaje;
    }
    
    public ClsMensaje actualizarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = this.modeloCandidato.actualizarCandidato(candidato);

        return mensaje;
    }

    public CtlCandidato() {
        this.modeloCandidato = new MdlCandidato();
    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = this.modeloCandidato.agregarCandidato(candidato);
        return mensaje;
    }
   
}
