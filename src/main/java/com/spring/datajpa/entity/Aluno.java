package com.spring.datajpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_Aluno")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"} )
public class Aluno {
//-id
//-nome
//-email
//-cpf
//-data_nasc
//-celular

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Column(unique = true)
    private String cpf;
    private LocalDate dataNascimento;
    private String celular;
    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AvaliacaoFisica> avaliacaoFisica = new ArrayList<>();

}
