package com.example.Agenda.repository;

import com.example.Agenda.dto.DadosCadastroContato;
import com.example.Agenda.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByNomeContaining(String nome);
}