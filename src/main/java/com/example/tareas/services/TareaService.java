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
    private static TareaRepository tarearepository;

    public List<Tarea> getAllTareas(){
        return tarearepository.findAll();
    }

    public Optional<Tarea> getTareaById(String id){
        return tarearepository.findById(id);
    }

    public Tarea createTask(Tarea task) {
        return tarearepository.save(task);
    }

    public Tarea updateTask(String id, Tarea taskDetails) {
        Tarea task = tarearepository.findById(id).orElseThrow();
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return tarearepository.save(task);
    }

    public void deleteTask(String id) {
        Tarea task = tarearepository.findById(id).orElseThrow();
        tarearepository.delete(task);
    }
}
