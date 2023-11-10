package preliminares;

import java.sql.*;

public class EmpresaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;


    public EmpresaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }


    public void ejercicio1(String nombre,String localizacion) {
        Connection conexion = null;
        Statement sentencia_select = null;
        ResultSet resultado = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa",
                    this.usuario, //usuario de la BD
                    this.password); //contraseña
            sentencia_select = conexion.createStatement();
            String sql = "SELECT id " +
                    "FROM departamentos " +
                    "WHERE nombre='" + nombre + "'";
            resultado = sentencia_select.executeQuery(sql);
            if (resultado.next()) {
                throw new RuntimeException("El departamento existe");
            }
            String sql_insert = "INSERT INTO DEPARTAMENTOS " +
                    "(nombre,localizacion) VALUES " +
                    "('" + nombre + "','" + localizacion + "')";
            int filas_afectadas = sentencia_select.executeUpdate(sql_insert);
            if (filas_afectadas > 0) {
                System.out.println("Departamento insertado con éxito");
            }
        } catch (SQLException sql) {
            try {
                if (resultado != null) resultado.close(); //Cerrar ResultSet
                if (sentencia_select != null) sentencia_select.close(); // Cerrar Statement
                if (conexion != null) conexion.close(); // Cerrar conexión
            } catch (Exception e) {
                throw new RuntimeException("Fallo al cerrar");
            }
        }
    }

    public void ejercicio2(String nombre_dep) {

    }

    public void ejercicio3(String apellido_emp) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();
            //comprobar si no existe
            String existe = "SELECT * FROM empleados WHERE apellido = '" + apellido_emp + "'";
            resultSet = statement.executeQuery(existe);
            //si existe mostrar mensaje
            if (!resultSet.next()) {
                System.out.println("Empleado no existe.");
                return;
            }
            //crear consulta
            String deleteSql = "DELETE FROM empleados WHERE apellido = '" + apellido_emp + "'";
            //ejecutar consulta
            statement.executeUpdate(deleteSql);
            //si se inserta mostrar mensaje
            System.out.println("Empleado borrado");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
    }

    public void ejercicio4(Double porcentaje) {

    }

    public void ejercicio5(Double cantidad,String cargo) {

    }

    public String ejercicio6(Double limite) {
        return null;
    }

    public String ejercicio7(Double limite,String cargo) {
        return null;
    }

    public Double ejercicio8() {
        return null;
    }

    public String ejercicio9(Integer año) {
        String res = "";
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSelect = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" +
                            this.host + "/" +
                            this.base_datos,
                    this.usuario, //usuario de la BD
                    this.password); //contraseña
            statement = conexion.createStatement();
            String sql_select = "SELECT apellido FROM empleados " +
                    "WHERE YEAR(fecha_alta) < "+ año;
            resultSelect = statement.executeQuery(sql_select);
            while(resultSelect.next()){
                res += resultSelect.getString(1) + "\n";
            }
            resultSelect.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(resultSelect != null) resultSelect.close();
                if(statement != null) statement.close();
                if( conexion != null ) conexion.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return res;
    }

    public Double ejercicio10(String cargo) {
        return null;
    }

    public String ejercicio11() {
        return null;
    }

    public String ejercicio12() {
        return null;
    }

    public String ejercicio13() {
        return null;
    }

    public  String ejercicio14() {
        String res = "";
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSelect = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" +
                            this.host + "/" +
                            this.base_datos,
                    this.usuario, //usuario de la BD
                    this.password); //contraseña
            statement = conexion.createStatement();
            String sql_select = "SELECT apellido FROM empleados " +
                    "ORDER BY salario DESC LIMIT 1";
            resultSelect = statement.executeQuery(sql_select);
            while(resultSelect.next()){
                res += resultSelect.getString(1) + "\n";
            }
            resultSelect.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(resultSelect != null) resultSelect.close();
                if(statement != null) statement.close();
                if( conexion != null ) conexion.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return res;
    }

    public  String ejercicio15() {
        return null;
    }

    public  String ejercicio16(String apellido_emp) {
        return null;
    }

    public String ejercicio17(String nombre_dep) {
        return null;
    }

    public String ejercicio18(String apellido_emp) {
        return null;
    }

    public String ejercicio19() {
        return null;
    }


    public String ejercicio20() {
        return null;
    }
    public void ejercicio21(String apellido_emp,String cargo, Double salario,Double comision,String nombre_dep) {

    }



    public void metodoPlantilla() {
//                Connection conexion = null;
//                Statement statement = null;
//                ResultSet resultSet = null;
//
//                try {
//                    Connection conexion = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.base_datos,
//                            this.usuario, //usuario de la BD
//                            this.password); //contraseña
//
//

//
//            String sql_select = "SELECT * FROM empleados "
//                    + "WHERE ocupacion ='" + cargo + "'AND fecha_alta='" + fecha + "'";
//            Statement sentencia_select = conexion.createStatement();
//
//            ResultSet resul = sentencia_select.executeQuery(sql_select);
//
//            while (resul.next()) {
//
//            }
//            resul.close(); //Cerrar ResultSet
//            sentencia_select.close(); // Cerrar Statement
//            conexion.close(); // Cerrar conexión
//
//            String sql_insert = "INSERT INTO departamentos VALUES ('" + nombre + "', '" + localizacion + "')";
//            System.out.println(sql_insert);
//            Statement sentencia_insert = conexion.createStatement();
//            filas = sentencia_insert.executeUpdate(sql_insert);
//            System.out.println("Filas afectadas: " + filas);
//            sentencia_insert.close(); // Cerrar Statement
//            conexion.close(); // Cerrar conexion
//
//            resul.close(); //Cerrar ResultSet
//            sentencia_prepa_select.close(); // Cerrar Statement
//            conexion.close(); // Cerrar conexión
//        } catch (SQLException exception) {
//            System.out.println("Error de SQL\n"+exception.getMessage());
//            exception.printStackTrace();
//        } finally {
//            if (resultSet != null) resultSet.close();
//            if (statement != null) statement.close();
//            if (conexion != null) conexion.close();
//        }
    }


}
