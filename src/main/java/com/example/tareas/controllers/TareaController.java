package com.example.tareas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tareas.models.Tarea;
import com.example.tareas.repository.TareaRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    public List<Tarea> getAllTasks() {
        return tareaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable String id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isPresent()) {
            return ResponseEntity.ok(tarea.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable String id, @RequestBody Tarea tareaDetails) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isPresent()) {
            Tarea updatedTarea = tarea.get();
            updatedTarea.setTitle(tareaDetails.getTitle());
            updatedTarea.setDescription(tareaDetails.getDescription());
            updatedTarea.setCompleted(tareaDetails.isCompleted());
            tareaRepository.save(updatedTarea);
            return ResponseEntity.ok(updatedTarea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable String id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isPresent()) {
            tareaRepository.delete(tarea.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
