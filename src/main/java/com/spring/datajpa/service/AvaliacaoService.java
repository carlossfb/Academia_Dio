package com.spring.datajpa.service;

import com.spring.datajpa.entity.Aluno;
import com.spring.datajpa.entity.AvaliacaoFisica;
import com.spring.datajpa.entity.dto.AvaliacaoDTO;
import com.spring.datajpa.repository.AlunoRepository;
import com.spring.datajpa.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoFisica getByID(Long id){
        return avaliacaoRepository.findById(id).get();
    }

    public AvaliacaoFisica create(AvaliacaoDTO create){
        Aluno aluno = alunoRepository.findById(create.getAlunoId()).get();
        AvaliacaoFisica exame = new AvaliacaoFisica();

        exame.setAltura(create.getAltura());
        exame.setAluno(aluno);
        exame.setPeso(create.getPeso());

        return avaliacaoRepository.save(exame);

    }

    public String delete(Long id){
        AvaliacaoFisica deletar = avaliacaoRepository.findById(id).get();
        avaliacaoRepository.delete(deletar);

        return "Avaliação Física deletada!";
    }




}
