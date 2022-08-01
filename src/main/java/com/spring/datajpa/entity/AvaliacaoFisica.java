package com.spring.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_avaliacao")
public class AvaliacaoFisica {
//-id
//-Aluno**
//-peso
//-altura
//-data_avaliacao
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="peso_atual")
    private double peso;

    @Column(name="altura_atual")
    private double altura;


    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
