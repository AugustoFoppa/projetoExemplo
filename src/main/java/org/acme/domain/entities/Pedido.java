package org.acme.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido implements java.io.Serializable {

    private Long id;
    private LocalDateTime dateTime;
    private Cliente cliente;
    private List<ItemPedido> itemPedidoList;

    public Pedido() {
    }

    public Pedido(Long id, LocalDateTime dateTime, Cliente cliente, List<ItemPedido> itemPedidoList) {
        this.id = id;
        this.dateTime = dateTime;
        this.cliente = cliente;
        this.itemPedidoList = itemPedidoList;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }
}
