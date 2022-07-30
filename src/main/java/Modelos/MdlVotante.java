package Modelos;

import Clases.ClsVotante;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MdlVotante {

    ClsJdbc jdbc;

    public MdlVotante() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }

    public ClsMensaje agregarVotante(ClsVotante votante) {

        try {
            String sql = "INSERT INTO tbl_votantes VALUE (?,?,?,?,?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNumeroDocumento());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            sentencia.setString(5, votante.getTipoDocumento());
            
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                ClsMensaje mensaje = new ClsMensaje(ClsMensaje.OK, "Se ha registrado exitosamente");
                return mensaje;
            }

            ClsMensaje mensaje = new ClsMensaje(ClsMensaje.ERROR, "Error");
            return mensaje;

        } catch (SQLException e) {

            ClsMensaje mensaje = new ClsMensaje(ClsMensaje.ERROR, "Error" + e.getSQLState());
            return mensaje;
        }

    }

    public LinkedList<ClsVotante> obtenerVotantes() {
        try {

            LinkedList<ClsVotante> listaVotantes = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_votantes";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String numeroDocumento = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String tipoDocumento = resultados.getString("tipo_documento");

                ClsVotante votante = new ClsVotante(tipoDocumento, numeroDocumento, nombre, telefono, correo);

                listaVotantes.add(votante);
            }
            return listaVotantes;

        } catch (SQLException e) {

            return null;
        }
    }
    
    public ClsMensaje actualizarVotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {
            String sql = "UPDATE tbl_votantes SET nombre = ?, correo = ?, telefono = ?, "
                    + " tipoDocumento = ? WHERE id_votante = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            
            sentencia.setString(9, votante.getNumeroDocumento());
            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getCorreo());
            sentencia.setString(3, votante.getTelefono());            
            sentencia.setString(10, votante.getTipoDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has actualizado el cadidato exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
    
    public ClsMensaje eliminarVotante(String id) {

        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_votantes WHERE id_votante = ?";
            
            
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un votante exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
}
