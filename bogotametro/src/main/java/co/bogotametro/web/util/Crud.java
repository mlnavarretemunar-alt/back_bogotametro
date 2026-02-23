package util;

public interface Crud {

    public abstract boolean agregarRegistro();
    public abstract boolean eliminarRegistro();
    public abstract boolean actualizarRegistro();
    public abstract boolean consultarRegistro();
    public abstract boolean iniciarSesion(String pas_tipo_documento, String pas_nro_documento, String pas_contrasena_encriptada);
    public abstract boolean validarEstadoPasajero();

}