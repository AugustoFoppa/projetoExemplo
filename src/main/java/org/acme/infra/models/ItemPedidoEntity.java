package org.acme.infra.models;

import jakarta.persistence.*;
import org.acme.domain.entities.Produto;

import java.math.BigDecimal;

@Entity
@Table(name = "item_pedidos")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoEntity produtoEntity;
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedidoEntity;
    @Column(nullable = false)
    private BigDecimal quantidade;
    @Column(nullable = false)
    private BigDecimal precoUnitario;

    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(Long id, ProdutoEntity produtoEntity, PedidoEntity pedidoEntity, BigDecimal quantidade, BigDecimal precoUnitario) {
        this.id = id;
        this.produtoEntity = produtoEntity;
        this.pedidoEntity = pedidoEntity;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoEntity getProdutoEntity() {
        return produtoEntity;
    }

    public void setProdutoEntity(ProdutoEntity produtoEntity) {
        this.produtoEntity = produtoEntity;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public PedidoEntity getPedidoEntity() {
        return pedidoEntity;
    }

    public void setPedidoEntity(PedidoEntity pedidoEntity) {
        this.pedidoEntity = pedidoEntity;
    }
}
