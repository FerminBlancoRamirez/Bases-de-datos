package com.example.kahoot.controller;

import com.example.kahoot.entity.Preguntas;
import com.example.kahoot.service.PreguntasService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PreguntasController {
    private final PreguntasService preguntasService;

    @PostMapping
    public Preguntas crear(@Valid @RequestBody Preguntas pregunta) {
        return preguntasService.guardarPregunta(pregunta);
    }

    @GetMapping("/juego/{juegoId}")
    public List<Preguntas> obtenerPorJuego(@PathVariable String juegoId) {
        return preguntasService.obtenerPorJuego(juegoId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        preguntasService.borrarPregunta(id);
    }
}
