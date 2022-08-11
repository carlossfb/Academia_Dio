package com.spring.datajpa.controller;

import com.spring.datajpa.entity.Aluno;
import com.spring.datajpa.entity.AvaliacaoFisica;
import com.spring.datajpa.controller.dto.AlunoDTO;
import com.spring.datajpa.controller.dto.AvaliacaoDTO;
import com.spring.datajpa.service.AlunoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;
    @Autowired
    private ModelMapper mapper;


    @GetMapping("/todos")
    public ResponseEntity<List<AlunoDTO>> buscarTodosAlunos(){
        List<AlunoDTO> aluno = service.getAll()
                .stream()
                .map(this::toAlunoDTO)
                .toList();

        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> buscarAluno(@PathVariable("id") Long id){
        Aluno aluno = service.get(id);
        AlunoDTO response = toAlunoDTO(aluno);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/excluir/{id}")
    public void deletarAluno(@PathVariable("id") Long id){
        service.delete(id);
    }


    @PostMapping("/novo")
    public ResponseEntity<AlunoDTO> criarAluno(@Valid @RequestBody AlunoDTO cadastro){
        Aluno aluno = service.create(cadastro);
        AlunoDTO response = toAlunoDTO(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<AlunoDTO> editarAluno(@PathVariable Long id,@RequestBody AlunoDTO editar){
        Aluno atualizado = service.update(id, editar);
        AlunoDTO response = toAlunoDTO(atualizado);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}/exame")
    public ResponseEntity<List<AvaliacaoDTO>> buscarAvaliacoesAluno(@PathVariable("id") Long id){
        List<AvaliacaoDTO> response = service.getAllAval(id)
                .stream()
                .map(this::toAvalDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    //Preparando a função para entrega da DTO ao invés da classe de domínio (conversor)
    public AlunoDTO toAlunoDTO(Aluno aluno){
        return mapper.map(aluno, AlunoDTO.class);
    }
    //Preparando a função para entrega da DTO ao invés da classe de domínio (conversor)
    public AvaliacaoDTO toAvalDTO(AvaliacaoFisica aval){
        return mapper.map(aval, AvaliacaoDTO.class);
    }
}
