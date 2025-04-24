package com.example.Agenda.controllers;

import com.example.Agenda.dto.DadosCadastroContato;
import com.example.Agenda.model.Contato;
import com.example.Agenda.model.ContatoService;
import com.example.Agenda.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ContatoService contatoService;

    @PostMapping(value = "/", produces = "application/json")
    @Transactional
    public ResponseEntity<DadosCadastroContato> cadastrar(@RequestBody DadosCadastroContato contato){

        Contato contatoSalvo = contatoService.adicionar(contato);

        return new ResponseEntity<DadosCadastroContato>(new DadosCadastroContato(contatoSalvo.getId(),  contatoSalvo.getNome(), contatoSalvo.getFone(), contatoSalvo.getEmail(), contatoSalvo.getApelido()), HttpStatus.CREATED);

    }
}

//contato.nome(), contato.fone(), contato.email(), contato.apelido()