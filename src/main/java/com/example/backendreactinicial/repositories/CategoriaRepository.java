package com.example.backendreactinicial.repositories;

import com.example.backendreactinicial.entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long> {
    Optional<Categoria> findByDenominacion(String denominacion);
}