package com.Cliniconect.CliniconectAPI.repository;

import com.Cliniconect.CliniconectAPI.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}