package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MdlCandidato {

    ClsJdbc jdbc;

    public MdlCandidato() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        try {
            String sql = "INSERT INTO tbl_candidatos (id_candidato, nombre, telefono, "
                    + "correo, partido_politico, ciudad_origen, descripcion, mensaje_campania, "
                    + "propuestas, tipo_documento) VALUE (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNumeroDocumento());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getCorreo());
            sentencia.setString(5, candidato.getPartidoPolitico());
            sentencia.setString(6, candidato.getCiudadOrigen());
            sentencia.setString(7, candidato.getDescripcion());
            sentencia.setString(8, candidato.getMensajeCampania());
            sentencia.setString(9, candidato.getPropuestas());
            sentencia.setString(10, candidato.getTipoDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                ClsMensaje mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado el candidato exitosamente");
                return mensaje;
            }

            ClsMensaje mensaje = new ClsMensaje(ClsMensaje.ERROR, "Error");
            return mensaje;

        } catch (SQLException e) {

            ClsMensaje mensaje = new ClsMensaje(ClsMensaje.ERROR, "Error" + e.getSQLState());
            return mensaje;
        }

    }

    public ClsMensaje eliminarCandidato(String id) {

        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_candidatos WHERE id_candidato = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un candidato exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error " + e.getMessage());
            return mensaje;

        }
    }

    public ClsMensaje actualizarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje;

        try {
            String sql = "UPDATE tbl_candidatos SET nombre = ?, telefono = ? ,correo = ? , "
                    + "partido_politico = ?,ciudad_origen = ?  ,"
                    + " descripcion = ? ,mensaje_campania = ? ,propuestas = ?  WHERE id_candidato = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);

            sentencia.setString(1, candidato.getNombre());
            sentencia.setString(2, candidato.getTelefono());
            sentencia.setString(3, candidato.getCorreo());
            sentencia.setString(4, candidato.getPartidoPolitico());
            sentencia.setString(5, candidato.getCiudadOrigen());
            sentencia.setString(6, candidato.getDescripcion());
            sentencia.setString(7, candidato.getMensajeCampania());
            sentencia.setString(8, candidato.getPropuestas());
            sentencia.setString(9, candidato.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();            

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has actualizado el candidato exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (SQLException excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error: " + excepcion.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsCandidato> obtenerCandidatos() {
        try {

            LinkedList<ClsCandidato> listaCandidatos = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_candidatos";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String numeroDocumento = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String partidoPolitico = resultados.getString("partido_politico");
                String ciudadOrigen = resultados.getString("ciudad_origen");
                String descripcion = resultados.getString("descripcion");
                String mensajeCampania = resultados.getString("mensaje_campania");
                String propuestas = resultados.getString("propuestas");
                String tipoDocumento = resultados.getString("tipo_documento");

                ClsCandidato candidato = new ClsCandidato(partidoPolitico, ciudadOrigen,
                        descripcion, mensajeCampania, propuestas, tipoDocumento, numeroDocumento, nombre, telefono, correo);
                listaCandidatos.add(candidato);

            }
            return listaCandidatos;

        } catch (SQLException e) {

            return null;

        }
    }

}
