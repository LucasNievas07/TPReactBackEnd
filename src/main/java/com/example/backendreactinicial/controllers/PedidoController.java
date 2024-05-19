package com.example.backendreactinicial.controllers;

import com.example.backendreactinicial.entities.Pedido;
import com.example.backendreactinicial.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
}