package co.bogotametro.util;

public interface Crud {

    public abstract boolean agregarRegistro();
    public abstract boolean eliminarRegistro();
    public abstract boolean actualizarRegistro();
    public abstract boolean consultarRegistro();

}