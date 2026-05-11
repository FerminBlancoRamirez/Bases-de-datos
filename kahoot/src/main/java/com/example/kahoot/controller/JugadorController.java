package com.example.kahoot.controller;


import com.example.kahoot.entity.Jugador;
import com.example.kahoot.service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
public class JugadorController {
    private final JugadorService jugadorService;

    @PostMapping("/unirse")
    public Jugador unirse(@RequestParam String nombre, @RequestParam String codigo) {
        return jugadorService.unirsePartida(nombre, codigo);
    }

    @GetMapping("/ranking/{juegoId}")
    public List<Jugador> verRanking(@PathVariable String juegoId) {
        return jugadorService.obtenerRanking(juegoId);
    }
}
