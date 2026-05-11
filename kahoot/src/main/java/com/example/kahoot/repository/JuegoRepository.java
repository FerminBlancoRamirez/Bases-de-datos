package com.example.kahoot.repository;

import com.example.kahoot.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JuegoRepository extends JpaRepository<Juego, String> {
    Juego findByCodigoUnion(String codigoUnion);
}
