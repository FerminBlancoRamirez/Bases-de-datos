package com.example.kahoot.service;

import com.example.kahoot.entity.Preguntas;
import com.example.kahoot.repository.PreguntasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreguntasService {
    private final PreguntasRepository repository;

    // Requisito: añadir preguntas a un juego [cite: 32]
    public Preguntas guardarPregunta(Preguntas nuevaPregunta) {
        return repository.save(nuevaPregunta);
    }

    // Requisito: borrar preguntas de un juego [cite: 33]
    public void borrarPregunta(String id) {
        repository.deleteById(id);
    }

    public List<Preguntas> obtenerPorJuego(String juegoId) {
        return repository.findByJuegoId(juegoId);
    }
}
