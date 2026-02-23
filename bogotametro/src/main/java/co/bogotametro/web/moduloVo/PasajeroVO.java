package co.bogotametro.web.modeloVo;

public class PasajeroVO {

    private String pas_nom_pasajero, pas_contrasena_encriptada, pas_telefono, pas_correo, pas_tipo_documento, pas_nro_documento;
    private int pas_id_pasajero;
    private Date pas_fecha_registro;
    private boolean pas_status_pasajero;

    public PasajeroVO(String pas_nom_pasajero, String pas_contrasena_encriptada, String pas_telefono, String pas_correo, String pas_tipo_documento, String pas_nro_documento, int pas_id_pasajero, Date pas_fecha_registro, boolean pas_status_pasajero) {
        this.pas_nom_pasajero = pas_nom_pasajero;
        this.pas_contrasena_encriptada = pas_contrasena_encriptada;
        this.pas_telefono=pas_telefono;
        this.pas_correo=pas_correo;
        this.pas_tipo_documento=pas_tipo_documento;         
        this.pas_nro_documento=pas_nro_documento;
        this.pas_id_pasajero=pas_id_pasajero;
        this.pas_fecha_registro=pas_fecha_registro;
        this.pas_status_pasajero=pas_status_pasajero;
    }

    public String getNom_pasajero() {
        return pas_nom_pasajero;
    }

    public void setNom_pasajero(String pas_nom_pasajero) {
        this.pas_nom_pasajero = pas_nom_pasajero;
    }

    public String getContrasena_encriptada() {
        return pas_contrasena_encriptada;
    }

    public void setContrasena_encriptada(String pas_contrasena_encriptada) {
        this.pas_contrasena_encriptada = pas_contrasena_encriptada;
    }

    public String getTelefono() {
        return pas_telefono;
    }

    public void setTelefono(String pas_telefono) {
        this.pas_telefono = pas_telefono;
    }

    public String getCorreo() {
        return pas_correo;
    }

    public void setCorreo(String pas_correo) {
        this.pas_correo = pas_correo;
    }

    public String getTipo_documento() {
        return pas_tipo_documento;
    }
    public String getNro_documento() {
        return pas_nro_documento;
    }

    public void setNro_documento(String pas_nro_documento) {
        this.pas_nro_documento = pas_nro_documento;
    }

    public int getId_pasajero() {
        return pas_id_pasajero;
    }

    public void setId_pasajero(int pas_id_pasajero) {
        this.pas_id_pasajero = pas_id_pasajero;
    }

    public Date getFecha_registro() {
        return pas_fecha_registro;
    }

    public void setFecha_registro(Date pas_fecha_registro) {
        this.pas_fecha_registro = pas_fecha_registro;
    }

    public boolean isStatus_pasajero() {
        return pas_status_pasajero;
    }

    public void setStatus_pasajero(boolean pas_status_pasajero) {
        this.pas_status_pasajero = pas_status_pasajero;
    }


}
