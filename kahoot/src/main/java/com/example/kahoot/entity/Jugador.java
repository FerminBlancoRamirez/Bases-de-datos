package com.example.kahoot.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;

@Data
@Document(collection = "jugadores")
public class Jugador {
    @Id
    private String id;

    @NotBlank(message = "El nombre del jugador es obligatorio")
    private String nombre;

    private String juegoId;

    private Integer puntuacionTotal = 0;
}
