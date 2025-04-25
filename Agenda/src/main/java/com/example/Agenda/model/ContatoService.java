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

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }



    public Contato adicionar(DadosCadastroContato dados){
    var contato = new Contato(dados.nome(), dados.fone(), dados.email(), dados.apelido());
        return contatoRepository.save(contato);




    }

    public void deletar(Long id) {
         var contato = contatoRepository.findById(id).orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));
         contatoRepository.deleteById(id);
    }
}
