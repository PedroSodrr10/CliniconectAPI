package com.Cliniconect.CliniconectAPI.controller;

import com.Cliniconect.CliniconectAPI.entities.Paciente;
import com.Cliniconect.CliniconectAPI.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping( value = "/paciente")
public class ControllerPac {
    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Paciente> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente pac){
        pac.setPacId(id);
        return ResponseEntity.ok().body(service.update(pac));
    }

}
