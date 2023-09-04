package com.locuscode.servicebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agente", schema = "backenddb")
public class Agente {
    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "backenddb.agente_id_seq",
            sequenceName = "backenddb.agente_id_seq",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "backenddb.agente_id_seq"
    )
    private Integer id;

    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    private Timestamp data;
}
