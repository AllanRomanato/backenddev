package com.locuscode.servicebackend.dto;

import lombok.Data;

@Data
public class RegiaoDto {
    private String sigla;
    private GeracaoDto geracao;
    private CompraDto compra;
    private PrecoMedioDto precoMedio;
}
