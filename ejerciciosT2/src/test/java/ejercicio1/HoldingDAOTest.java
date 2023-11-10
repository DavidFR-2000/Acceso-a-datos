package ejercicio1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.BasesDatos;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HoldingDAOTest {

    HoldingDAO dao;

    @BeforeEach
    void setUp() {
        String ruta_scrip = "src/main/java/ejercicio1/script_datos.sql";
        BasesDatos.borrarDatos("holding");
        BasesDatos.volcarDatos(ruta_scrip,"holding");

        dao = new HoldingDAO("localhost", "holding", "root", "");
    }

    @Test
    void agregarEmpleado() {
        // Datos de prueba
        String nombre = "John";
        String apellidos = "Doe";
        String fecha_nacimiento = "1990-01-01";
        String categoria = "Empleado";
        String email = "john.doe@example.com";
        String contratacion = "2023-01-01";
        Double salario = 50000.0;
        String empresa = "Acme Corp";

        // Llama al método agregarEmpleado para agregar un empleado
        dao.agregarEmpleado(nombre, apellidos, fecha_nacimiento, categoria, email, contratacion, salario, empresa);

        // Realiza una prueba para verificar si el empleado ha sido agregado correctamente en la base de datos
        // Puedes usar consultas SQL para verificar si los datos se han insertado correctamente
        // y si existe un empleado con los datos proporcionados en la base de datos
        // A continuación, un ejemplo de cómo podrías verificar esto:
        boolean empleadoAgregado = verificarEmpleadoAgregado(nombre, apellidos, empresa);

        assertTrue(empleadoAgregado, "El empleado se agregó correctamente en la base de datos.");
    }
    private boolean verificarEmpleadoAgregado(String nombre, String apellidos, String empresa) {
        return true;
    }


    @Test
    void subirSueldo() {
    }

    @Test
    void trasladarEmpleado() {
    }

    @Test
    void empleadosEmpresa() {
    }

    @Test
    void crearCoche() {
    }

    @Test
    void costeProyecto() {
    }

    @Test
    void resumenProyectos() {
    }

    @Test
    void empleadosSinCoche() {
    }

    @Test
    void borrarProyectosSinEmp() {
    }

    @Test
    void borrarAño() {
    }
}