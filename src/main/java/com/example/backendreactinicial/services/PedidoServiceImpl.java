package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.*;
import com.example.backendreactinicial.entities.DTO.PedidoReporte;
import com.example.backendreactinicial.entities.DTO.PedidosPorInstrumento;
import com.example.backendreactinicial.entities.DTO.PedidosPorMesYAnio;
import com.example.backendreactinicial.repositories.BaseRepository;
import com.example.backendreactinicial.repositories.InstrumentoRepository;
import com.example.backendreactinicial.repositories.PedidoDetalleRepository;
import com.example.backendreactinicial.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

            // Costo de envío como double
            double costoEnvio;
            try {
                costoEnvio = "G".equals(instrumento.getCostoEnvio()) ? 0.0 : Double.parseDouble(instrumento.getCostoEnvio());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Formato de costo de envío inválido para el instrumento: " + instrumento.getId(), e);
            }

            totalPedido += (instrumento.getPrecio() * detalle.getCantidad()) + costoEnvio;

            // Sumar la cantidad vendida al instrumento
            instrumento.setCantidadVendida(instrumento.getCantidadVendida() + detalle.getCantidad());
            instrumentoRepository.save(instrumento);

            PedidoDetalle nuevoDetalle = new PedidoDetalle();
            nuevoDetalle.setCantidad(detalle.getCantidad());
            nuevoDetalle.setInstrumento(instrumento);
            nuevoDetalle.setPedido(pedido);

            pedido.getDetalles().add(nuevoDetalle);
        }

        pedido.setTotalPedido(totalPedido);
        return pedidoRepository.save(pedido);
    }


    @Override
    public List<PedidosPorMesYAnio> getPedidosAgrupadosPorMesYAnio(Date fechaDesde, Date fechaHasta) {
        String query = "SELECT new com.example.backendreactinicial.entities.DTO.PedidosPorMesYAnio(CONCAT(FUNCTION('MONTH', p.fechaPedido), '-', FUNCTION('YEAR', p.fechaPedido)), COUNT(p)) " +
                "FROM Pedido p WHERE p.fechaPedido BETWEEN :fechaDesde AND :fechaHasta " +
                "GROUP BY FUNCTION('MONTH', p.fechaPedido), FUNCTION('YEAR', p.fechaPedido)";
        return entityManager.createQuery(query, PedidosPorMesYAnio.class)
                .setParameter("fechaDesde", fechaDesde)
                .setParameter("fechaHasta", fechaHasta)
                .getResultList();
    }

    @Override
    public List<PedidosPorInstrumento> getPedidosAgrupadosPorInstrumento(Date fechaDesde, Date fechaHasta) {
        String query = "SELECT new com.example.backendreactinicial.entities.DTO.PedidosPorInstrumento(pd.instrumento.instrumento, COUNT(pd)) " +
                "FROM PedidoDetalle pd JOIN pd.pedido p WHERE p.fechaPedido BETWEEN :fechaDesde AND :fechaHasta " +
                "GROUP BY pd.instrumento.instrumento";
        return entityManager.createQuery(query, PedidosPorInstrumento.class)
                .setParameter("fechaDesde", fechaDesde)
                .setParameter("fechaHasta", fechaHasta)
                .getResultList();
    }

    @Override
    public List<PedidoReporte> getPedidosReporte(Date fechaDesde, Date fechaHasta) {
        String query = "SELECT new com.example.backendreactinicial.entities.DTO.PedidoReporte(p.fechaPedido, i.instrumento, i.marca, i.modelo, pd.cantidad, i.precio, pd.cantidad * i.precio) " +
                "FROM Pedido p JOIN p.detalles pd JOIN pd.instrumento i WHERE p.fechaPedido BETWEEN :fechaDesde AND :fechaHasta";
        return entityManager.createQuery(query, PedidoReporte.class)
                .setParameter("fechaDesde", fechaDesde)
                .setParameter("fechaHasta", fechaHasta)
                .getResultList();
    }
}
