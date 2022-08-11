package com.spring.datajpa.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO{

    @NotEmpty(message = "Nome nao pode ser vazio!")
    @Size(min = 3, max = 50, message= "'{ValidatedValue}' precisa estar entre {min} e {max} caracteres!")
    private String nome;

    @NotEmpty(message = "Email nao pode ser vazio!")
    private String email;

    @NotEmpty(message = "CPF nao pode ser vazio!")
    @CPF(message = "'{ValidatedValue}' CPF invalido")
    private String cpf;

    @Past
    private LocalDate dataNascimento;
    private String celular;
}
