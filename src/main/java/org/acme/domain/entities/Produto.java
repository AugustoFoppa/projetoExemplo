package org.acme.domain.entities;

import java.math.BigDecimal;

public class Produto implements  java.io.Serializable {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private BigDecimal estoque;

    public Produto() {
    }

    public Produto(Long id, String nome, BigDecimal preco, BigDecimal estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }
}
