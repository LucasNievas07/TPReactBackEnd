package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.PedidoDetalle;
import com.example.backendreactinicial.services.PedidoDetalleServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido-detalle")
public class PedidoDetalleController extends BaseControllerImpl<PedidoDetalle, PedidoDetalleServiceImpl>{
}