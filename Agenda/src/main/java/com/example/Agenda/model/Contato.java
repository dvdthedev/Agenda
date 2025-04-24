package com.example.Agenda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Entity(name = "contato")
@Table(name = "contatos")
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcon")
    private Long idcon;
    @Column(length = 120, nullable = false)
    private String nome;
    @Column(length = 11, nullable = false)
    private String fone;
    private String email;
    @Column(length = 30)
    private String apelido;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(idcon, contato.idcon);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hashCode(idcon);
//    }

    public Contato(String nome, String fone, String email, String apelido) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.apelido = apelido;

    }
}
