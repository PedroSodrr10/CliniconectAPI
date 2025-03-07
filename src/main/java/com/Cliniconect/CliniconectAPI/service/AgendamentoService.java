package com.Cliniconect.CliniconectAPI.service;

import com.Cliniconect.CliniconectAPI.entities.Agendamento;
import com.Cliniconect.CliniconectAPI.entities.Paciente;
import com.Cliniconect.CliniconectAPI.entities.Profissional;
import com.Cliniconect.CliniconectAPI.repository.AgendamentoRepository;
import com.Cliniconect.CliniconectAPI.repository.PacienteRepository;
import com.Cliniconect.CliniconectAPI.repository.ProfisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProfisRepository profissionalRepository;

    public Agendamento create(Agendamento agd) {
        if (agd.getAgdMotivo() == null || agd.getAgdMotivo().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Motivo do agendamento é obrigatório");
        }
        if (agd.getAgdDataHora() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data e hora do agendamento são obrigatórias");
        }
        if (agd.getAgdDataHora().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data do agendamento não pode estar no passado");
        }

        LocalTime horario = agd.getAgdDataHora().toLocalTime();
        if (horario.isBefore(LocalTime.of(8, 0)) || horario.isAfter(LocalTime.of(18, 0))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O horário do agendamento deve ser entre 08:00 e 18:00");
        }

        Paciente paciente = pacienteRepository.findById(agd.getPaciente().getPacId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

        Profissional profissional = profissionalRepository.findById(agd.getProfissional().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado"));

        agd.setPaciente(paciente);
        agd.setProfissional(profissional);

        return repository.save(agd);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado");
        }
        repository.deleteById(id);
    }

    public Agendamento getId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    public List<Agendamento> getAll() {
        return repository.findAll();
    }

    public Agendamento update(Long id, Agendamento agd) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado");
        }
        agd.setAgdId(id);
        return repository.save(agd);
    }
}