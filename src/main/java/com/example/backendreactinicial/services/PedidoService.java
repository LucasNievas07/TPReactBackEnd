package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.DTO.PedidoReporte;
import com.example.backendreactinicial.entities.DTO.PedidosPorInstrumento;
import com.example.backendreactinicial.entities.DTO.PedidosPorMesYAnio;
import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.entities.PedidoDetalle;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{
    Pedido crearPedido(List<PedidoDetalle> detalles);
    List<PedidosPorMesYAnio> getPedidosAgrupadosPorMesYAnio(Date fechaDesde, Date fechaHasta);
    List<PedidosPorInstrumento> getPedidosAgrupadosPorInstrumento(Date fechaDesde, Date fechaHasta);
    List<PedidoReporte> getPedidosReporte(Date fechaDesde, Date fechaHasta);
}