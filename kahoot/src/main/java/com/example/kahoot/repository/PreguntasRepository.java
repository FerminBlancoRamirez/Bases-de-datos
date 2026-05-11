package com.example.kahoot.repository;

import com.example.kahoot.entity.Preguntas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntasRepository extends JpaRepository<Preguntas, String> {
    List<Preguntas> findByJuegoId(String juegoId);
}
