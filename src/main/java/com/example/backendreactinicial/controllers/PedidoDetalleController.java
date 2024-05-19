package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.PedidoDetalle;
import com.example.backendreactinicial.services.PedidoDetalleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido-detalle")
public class PedidoDetalleController extends BaseControllerImpl<PedidoDetalle, PedidoDetalleServiceImpl> {

    @PostMapping("/create-batch")
    public ResponseEntity<?> createBatch(@RequestBody List<PedidoDetalle> detalles) {
        try {
            List<PedidoDetalle> savedDetalles = new ArrayList<>();
            for (PedidoDetalle detalle : detalles) {
                savedDetalles.add(servicio.save(detalle));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDetalles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }
}
