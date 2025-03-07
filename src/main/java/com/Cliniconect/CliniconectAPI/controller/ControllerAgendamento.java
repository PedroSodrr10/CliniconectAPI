package com.Cliniconect.CliniconectAPI.controller;

import com.Cliniconect.CliniconectAPI.entities.Agendamento;
import com.Cliniconect.CliniconectAPI.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/agendamento")
public class ControllerAgendamento {
    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Agendamento agendamento) {
        try {
            return ResponseEntity.status(201).body(service.create(agendamento));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok().body(service.getAll());
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(service.getId(id));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Agendamento agd) {
        try {
            return ResponseEntity.ok().body(service.update(id, agd));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }
}
