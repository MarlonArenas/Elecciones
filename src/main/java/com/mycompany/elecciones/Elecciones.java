package com.mycompany.elecciones;

import Clases.ClsJdbc;

public class Elecciones {

    public static void main(String[] args) {
        ClsJdbc jdbc = new ClsJdbc();
        jdbc.CrearConexion();
    }
}
