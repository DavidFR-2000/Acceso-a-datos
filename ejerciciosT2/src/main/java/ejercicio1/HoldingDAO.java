package ejercicio1;


import java.sql.*;

public class HoldingDAO {

        private String host;
        private String base_datos;
        private String usuario;
        private String password;


        public HoldingDAO(String host, String base_datos, String usuario, String password) {
            this.host = host;
            this.base_datos = base_datos;
            this.usuario = usuario;
            this.password = password;
        }

        public static Connection establecerConexion(){
            Connection connection = null;

            try {
                // Cargar el controlador JDBC de MySQL (asegúrate de tener el archivo JAR en tu proyecto)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Construir la URL de conexión
                String url = "jdbc:mysql://" + "host" + "/" + "base_Datos";

                // Establecer la conexión a la base de datos
                connection = DriverManager.getConnection(url, "usuario", "contraseña");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return connection;
        }

        public void agregarEmpleado(String nombre,String apellidos,String fecha_nacimiento,String categoria,String email,String contratacion,Double salario,String empresa) {
            // Establece una conexión a la base de datos (debe ser implementado en tu código)
            Connection connection = establecerConexion();

            // Verifica si la conexión se ha establecido correctamente
            if (connection != null) {
                try {
                    // Crea una sentencia SQL para insertar un nuevo empleado en la tabla de empleados
                    String sql = "INSERT INTO empleados (nombre, apellidos, fecha_nacimiento, categoria, email, contratacion, salario, empresa) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    // Prepara la sentencia SQL con los valores proporcionados
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, nombre);
                    statement.setString(2, apellidos);
                    statement.setString(3, fecha_nacimiento);
                    statement.setString(4, categoria);
                    statement.setString(5, email);
                    statement.setString(6, contratacion);
                    statement.setDouble(7, salario);
                    statement.setString(8, empresa);

                    // Ejecuta la sentencia SQL para insertar el empleado en la base de datos
                    statement.executeUpdate();

                    // Cierra la conexión y la sentencia
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Maneja cualquier excepción de SQL aquí
                }
            } else {
                System.out.println("Error");
            }
        }



        public void subirSueldo(String empresa,Double subida){
            Connection connection = establecerConexion();

            if (connection != null){
                try{
                    String sql = "UPDATE empleados SET salario = salario + ? WHERE empresa = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setDouble(1, subida);
                    statement.setString(2,empresa);

                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("Error");
            }

        }

        public void trasladarEmpleado(String empleado,String empresa){
            Connection connection = establecerConexion();

            if (connection !=null){
                try{
                    String sql = "UPDATE empleados SET empresa = ? WHERE nombre =?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, empresa);
                    statement.setString(2, empleado);

                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else {

            }

        }

        public String empleadosEmpresa(String empresa){
            Connection connection = establecerConexion();
            StringBuilder result = new StringBuilder();


            if (connection != null) {
                try {
                    String sql = "SELECT nombre FROM empleados WHERE empresa = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, empresa);

                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()){
                        result.append(resultSet.getString("nombre")).append(", ");
                    }

                    statement.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {

            }
            return result.toString();
        }

        public void crearCoche(String modelo,String fabricante,Double cc,String lanzamiento,Integer año,String empleado){

            Connection connection = establecerConexion();

        }

        public Double costeProyecto(String proyecto){
            return null;
        }

        public String resumenProyectos(){
            return null;
        }

        public Integer empleadosSinCoche(){
            return null;
        }

        public void BorrarProyectosSinEmp(){

        }

        public void BorrarAño(Integer año){

    }

}
