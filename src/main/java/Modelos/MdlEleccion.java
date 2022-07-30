package Modelos;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class MdlEleccion {

    ClsJdbc jdbc;

    public MdlEleccion() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }

    public ClsMensaje agregarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_elecciones VALUES (?, ?, ?, ?, ?, NOW(),"
                    + " 'abierta')";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, eleccion.getIdEleccion().substring(0, 9));
            sentencia.setString(2, eleccion.getDescripcion());
            sentencia.setString(3, eleccion.getCategoria());
            sentencia.setString(4, eleccion.getFechaInicio());
            sentencia.setString(5, eleccion.getFechaFin());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado una elección"
                        + " exitosamente");

                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");

            return mensaje;

        } catch (SQLException excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error: "
                    + excepcion.getMessage());

            return mensaje;
        }

    }

    public ClsMensaje asociarCandidato(String idCandidato, String idEleccion) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_candidatos_x_eleccion VALUES (?, ?, NOW())";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idCandidato);
            sentencia.setString(2, idEleccion);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has asociado un candidato");

                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrid un error");

            return mensaje;

        } catch (SQLException excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error: "
                    + excepcion.getMessage());

            return mensaje;
        }

    }

    public LinkedList<ClsEleccion> obtenerElecciones() {

        try {

            LinkedList<ClsEleccion> lista = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_elecciones";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String idEleccion = resultados.getString("id_eleccion");
                String descripcion = resultados.getString("descripcion");
                String categoria = resultados.getString("categoria");
                String fechaInicio = resultados.getString("fecha_ini");
                String fechaFin = resultados.getString("fecha_fin");
                String estado = resultados.getString("estado");

                ClsEleccion eleccion = new ClsEleccion(idEleccion, descripcion,
                        fechaInicio, fechaFin, categoria);

                eleccion.setEstado(estado);

                lista.add(eleccion);
            }

            return lista;

        } catch (SQLException e) {

            return null;
        }

    }

    public LinkedList<ClsCandidato> obtenerCandidatosEleccion(String idEleccion) {

        try {

            LinkedList<ClsCandidato> lista = new LinkedList<>();

            String consulta = "SELECT tc.* FROM tbl_candidatos_x_eleccion te,"
                    + " tbl_candidatos tc WHERE te.id_eleccion = ? "
                    + "AND te.id_candidato = tc.id_candidato";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString(1, idEleccion);
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
                        descripcion, mensajeCampania, propuestas, tipoDocumento,
                        numeroDocumento, nombre, telefono, correo);
                lista.add(candidato);
            }

            return lista;

        } catch (SQLException e) {

            return null;
        }

    }

    public ClsMensaje eliminarEleccion(String id) {

        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_elecciones WHERE id_eleccion = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado una eleccion exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error " + e.getMessage());
            return mensaje;

        }
    }

    public boolean verificarCandidatosAsociadoas(String id) {        
        
        try {
            String consulta = "SELECT id_eleccion FROM tbl_candidatos_x_eleccion";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString(1, id);
            ResultSet resultados = sentencia.executeQuery();
            
            if (resultados.next())
                System.out.println(resultados);           
                                            

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }
        return true;    //pendiente arreglar logica

    }

}
