package com.example.Agenda.controllers;

import com.example.Agenda.dto.DadosCadastroContato;
import com.example.Agenda.model.Contato;
import com.example.Agenda.model.ContatoService;
import com.example.Agenda.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return new ResponseEntity<DadosCadastroContato>(new DadosCadastroContato(contatoSalvo), HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosCadastroContato dados){
        var contato = contatoRepository.getReferenceById(dados.id());
        contato.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosCadastroContato(contato));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        contatoService.deletar(id);
        return ResponseEntity.ok("Deletado");
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosCadastroContato> obterContato (@PathVariable Long id){
        Contato contato = contatoRepository.getReferenceById(id);
        return new ResponseEntity<DadosCadastroContato>(new DadosCadastroContato(contato), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<DadosCadastroContato>> listarContatos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var page = contatoRepository.findAll(pageable).map(DadosCadastroContato::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/buscarPorNome", produces = "application/json")
    public ResponseEntity<List<Contato>> getContatoById(@RequestParam(name = "nome") String nome){
        List<Contato> contatos = contatoRepository.findByNomeContaining(nome);
        return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
    }

}



//contato.nome(), contato.fone(), contato.email(), contato.apelido()