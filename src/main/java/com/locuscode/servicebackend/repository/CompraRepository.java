package com.locuscode.servicebackend.repository;

import com.locuscode.servicebackend.model.Valores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Valores, Integer> {
}