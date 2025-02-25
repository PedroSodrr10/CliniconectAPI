package com.Cliniconect.CliniconectAPI.controller;

import com.Cliniconect.CliniconectAPI.entities.Profissional;
import com.Cliniconect.CliniconectAPI.service.ProfisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping( value = "/profissional")
public class Controller {
    @Autowired
    private ProfisService service;

    @PostMapping
    public ResponseEntity<Profissional> create(@RequestBody Profissional profis){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(profis));
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profissional> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Profissional> update(@PathVariable Long id, @RequestBody Profissional profis){
        profis.setId(id);
        return ResponseEntity.ok().body(service.update(profis));
    }

    @GetMapping(value = "/buscapornome")
    public ResponseEntity<Profissional> getNome(@RequestParam String nome){
        return ResponseEntity.ok().body(service.getByName(nome));
    }

}
