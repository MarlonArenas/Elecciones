package Clases;

public class ClsCandidato extends ClsPersona {

    private String partidoPolitico;
    private String ciudadOrigen;
    private String descripcion;
    private String mensajeCampania;
    private String propuestas;

    public ClsCandidato(String partidoPolitico, String ciudadOrigen, String descripcion,
            String mensajeCampania, String propuestas, String tipoDocumento, String numeroDocumento, 
            String nombre, String telefono, String correo) {
        super(tipoDocumento, numeroDocumento, nombre, telefono, correo);
        this.partidoPolitico = partidoPolitico;
        this.ciudadOrigen = ciudadOrigen;
        this.descripcion = descripcion;
        this.mensajeCampania = mensajeCampania;
        this.propuestas = propuestas;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensajeCampania() {
        return mensajeCampania;
    }

    public void setMensajeCampania(String mensajeCampania) {
        this.mensajeCampania = mensajeCampania;
    }

    public String getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(String propuestas) {
        this.propuestas = propuestas;
    }

}
