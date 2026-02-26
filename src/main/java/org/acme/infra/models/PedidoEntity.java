package org.acme.infra.models;

import jakarta.persistence.*;
import org.acme.domain.entities.Cliente;
import org.acme.domain.entities.ItemPedido;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity clienteEntity;
    @OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemPedidoEntity> itemPedidoEntityList;

    public PedidoEntity() {
    }

    public PedidoEntity(Long id, LocalDateTime dateTime, ClienteEntity clienteEntity, List<ItemPedidoEntity> itemPedidoEntityList) {
        this.id = id;
        this.dateTime = dateTime;
        this.clienteEntity = clienteEntity;
        this.itemPedidoEntityList = itemPedidoEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public List<ItemPedidoEntity> getItemPedidoEntityList() {
        return itemPedidoEntityList;
    }

    public void setItemPedidoEntityList(List<ItemPedidoEntity> itemPedidoEntityList) {
        this.itemPedidoEntityList = itemPedidoEntityList;
    }
}
