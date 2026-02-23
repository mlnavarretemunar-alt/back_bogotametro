package co.bogotametro.web.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDb {
    // 1. Declarar variables u objetos

    private String driver, user, password, nameDb, port, urlDb;
    private Connection conexion; 

    
// 2. Asignar valores en el constructor
    public ConexionDb () {
        driver="com.mysql.cj.jdbc.Driver";
        user="root";
        password="";
        nameDb="dbbogotametroapp";
        port="3306";
        urlDb="jdbc:mysql://localhost:3306/dbbogotametroapp";
    }
// 3.Ahora si a conectar
    public Connection getConexion () {

        try{
            Class.forName(driver);
            conexion= DriverManager.getConnection(urlDb,user, password);
            return conexion;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Connection closeConexion() {
        conexion.close();
        conexion=null;
        return conexion;
        }
}


