package com.example.tareas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.tareas.models.Tarea;

@Repository
public interface TareaRepository extends MongoRepository<Tarea, String> {
    
}
