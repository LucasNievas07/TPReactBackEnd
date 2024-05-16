package com.example.backendreactinicial.controllers;


import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.entities.PedidoDetalle;
import com.example.backendreactinicial.repositories.PedidoDetalleRepository;
import com.example.backendreactinicial.repositories.PedidoRepository;
import com.example.backendreactinicial.services.PedidoServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
    private final PedidoRepository pedidoRepository;
    private final PedidoDetalleRepository pedidoDetalleRepository;

    public PedidoController(PedidoRepository pedidoRepository, PedidoDetalleRepository pedidoDetalleRepository) {
        super();
        this.pedidoRepository = pedidoRepository;
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }

    @PostMapping(value = "/createPedido", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        // Iterar sobre los detalles del pedido y asignar el pedido a cada detalle
        for (PedidoDetalle detalle : pedido.getDetalles()) {
            detalle.setPedido(pedido);
        }

        // Guardar el pedido en la base de datos
        Pedido savedPedido = pedidoRepository.save(pedido);
        System.out.println(pedido);

        return ResponseEntity.ok(savedPedido);
    }


}