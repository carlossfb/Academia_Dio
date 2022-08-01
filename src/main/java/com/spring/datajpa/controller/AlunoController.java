package com.spring.datajpa.controller;

import com.spring.datajpa.entity.Aluno;
import com.spring.datajpa.entity.AvaliacaoFisica;
import com.spring.datajpa.entity.dto.AlunoDTO;
import com.spring.datajpa.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping("/todos")
    public List<Aluno> BuscarTodosAlunos(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Aluno BuscarAluno(@PathVariable("id") Long id){
        return service.get(id);
    }

    @GetMapping("/excluir/{id}")
    public String DeletarAluno(@PathVariable("id") Long id){
        service.delete(id);
        return "Aluno deletado!";
    }


    @PostMapping("/novo")
    public Aluno CriarAluno(@Valid @RequestBody AlunoDTO cadastro){
        return service.create(cadastro);
    }

    @RequestMapping("/editar/{id}")
    public Aluno EditarAluno(@PathVariable Long id,@RequestBody AlunoDTO editar){

        Aluno atualizado = service.update(id, editar);

        return atualizado;

    }

    @GetMapping("/{id}/exame")
    public List<AvaliacaoFisica> buscarAvaliacoesAluno(@PathVariable("id") Long id){
        return service.getAllAval(id);
    }
}
