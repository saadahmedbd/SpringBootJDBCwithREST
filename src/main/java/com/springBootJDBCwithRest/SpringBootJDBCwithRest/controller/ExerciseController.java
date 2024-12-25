package com.springBootJDBCwithRest.SpringBootJDBCwithRest.controller;

import com.springBootJDBCwithRest.SpringBootJDBCwithRest.model.Exercise;
import com.springBootJDBCwithRest.SpringBootJDBCwithRest.repository.ExerciseDAO;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/Exercise")
public class ExerciseController {
    public final ExerciseDAO repository;

    public ExerciseController(ExerciseDAO repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Exercise> getAllExercise(){
       return repository.getAllExercise();

    }
    @GetMapping("/{id}")
    public Exercise findById(@PathVariable int id){
        return repository.findById(id);

    }
    @PostMapping("")
    public String addExercise(@RequestBody Exercise exercise){
        repository.addExercise(exercise);
        return "exercise added";
    }
    @PutMapping ("/{id}")
    public String updateExercise(@PathVariable int id, @RequestBody Exercise exercise){
        exercise.setId(id);
        repository.updateExercise(exercise);
        return "update exercise";
    }
    @DeleteMapping("/{id}")
    public String deleteExercise(@PathVariable int id){
        repository.deleteExercise(id);
        return "delete succesful";
    }
}
