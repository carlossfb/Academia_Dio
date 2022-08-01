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
public class Matricula {
//-id
//-plano**
//-data_matricula
// -aluno**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataMatricula;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
    @OneToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
}
