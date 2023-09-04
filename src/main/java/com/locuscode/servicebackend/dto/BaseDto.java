package com.locuscode.servicebackend.dto;

import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class BaseDto {
    private String versao;
    @JsonMerge
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AgenteDto> agente;
}
