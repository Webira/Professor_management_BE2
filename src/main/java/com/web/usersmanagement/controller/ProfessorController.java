package com.web.usersmanagement.controller;

import com.web.usersmanagement.model.Professor;

import com.web.usersmanagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProfessorController {

    @Autowired
    private final ProfessorService professorService;
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }
    @PostMapping("/professor")
    Professor newProfessor(@RequestBody Professor professor){
        return professorService.creatProfessor(professor);
    }
    /*public ResponseEntity<Professor> newProfessor(@RequestBody Professor professor) {
        Professor persistedProfessor = professorService.createProfessor(professor);
        return new ResponseEntity<>(persistedProfessor, HttpStatus.CREATED);
    }*/
    //@GetMapping("/{id}")
    @GetMapping("/professor/{id}")
    public Professor findProfessorById(@PathVariable Long id){
        return professorService.getProfessorById(id);
    }
    /*public ResponseEntity<Professor> getProfById (@PathVariable Long id) {
        return ResponseEntity.ok(professorService.getProfessorById(id));
    }*/

    @GetMapping("/professors")
    List<Professor> getAllProf(){
        return professorService.getAllProfessors();
    }
    /*public ResponseEntity<List<Professor>> getProfessors () {
        return ResponseEntity.ok(professorService.getAllProfessors());
    }*/

    /*public ResponseEntity<List<Professor>> findAllProfessors() {
        return new ResponseEntity<>(professorService.getAllProfessors(), HttpStatus.CREATED);
    }*/

    @PutMapping("/prof/update/{id}")
    Professor updateProf(@RequestBody Professor newProfessor, @PathVariable Long id) {
        return professorService.updateProfessor(id, newProfessor);
    }
    /*public ResponseEntity<Professor> updateProf(@PathVariable("id") Long id, @RequestBody Professor professor) {
        Professor persistedEmp = professorService.updateProfessor(id, professor);
        return new ResponseEntity<>(persistedEmp, HttpStatus.OK);
    }*/
    @DeleteMapping("/prof/delete/{id}")
    public String deleteProf(@PathVariable Long id){
        return professorService.deleteProfessor(id);
    }
}
