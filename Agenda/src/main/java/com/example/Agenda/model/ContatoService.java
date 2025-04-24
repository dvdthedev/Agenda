package com.example.Agenda.model;

import com.example.Agenda.Expection.ValidacaoException;
import com.example.Agenda.dto.DadosCadastroContato;
import com.example.Agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;



    public void adicionar(DadosCadastroContato dados){

        var contato = new Contato(dados.nome(), dados.fone(), dados.email(), dados.apelido());

        contatoRepository.save(contato);

    }
}
