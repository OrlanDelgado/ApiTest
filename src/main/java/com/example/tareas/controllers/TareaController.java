package com.example.tareas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tareas.models.Tarea;
import com.example.tareas.repository.TareaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        try {
            List<Tarea> tareas = tareaRepository.findAll();
            return ResponseEntity.ok(tareas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving tasks: " + e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getTareaById(@PathVariable String id) {
        try {
            Optional<Tarea> tarea = tareaRepository.findById(id);
            if (tarea.isPresent()) {
                return ResponseEntity.ok(tarea.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving task by ID: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createTarea(@RequestBody Tarea tarea) {
        try {
            Tarea newTarea = tareaRepository.save(tarea);
            return ResponseEntity.ok(newTarea);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating task: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTarea(@PathVariable String id, @RequestBody Tarea tareaDetails) {
        try {
            Optional<Tarea> tarea = tareaRepository.findById(id);
            if (tarea.isPresent()) {
                Tarea updatedTarea = tarea.get();
                updatedTarea.setTitulo(tareaDetails.getTitulo());
                updatedTarea.setDescripcion(tareaDetails.getDescripcion());
                updatedTarea.setEstado(tareaDetails.isEstado());
                updatedTarea.setFechaCreacion(tareaDetails.getFechaCreacion());
                tareaRepository.save(updatedTarea);
                return ResponseEntity.ok(updatedTarea);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating task: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarea(@PathVariable String id) {
        try {
            Optional<Tarea> tarea = tareaRepository.findById(id);
            if (tarea.isPresent()) {
                tareaRepository.delete(tarea.get());
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting task: " + e.getMessage());
        }
    }
}
