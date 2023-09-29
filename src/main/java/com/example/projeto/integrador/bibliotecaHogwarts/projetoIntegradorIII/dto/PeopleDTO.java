package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.People;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.User;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.UserType;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {
    private Integer idade;
    private String nome;
    private String CPF;
    private String endereco;
    private String celular;
    private UserType userType;
    public Pessoa toORM() {
        return new Pessoa(nome,idade,CPF,endereco,celular,userType);
    }
}
