package com.example.kahoot.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "respuestas")
public class Respuesta {
    @Id
    private String id;

    private String jugadorId; // Qué jugador respondió [cite: 45]
    private String preguntaId;
    private String respuestaProporcionada;
    private boolean acertó; // Si acertó o falló [cite: 46]
    private Date fechaHora; // [cite: 47]
}
