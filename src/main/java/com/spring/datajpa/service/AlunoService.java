package com.spring.datajpa.service;

import com.spring.datajpa.entity.Aluno;
import com.spring.datajpa.entity.AvaliacaoFisica;
import com.spring.datajpa.controller.dto.AlunoDTO;
import com.spring.datajpa.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno create(AlunoDTO cadastro){
        Aluno aluno = new Aluno();

        aluno.setNome(cadastro.getNome());
        aluno.setEmail(cadastro.getEmail());
        aluno.setCelular(cadastro.getCelular());
        aluno.setCpf(cadastro.getCpf());
        aluno.setDataNascimento(cadastro.getDataNascimento());

        return repository.save(aluno);
    }

    public Aluno get(Long id){
        return repository.findById(id).get();
    }
    public List<Aluno> getAll(){
        return repository.findAll();
    }
    public Aluno update(Long id, AlunoDTO editar){
        Aluno antigo = repository.findById(id).get();
        Aluno atualizado = antigo;

        if(editar.getDataNascimento() != null){
            atualizado.setDataNascimento(editar.getDataNascimento());
        }
        if(editar.getCpf() != null){
            atualizado.setCpf(editar.getCpf());
        }
        if(editar.getNome() != null){
            atualizado.setNome(editar.getNome());
        }
        if(editar.getEmail() != null){
            atualizado.setEmail(editar.getEmail());
        }
        if(editar.getCelular() != null){
            atualizado.setCelular(editar.getCelular());
        }


        return repository.save(atualizado);
    }

    public void delete(Long id){
        Aluno alunoDelete = repository.findById(id).get();
        repository.delete(alunoDelete);
    }

    public List<AvaliacaoFisica> getAllAval(Long id){
        Aluno aluno = repository.findById(id).get();

        return aluno.getAvaliacaoFisica();
    }
}
