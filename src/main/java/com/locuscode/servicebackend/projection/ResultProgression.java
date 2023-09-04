package com.locuscode.servicebackend.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ResultProgression {
    Integer getCodigoAgente();
    @JsonIgnore
    String getRegiao();
    String getValorCompra();
    String getValorGeracao();
}
