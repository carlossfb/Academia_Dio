
package com.spring.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matricula")
public class Plano {
// -id
//-nome
//-descricao
//-preço
//-tipo localdate = data_inicio (LocalDate.now())
//-data_fim = inicial.plusDays(365);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;
    private LocalDate dataInicio = LocalDate.now();
    private LocalDate dataFim = LocalDate.now().plusYears(1);

}