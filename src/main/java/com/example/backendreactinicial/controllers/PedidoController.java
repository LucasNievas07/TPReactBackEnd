package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.DTO.PedidoReporte;
import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.entities.PedidoDetalle;
import com.example.backendreactinicial.entities.DTO.PedidosPorInstrumento;
import com.example.backendreactinicial.entities.DTO.PedidosPorMesYAnio;
import com.example.backendreactinicial.services.PedidoServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;

    @PostMapping("/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody CrearPedidoRequest request) {
        Pedido pedido = pedidoServiceImpl.crearPedido(request.getDetalles());
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/reportes/mes-anio")
    public ResponseEntity<?> getPedidosAgrupadosPorMesYAnio(
            @RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta) {
        try {
            List<PedidosPorMesYAnio> report = pedidoServiceImpl.getPedidosAgrupadosPorMesYAnio(fechaDesde, fechaHasta);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error al obtener datos.\"}");
        }
    }

    @GetMapping("/reportes/instrumento")
    public ResponseEntity<?> getPedidosAgrupadosPorInstrumento(
            @RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta) {
        try {
            List<PedidosPorInstrumento> report = pedidoServiceImpl.getPedidosAgrupadosPorInstrumento(fechaDesde, fechaHasta);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error al obtener datos.\"}");
        }
    }

    @GetMapping("/reportes/detallado")
    public ResponseEntity<?> getPedidosReporte(
            @RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta) {
        try {
            List<PedidoReporte> report = pedidoServiceImpl.getPedidosReporte(fechaDesde, fechaHasta);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error al obtener datos.\"}");
        }
    }
}


@Setter
@Getter
class CrearPedidoRequest {
    private List<PedidoDetalle> detalles;

}
