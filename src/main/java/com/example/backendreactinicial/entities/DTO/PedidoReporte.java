package com.example.backendreactinicial.entities.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoReporte {
    private Date fechaPedido;
    private String instrumento;
    private String marca;
    private String modelo;
    private Integer cantidad;
    private Double precio;
    private Double subtotal;
}
