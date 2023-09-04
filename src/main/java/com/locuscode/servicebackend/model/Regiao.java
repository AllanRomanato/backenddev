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
@Table(name = "regiao", schema = "backenddb")
public class Regiao {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "backenddb.regiao_id_seq",
            sequenceName = "backenddb.regiao_id_seq",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "backenddb.regiao_id_seq"
    )
    private Integer id;

    @Column(length = 4)
    private String regiao;
}