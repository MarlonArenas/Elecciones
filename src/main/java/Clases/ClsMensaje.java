/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Canabiiz
 */
public class ClsMensaje {
    
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";
    public static final String ADVERTENCIA = "ADVERTENCIA";
    
    private String tipo;
    private String texto;

    public ClsMensaje(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }
    
    public void mostrarMensaje(){
    
     JOptionPane.showMessageDialog(null, this.getTexto());
    
    }
}
