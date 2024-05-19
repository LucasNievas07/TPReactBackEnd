package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.PedidoDetalle;
import java.util.List;

public interface PedidoDetalleService extends BaseService<PedidoDetalle, Long>{
    List<PedidoDetalle> saveAll(List<PedidoDetalle> detalles) throws Exception;
}
