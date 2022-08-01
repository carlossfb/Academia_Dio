package com.spring.datajpa.repository;

import com.spring.datajpa.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoFisica, Long> {
}
