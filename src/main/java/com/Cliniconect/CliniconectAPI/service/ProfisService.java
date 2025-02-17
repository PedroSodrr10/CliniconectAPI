package com.Cliniconect.CliniconectAPI.service;

import com.Cliniconect.CliniconectAPI.entities.Profissional;
import com.Cliniconect.CliniconectAPI.repository.ProfisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfisService {
    @Autowired
    private ProfisRepository repository;

    public Profissional create(Profissional profis){
        return repository.save(profis);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Profissional getId(Long id){
        Optional<Profissional> profis = repository.findById(id);
        return profis.get();
    }

    public Profissional getByName(String nome) {
        Optional<Profissional> profis = repository.findByNome(nome);
        return profis.orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
    }

    public List<Profissional> getAll(){
        return repository.findAll();
    }

    public Profissional update(Profissional profis){
        return repository.save(profis);
    }
}
