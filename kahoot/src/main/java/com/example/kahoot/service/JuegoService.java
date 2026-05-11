package com.example.kahoot.service;

import com.example.kahoot.entity.Juego;
import com.example.kahoot.repository.JuegoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class JuegoService {
    private final JuegoRepository repository;

    public List<Juego> obtenerTodos() {
        return repository.findAll();
    }

    public Juego crearJuego(Juego nuevoJuego) {
        // Requisito: cada juego tiene un código único de unión
        if (nuevoJuego.getCodigoUnion() == null) {
            nuevoJuego.setCodigoUnion(java.util.UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        }
        return repository.save(nuevoJuego);
    }

    public void borrarJuego(String id) {
        repository.deleteById(id);
    }
}
