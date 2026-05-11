package com.example.kahoot.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@Document(collection = "preguntas")
public class Preguntas {
    @Id
    private String id;

    @NotBlank(message = "El enunciado no puede estar vacío")
    private String enunciado;

    @NotEmpty(message = "Debe haber opciones de respuesta")
    private List<String> opciones;

    @NotBlank(message = "Debe indicarse la respuesta correcta")
    private String respuestaCorrecta;

    private String juegoId;
}
