package com.example.basededatosconectada;
import com.example.basededatosconectada.Repositories.AlumnoRepository;
import com.example.basededatosconectada.models.alumno;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // Usamos la interfaz como tipo de referencia
        AlumnoDAO alumnoDao = new AlumnoDAOImpl();

        // 1. Listar todos
        System.out.println("Listado de alumnos:");
        alumnoDao.obtenerTodos().forEach(System.out::println);

        // 2. Insertar uno nuevo (opcional)
        // Alumno nuevo = new Alumno("Marcos", "García", 22);
        // alumnoDao.guardar(nuevo);

        // Silenciamos logs de conexión
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

        AlumnoRepository repo = new AlumnoRepository();

        System.out.println("=== LISTADO DE ALUMNOS (DESDE REPOSITORIO) ===");

        repo.findAll().forEach(alumno -> {
            System.out.println(alumno);
        });
    }
}
