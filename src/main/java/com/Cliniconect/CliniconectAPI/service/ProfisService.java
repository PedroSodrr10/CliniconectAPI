package com.Cliniconect.CliniconectAPI.service;

import com.Cliniconect.CliniconectAPI.entities.Profissional;
import com.Cliniconect.CliniconectAPI.repository.ProfisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfisService {
    @Autowired
    private ProfisRepository repository;

    public Profissional create(Profissional profis){
        if (profis.getNome() == null || profis.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do profissional é obrigatório");
        }
        if (profis.getEspecialidade() == null || profis.getEspecialidade().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade do profissional é obrigatória");
        }
        return repository.save(profis);
    }

    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado");
        }
        repository.deleteById(id);
    }

    public Profissional getId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado"));
    }

    public Profissional getByName(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado"));
    }

    public List<Profissional> getAll(){
        return repository.findAll();
    }

    public Profissional update(Profissional profis){
        if (!repository.existsById(profis.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado");
        }
        return repository.save(profis);
    }
}