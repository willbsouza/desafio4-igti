package com.willbsouza.desafiomod4.dto;

import com.willbsouza.desafiomod4.entity.Venda;
import com.willbsouza.desafiomod4.entity.Vendedor;

import java.time.LocalDate;

public class VendaDTO {

    private Long id;
    private Double valorVenda;
    private LocalDate dataVenda;
    private Vendedor vendedor;

    public VendaDTO() {
    }

    public VendaDTO(Long id, Double valorVenda, LocalDate dataVenda, Vendedor vendedor) {
        this.id = id;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
    }

    public VendaDTO(Venda entidade) {
        this.id = entidade.getId();
        this.valorVenda = entidade.getValorVenda();
        this.dataVenda = entidade.getDataVenda();
        this.vendedor = entidade.getVendedor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}
