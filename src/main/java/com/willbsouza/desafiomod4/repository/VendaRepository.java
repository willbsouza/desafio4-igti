package com.willbsouza.desafiomod4.repository;

import com.willbsouza.desafiomod4.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
