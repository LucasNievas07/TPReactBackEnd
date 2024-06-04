package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.entities.PedidoDetalle;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{
    public Pedido crearPedido(List<PedidoDetalle> detalles);
}