package com.locuscode.servicebackend.dto;

import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class CompraDto {
    @JsonMerge
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> valor;
}
