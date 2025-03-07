package com.Cliniconect.CliniconectAPI.service;

import com.Cliniconect.CliniconectAPI.entities.Paciente;
import com.Cliniconect.CliniconectAPI.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public Paciente create(Paciente pac){
        if (pac.getPacNome() == null || pac.getPacNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do paciente é obrigatório");
        }
        if (pac.getPacEmail() == null || pac.getPacEmail().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email do paciente é obrigatório");
        }
        if (pac.getPacTelefone() == null || pac.getPacTelefone().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone do paciente é obrigatório");
        }
        return repository.save(pac);
    }

    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        repository.deleteById(id);
    }

    public Paciente getId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
    }

    public List<Paciente> getAll(){
        return repository.findAll();
    }

    public Paciente update(Paciente pac){
        if (!repository.existsById(pac.getPacId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        return repository.save(pac);
    }
}
