package com.locuscode.servicebackend.repository;

import com.locuscode.servicebackend.model.Agente;
import com.locuscode.servicebackend.projection.ResultProgression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Integer> {

    @Query(nativeQuery = true,
        value = "SELECT * FROM BACKENDDB.AGENTE WHERE codigo = :agentId")
    Optional<Agente>verifyExistance(Integer agentId);

    @Query(nativeQuery = true,
        value = "select a.codigo as codigoAgente, r.regiao as regiao, valor_compra as valorCompra, valor_geracao as valorGeracao from backenddb.valores\n" +
                "inner join backenddb.agente a on a.id = valores.agente_id\n" +
                "inner join backenddb.regiao r on r.id = valores.regiao_id")
    List<ResultProgression> getAllDataInformation();
}
