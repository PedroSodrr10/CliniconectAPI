package com.Cliniconect.CliniconectAPI.service;

import com.Cliniconect.CliniconectAPI.entities.Paciente;
import com.Cliniconect.CliniconectAPI.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public Paciente create(Paciente pac){
        return repository.save(pac);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Paciente getId(Long id){
        Optional<Paciente> pac = repository.findById(id);
        return pac.get();
    }

    public List<Paciente> getAll(){
        return repository.findAll();
    }

    public Paciente update(Paciente pac){
        return repository.save(pac);
    }

}
