package com.spring.datajpa.controller;

import com.spring.datajpa.entity.AvaliacaoFisica;
import com.spring.datajpa.entity.dto.AvaliacaoDTO;
import com.spring.datajpa.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("exame")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @GetMapping("/{id}")
    public AvaliacaoFisica BuscarAvaliacoes(@PathVariable("id") Long id){
        return service.getByID(id);
    }

    @PostMapping("/novo")
    public AvaliacaoFisica CriarAvaliacao(@RequestBody AvaliacaoDTO create){

        return service.create(create);
    }
}
