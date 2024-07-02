package com.example.tareas.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Document(collection = "Tarea")
public class Tarea {
    @Id
    private String id;

    @NotBlank(message = "Titulo es requerido")
    private String titulo;

    @NotBlank(message = "Descripcion es requerido")
    private String descripcion;

    private Date fechaCreacion  = new Date();
    private boolean estado = false;
}
