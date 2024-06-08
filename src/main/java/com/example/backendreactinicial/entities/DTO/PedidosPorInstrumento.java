package com.example.backendreactinicial.entities.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidosPorInstrumento {
    private String instrumento;
    private Long cantidad;
}
