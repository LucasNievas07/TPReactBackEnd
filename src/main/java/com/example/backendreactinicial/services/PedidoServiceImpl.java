package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.Instrumento;
import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.entities.PedidoDetalle;
import com.example.backendreactinicial.repositories.BaseRepository;
import com.example.backendreactinicial.repositories.InstrumentoRepository;
import com.example.backendreactinicial.repositories.PedidoDetalleRepository;
import com.example.backendreactinicial.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Autowired
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Pedido crearPedido(List<PedidoDetalle> detalles) {
        Pedido pedido = new Pedido();
        java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
        pedido.setFechaPedido(fechaActual);
        pedido.setDetalles(new ArrayList<>());

        double totalPedido = 0.0;

        for (PedidoDetalle detalle : detalles) {
            Instrumento instrumento = instrumentoRepository.findById(detalle.getInstrumento().getId())
                    .orElseThrow(() -> new RuntimeException("Instrumento no encontrado"));

            double costoEnvio = "G".equals(instrumento.getCostoEnvio()) ? 0.0 : Double.parseDouble(instrumento.getCostoEnvio());
            totalPedido += (instrumento.getPrecio() * detalle.getCantidad()) + costoEnvio;

            PedidoDetalle nuevoDetalle = new PedidoDetalle();
            nuevoDetalle.setCantidad(detalle.getCantidad());
            nuevoDetalle.setInstrumento(instrumento);
            nuevoDetalle.setPedido(pedido);

            pedido.getDetalles().add(nuevoDetalle);
        }

        pedido.setTotalPedido(totalPedido);
        return pedidoRepository.save(pedido);
    }

}
