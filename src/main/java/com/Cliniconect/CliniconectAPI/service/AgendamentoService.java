package com.Cliniconect.CliniconectAPI.service;

import com.Cliniconect.CliniconectAPI.entities.Agendamento;
import com.Cliniconect.CliniconectAPI.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository repository;

    public Agendamento create(Agendamento agd){
        return repository.save(agd);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Agendamento getId(Long id){
        Optional<Agendamento> agd = repository.findById(id);
        return agd.get();
    }

    public List<Agendamento> getAll(){
        return repository.findAll();
    }

    public Agendamento update(Agendamento agd){
        return repository.save(agd);
    }
}