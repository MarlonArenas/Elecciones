package Clases;

public class ClsEleccion {
   private String idEleccion;
   private String descripcion;
   private String fechaInicio;
   private String fechaFin;
   private String categoria;
   private String estado;

    public ClsEleccion(String idEleccion, String descripcion, String fechaInicio, String fechaFin, String categoria, String estado) {
        this.idEleccion = idEleccion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.categoria = categoria;
        this.estado = estado;
    }

    public ClsEleccion(String idEleccion, String descripcion, String fechaInicio, String fechaFin, String categoria) {
        this.idEleccion = idEleccion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.categoria = categoria;
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(String idEleccion) {
        this.idEleccion = idEleccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
   
   
   
}
