package com.locuscode.servicebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "valores", schema = "backenddb")
public class Valores {
    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "backenddb.compra_id_seq",
            sequenceName = "backenddb.compra_id_seq",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "backenddb.compra_id_seq"
    )
    private Integer id;

    @Column(name = "valor_compra", nullable = false, length = 100)
    private String valorCompra;

    @Column(name = "valor_geracao",nullable = false, length = 100)
    private String valorGeracao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "agenteId")
    private Agente agenteId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "regiaoId")
    private Regiao regiaoId;
}
