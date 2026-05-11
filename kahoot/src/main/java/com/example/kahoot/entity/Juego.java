package com.example.kahoot.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "juegos")
public class Juego {
    @Id
    private String id; // Identificador [cite: 20]

    @NotBlank(message = "El nombre del juego es obligatorio")
    private String nombre; // [cite: 21]

    private String codigoUnion; // Código único [cite: 23]

    private Date fechaCreacion; // [cite: 24]
}
