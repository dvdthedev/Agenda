package com.example.Agenda.dto;

import com.example.Agenda.model.Contato;

import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Email;

public record DadosCadastroContato (
        Long id,
        @NotNull
        String nome,
        @NotNull
        String fone,
        @NotNull @Email
        String email,
        String apelido
) {
        public DadosCadastroContato(Contato contato){
                this(contato.getId(), contato.getNome(), contato.getFone(), contato.getEmail(), contato.getApelido());
        }
}
