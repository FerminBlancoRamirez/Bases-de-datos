package com.example.basededatosconectada;

import com.example.basededatosconectada.models.alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoDAO {
    List<alumno> obtenerTodos();
    Optional<alumno> obtenerPorId(String id);
    void guardar(alumno alumno);
    void eliminar(String id);
}
