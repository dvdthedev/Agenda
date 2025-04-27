package com.example.Agenda.model;

import com.example.Agenda.expection.ValidacaoException;
import com.example.Agenda.dto.DadosCadastroContato;
import com.example.Agenda.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }



    public Contato adicionar(DadosCadastroContato dados){
    var contato = new Contato(dados);
        if(dados.nome() == null || dados.email() == null || dados.fone() == null){
            throw new ValidacaoException("Os campos : nome, email e fone não podem ser nulos");
    }

        return contatoRepository.save(contato);


    }

    public void deletar(Long id) {
        var contato = contatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contato com id " + id + " não encontrado"));
         contatoRepository.deleteById(id);
    }



}
