package com.example.backendreactinicial.services;

import com.example.backendreactinicial.entities.Categoria;
import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.repositories.BaseRepository;
import com.example.backendreactinicial.repositories.CategoriaRepository;
import com.example.backendreactinicial.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }
}