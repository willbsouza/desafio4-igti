package com.willbsouza.desafiomod4.dto;

import com.willbsouza.desafiomod4.entity.Venda;
import com.willbsouza.desafiomod4.entity.Vendedor;

import java.util.List;

public class VendedorDTO {

    private Long id;
    private String nome;
    private List<Venda> vendas;

    public VendedorDTO() {
    }

    public VendedorDTO(Long id, String nome, List<Venda> vendas) {
        this.id = id;
        this.nome = nome;
        this.vendas = vendas;
    }

    public VendedorDTO(Vendedor entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.vendas = entidade.getVendas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
