import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            Statement sentencia = conexion.createStatement();
            String sql_insert = "INSERT INTO departamentos" +
                    "VALUES(NULL, 'I.T', 'MADRID')";

//            String sql_delete = "DELETE FROM departamentos" +
//                                "WHERE nombre='I.T'";

            String sql_update= "Update departamentos SET localizacion='MOTRIL'"+
                                "WHERE localizacion='NEW YORK'";

            sentencia.executeUpdate(sql_insert);

            sentencia.close();
            conexion.close();
        }catch (SQLException sql){
            throw new RuntimeException("Error de SQL");
        }
    }
}
