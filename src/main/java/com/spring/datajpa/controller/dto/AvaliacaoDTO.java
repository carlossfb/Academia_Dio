package com.spring.datajpa.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvaliacaoDTO {

    private Long alunoId;

    @NotEmpty(message = "O peso nao deve estar vazio!")
    private double peso;

    @NotEmpty(message = "A altura nao deve estar vazia!")
    private double altura;
}
