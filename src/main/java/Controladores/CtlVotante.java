package Controladores;

import Clases.ClsMensaje;
import Clases.ClsVotante;
import Modelos.MdlVotante;
import java.util.LinkedList;

public class CtlVotante {

    MdlVotante modeloVotante;

    public CtlVotante() {
        this.modeloVotante = new MdlVotante();
    }

    public LinkedList<ClsVotante> obtenerVotantes() {

        LinkedList<ClsVotante> listaVotantes = this.modeloVotante.obtenerVotantes();
        
        return listaVotantes;

    }

    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje mensaje = this.modeloVotante.agregarVotante(votante);

        return mensaje;
    }

    public ClsMensaje actualizarVotante(ClsVotante votante) {

        ClsMensaje mensaje = this.modeloVotante.actualizarVotante(votante);

        return mensaje;
    }
    
     public ClsMensaje eliminarVotante(String id) {

        ClsMensaje mensaje = this.modeloVotante.eliminarVotante(id);

        return mensaje;
    }

}
