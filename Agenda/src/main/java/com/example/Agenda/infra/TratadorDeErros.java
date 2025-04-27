package com.example.Agenda.infra;

import com.example.Agenda.expection.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DadosErro> tratarErro404(EntityNotFoundException ex){
        var erros = new DadosErro(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DadosErro> tratarErro400(MethodArgumentNotValidException ex){
        var erros = new DadosErro(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<DadosErro> RegraDeNegocio(ValidacaoException ex){
        var erros = new DadosErro(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(erros);
    }


}