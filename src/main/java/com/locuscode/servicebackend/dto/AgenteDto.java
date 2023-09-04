package com.locuscode.servicebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
public class AgenteDto {
    private String codigo;
    private Date data;
    @JsonMerge
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RegiaoDto> regiao;
}
