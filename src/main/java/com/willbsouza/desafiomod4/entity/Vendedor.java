package com.willbsouza.desafiomod4.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany
    private List<Venda> vendas;

    public Vendedor() {
    }

    public Vendedor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Vendedor(Long id, String nome, List<Venda> vendas) {
        this.id = id;
        this.nome = nome;
        this.vendas = vendas;
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
