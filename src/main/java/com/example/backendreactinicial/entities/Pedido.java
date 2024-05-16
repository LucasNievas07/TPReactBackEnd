package com.example.backendreactinicial.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido extends Base {

    private LocalDate fechaPedido;
    private Double totalPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // Usamos cascade
    @JsonBackReference
    private List<PedidoDetalle> detalles;

}
