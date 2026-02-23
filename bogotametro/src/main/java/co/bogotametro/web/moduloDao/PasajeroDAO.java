package co.bogotametro.web.modeloDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import moduloVo.PasajeroVO;
import util.ConexionDb;
import util.Crud;

public class PasajeroDAO extends ConexionDb implements Crud {
    //1. Declarar variables u objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String pas_nom_pasajero="", pas_contrasena_encriptada="", pas_telefono="", pas_correo="", pas_tipo_documento="", pas_nro_documento="";
    private int pas_id_pasajero=0;
    private Date pas_fecha_registro=null;
    private boolean pas_status_pasajero=false;

    //2. Recibir los datos del VO
    public PasajeroDAO (PasajeroDAO pasDao) {
        super();

        try {
              //3. Conectarnos a la base de datos
    conexion = this.getConexion();

    //4. Traer los datos del VO al DAO
    pas_nom_pasajero=pasVO.getpas_nom_pasajero();
    pas_contrasena_encriptada=pasVO.getpas_contrasena_encriptada();
    pas_telefono=pasVO.getpas_telefono();
    pas_correo=pasVO.getpas_correo();
    pas_tipo_documento=pasVO.getpas_tipo_documento();
    pas_nro_documento=pasVO.getpas_nro_documento();
    pas_id_pasajero=pasVO.getpas_id_pasajero();
    pas_fecha_registro=pasVO.getpas_fecha_registro();
    pas_status_pasajero=pasVO.getpas_status_pasajero();

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }

    public boolean agregarRegistro() {
        try {
            sql="insert into pasajero(pas_nom_pasajero, pas_contrasena, pas_telefono, pas_correo, pas_nro_documento, pas_fecha_registro,pas_status_pasajero) values (?,?,?,?,?,?,?)";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, pas_nom_pasajero);
            puente.setString(2, pas_contrasena_encriptada);
            puente.setString(3, pas_telefono);
            puente.setString(4, pas_correo);
            puente.setString(5, pas_tipo_documento);
            puente.setString(6, pas_nro_documento);
            puente.setDate(7, pas_fecha_registro);
            puente.setBoolean(8, pas_status_pasajero);
            puente.executeUpdate();
            operacion=true;

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                this.closeConexion();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
        return operacion;
}

    public boolean actualizarRegistro() {
        try {
            sql="update pasajero set pas_nom_pasajero=?, pas_contrasena=?, pas_telefono=?, pas_correo=?, pas_nro_documento=?, pas_fecha_registro=?, pas_status_pasajero=? where pas_id_pasajero=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, pas_nom_pasajero);
            puente.setString(2, pas_contrasena_encriptada);
            puente.setString(3, pas_telefono);
            puente.setString(4, pas_correo);
            puente.setString(5, pas_nro_documento);
            puente.setString(6, pas_tipo_documento);
            puente.setDate(7, pas_fecha_registro);
            puente.setBoolean(8, pas_status_pasajero);
            puente.setInt(9, pas_id_pasajero);
            puente.executeUpdate();
            operacion=true;

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                this.closeConexion();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
        return operacion;
    }

    public boolean consultarRegistro() {
        try {
            sql="select * from pasajero where pas_id_pasajero=?";
            puente= conexion.prepareStatement(sql);
            puente.setInt(1, pas_id_pasajero);
            mensajero=puente.executeQuery();
            operacion=true;

            if (mensajero.next()) {
                this.pas_nom_pasajero=mensajero.getString(1);
                this.pas_contrasena_encriptada=mensajero.getString(2);
                this.pas_telefono=mensajero.getString(3);
                this.pas_correo=mensajero.getString(4);
                this.pas_tipo_documento=mensajero.getString(5);
                this.pas_nro_documento=mensajero.getString(6);
                this.pas_fecha_registro=mensajero.getDate(7);
                this.pas_status_pasajero=mensajero.getBoolean(8);
            }
            
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                this.closeConexion();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
        return operacion;
    }

    public boolean eliminarRegistro() {
        try {
            sql="delete from pasajero where pas_id_pasajero=?";
            puente= conexion.prepareStatement(sql);
            puente.setInt(1, pas_id_pasajero);
            puente.executeUpdate();
            operacion=true;
            
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                this.closeConexion();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
        return operacion;
    }

    public boolean iniciarSesion(String pas_tipo_documento, String pas_nro_documento, String pas_contrasena_encriptada) {
        try {
            conexion= this.getConexion();
            sql="select*from pasajero where pas_tipo_documento=? and pas_nro_documento=? and pas_contrasena_encriptada=?";
            puente=conexion.prepareStatement(sql);
            puente.setString(1, pas_tipo_documento.name());
            puente.setString(2, pas_nro_documento);
            puente.setString(3, pas_contrasena_encriptada);
            mensajero= puente.executeQuery();

            if (mensajero.next()) {
                operacion = true;
            }

        }  catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                this.closeconnexion();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
        return operacion;
    }

    public boolean validarEstadoPasajero() {
        try {
            sql="select 1 from pasajero where pas_id_pasajero=? and pas_status_pasajero=true";
            puente= conexion.prepareStatement(sql);
            puente.setInt(1, pas_id_pasajero);
            puente.setInt(2, pas_status_pasajero);
            puente.executeQuery();

            if (mensajero.next()) {      //ÉSTA LÍNEA BUSCA EN LA DB Y SI ENCUENTRA UN REGISTRO DEVUELVE TRUE
                operacion=true;
            }
            
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                this.closeConexion();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
        return operacion;
    }
}