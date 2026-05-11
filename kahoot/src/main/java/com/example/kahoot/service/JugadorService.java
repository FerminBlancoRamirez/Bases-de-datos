package com.example.kahoot.service;

import com.example.kahoot.entity.Juego;
import com.example.kahoot.entity.Jugador;
import com.example.kahoot.repository.JuegoRepository;
import com.example.kahoot.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JugadorService {
    private final JugadorRepository repository;
    private final JuegoRepository juegoRepository;

    public Jugador unirsePartida(String nombre, String codigoUnion) {
        // Buscamos el juego por el código de unión
        Juego juego = juegoRepository.findByCodigoUnion(codigoUnion)
                .orElseThrow(() -> new RuntimeException("Código de juego no válido"));

        // Extra opcional: impedir nombres repetidos en el mismo juego [cite: 90]
        if (repository.existsByNombreAndJuegoId(nombre, juego.getId())) {
            throw new RuntimeException("El nombre ya existe en este juego");
        }

        Jugador nuevoJugador = new Jugador();
        nuevoJugador.setNombre(nombre);
        nuevoJugador.setJuegoId(juego.getId());
        nuevoJugador.setPuntuacionTotal(0);

        return repository.save(nuevoJugador);//me da error y no se porque
    }


    public List<Jugador> obtenerRanking(String juegoId) {
        return repository.findByJuegoIdOrderByPuntuacionTotalDesc(juegoId);
    }
}
