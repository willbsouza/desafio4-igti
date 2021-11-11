package com.willbsouza.desafiomod4.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @Column(nullable = false)
    private Double valorVenda;

    @Column(nullable = false)
    private LocalDate dataVenda;

    public Venda() {
    }

    public Venda(Long id, Double valorVenda, LocalDate dataVenda, Vendedor vendedor) {
        this.id = id;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}