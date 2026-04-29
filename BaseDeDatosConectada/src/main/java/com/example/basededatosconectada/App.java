package com.example.basededatosconectada;

import com.example.basededatosconectada.models.alumno;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class App implements CommandLineRunner {

    // Inyectamos la interfaz (Spring buscará AlumnoDAOImpl automáticamente)
    private final AlumnoDAO alumnoDAO;

    public App(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=== INICIANDO APLICACIÓN DE GESTIÓN DE ALUMNOS ===\n");

        // 1. Insertar un alumno de prueba para ver que funciona
        alumno nuevo = new alumno("Carlos", "Sánchez", 25);
        alumnoDAO.guardar(nuevo);
        System.out.println(">>> Alumno guardado correctamente.");

        // 2. Listar todos los alumnos
        System.out.println("\n--- LISTADO ACTUAL EN LA BASE DE DATOS ---");
        List<alumno> lista = alumnoDAO.obtenerTodos();

        if (lista.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            lista.forEach(a -> System.out.println(" - " + a));
        }

        System.out.println("\n=== TAREA FINALIZADA ===");
    }
}