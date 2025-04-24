package com.example.Agenda.dto;

import com.example.Agenda.model.Contato;
import org.antlr.v4.runtime.misc.NotNull;

public record DadosCadastroContato (
        Long id,
        @NotNull
        String nome,
        @NotNull
        String fone,
        @NotNull
        String email,
        String apelido
) {

}
