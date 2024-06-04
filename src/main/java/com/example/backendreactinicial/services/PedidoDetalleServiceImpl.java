package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.PedidoDetalle;
import com.example.backendreactinicial.repositories.BaseRepository;
import com.example.backendreactinicial.repositories.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoDetalleServiceImpl extends BaseServiceImpl<PedidoDetalle, Long> implements PedidoDetalleService {

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    public PedidoDetalleServiceImpl(BaseRepository<PedidoDetalle, Long> baseRepository, PedidoDetalleRepository pedidoDetalleRepository) {
        super(baseRepository);
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }
}
