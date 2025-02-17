package com.Cliniconect.CliniconectAPI.repository;

import com.Cliniconect.CliniconectAPI.entities.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfisRepository extends JpaRepository<Profissional, Long> {

    Optional<Profissional> findByNome(String nome);
}
