package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.entities.PedidoDetalle;
import com.example.backendreactinicial.services.PedidoService;
import com.example.backendreactinicial.services.PedidoServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody CrearPedidoRequest request) {
        Pedido pedido = pedidoService.crearPedido(request.getDetalles());
        return ResponseEntity.ok(pedido);
    }
}

@Setter
@Getter
class CrearPedidoRequest {
    private List<PedidoDetalle> detalles;

}
