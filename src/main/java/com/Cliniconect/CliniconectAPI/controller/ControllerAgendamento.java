package com.Cliniconect.CliniconectAPI.controller;

import com.Cliniconect.CliniconectAPI.entities.Agendamento;
import com.Cliniconect.CliniconectAPI.service.AgendamentoService;
import com.Cliniconect.CliniconectAPI.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/agendamento")
public class ControllerAgendamento {
    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento agendamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(agendamento));
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody Agendamento agd){
        agd.setAgdId(id);
        return ResponseEntity.ok().body(service.update(agd));
    }

}
