package org.example;

import java.sql.*;

public class sentencias {
    public static void delete(){
        String sql_delete = "DELETE FROM departamentos" +
                            "WHERE nombre='I.T'";
    }

    public static void insertar(){
        String sql_insert = "INSERT INTO departamentos(id, nombre, localizacion)"+
                "VALUES(NULL,'I.T','MADRID')";
    }

    public static void update(){
        String anterior="DALLAS";
        String nuevo="MARACENA";

        String sql_update= "Update departamentos SET localizacion='"+nuevo+"'" +
                "WHERE localizacion='"+anterior+"'";
    }

    public static void encontrar(){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa",
                    "root", "");

            Statement sentencia = conexion.createStatement();

            String sql_select ="SELECT * FROM departamentos";

            ResultSet resultado=sentencia.executeQuery(sql_select);

//                    sentencia.executeUpdate(sql_insert);

            sentencia.close();
            conexion.close();
        }catch (SQLException sql){
            System.err.println("Error de SQL: " + sql.getMessage());
            throw new RuntimeException("Error de SQL", sql);
        }
    }
}
