package Util;

import java.sql.*;

public class Conexion {

    private static final String UBICACION_BD = "ProyectosConstruccion.db";

    String url = "jdbc:sqlite:" + UBICACION_BD;
    Connection conn = null;

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }

    public Conexion() {
        try {
            
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Conexion exitosa");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ResultSet consultarRegistros (String url){
        try {
            PreparedStatement pstm = conn.prepareCall(url);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
   