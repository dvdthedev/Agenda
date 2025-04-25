package com.example.Agenda.infra;

import java.time.LocalDateTime;

public record DadosErro(String mensagem, int status, LocalDateTime timestamp) {

    public DadosErro(String mensagem, int status){
        this(mensagem, status, LocalDateTime.now());
    }
}
