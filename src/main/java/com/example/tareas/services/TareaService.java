package com.example.tareas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tareas.models.Tarea;
import com.example.tareas.repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas(){
        return tareaRepository.findAll();
    }

    public Optional<Tarea> getTareaById(String id){
        return tareaRepository.findById(id);
    }

    public Tarea createTask(Tarea task) {
        return tareaRepository.save(task);
    }

    public Tarea updateTask(String id, Tarea taskDetails) {
        Tarea task = tareaRepository.findById(id).orElseThrow();
        task.setTitulo(taskDetails.getTitulo());
        task.setDescripcion(taskDetails.getDescripcion());
        task.setEstado(taskDetails.isEstado());
        task.setFechaCreacion(taskDetails.getFechaCreacion());
        return tareaRepository.save(task);
    }

    public void deleteTask(String id) {
        Tarea task = tareaRepository.findById(id).orElseThrow();
        tareaRepository.delete(task);
    }
}
