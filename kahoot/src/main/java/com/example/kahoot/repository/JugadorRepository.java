package com.example.kahoot.repository;

import com.example.kahoot.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorRepository extends JpaRepository<JugadorRepository, String> {
    List<Jugador> findByJuegoIdOrderByPuntuacionTotalDesc(String juegoId);
    boolean existsByNombreAndJuegoId(String nombre, String juegoId);
}
