package com.example.kahoot.controller;

import com.example.kahoot.entity.Juego;
import com.example.kahoot.service.JuegoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
@RequiredArgsConstructor
public class JuegoController {
    private final JuegoService juegoService;

    @GetMapping
    public List<Juego> listar() {
        return juegoService.obtenerTodos();
    }

    @PostMapping
    public Juego crear(@Valid @RequestBody Juego juego) {
        return juegoService.crearJuego(juego);
    }
}
