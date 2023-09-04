package com.locuscode.servicebackend.repository;

import com.locuscode.servicebackend.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM BACKENDDB.REGIAO WHERE regiao = :regiao")
    Optional<Regiao> verifyExistance(String regiao);
}