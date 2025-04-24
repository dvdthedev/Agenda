package com.example.Agenda.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record DadosCadastroContato (
        @NotNull
        String nome,
        @NotNull
        String fone,
        @NotNull
        String email,
        String apelido
) {
}
