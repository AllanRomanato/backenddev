package com.locuscode.servicebackend.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.locuscode.servicebackend.dto.*;
import com.locuscode.servicebackend.exceptions.BadRequestException;
import com.locuscode.servicebackend.model.*;
import com.locuscode.servicebackend.projection.ResultProgression;
import com.locuscode.servicebackend.repository.AgenteRepository;
import com.locuscode.servicebackend.repository.CompraRepository;
import com.locuscode.servicebackend.repository.RegiaoRepository;
import com.locuscode.servicebackend.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private AgenteRepository agenteRepository;

    @Autowired
    private RegiaoRepository regiaoRepository;


    @Autowired
    private CompraRepository compraRepository;

    @Override
    public void processData(String payload) {
        try {
            List<Valores> val = new ArrayList<>();
            //Parse the received payload
            BaseDto baseDto = new XmlMapper().readValue(payload, BaseDto.class);
            //Showing Agents codes in console.
            log.info("Inserting data.");
            for(AgenteDto agente : baseDto.getAgente()) {
                Agente agent = null;
                Optional<Agente> agentOpt = agenteRepository.verifyExistance(Integer.parseInt(agente.getCodigo()));
                if(agentOpt.isPresent()) {
                    agent = agentOpt.get();
                    agent.setData(Timestamp.valueOf(LocalDateTime.now()));
                    agent = agenteRepository.save(agent);
                }else {
                    agent = Agente.builder()
                            .data(Timestamp.valueOf(LocalDateTime.now()))
                            .codigo(Integer.parseInt(agente.getCodigo()))
                            .build();
                    agent = agenteRepository.save(agent);
                }
                for(RegiaoDto regiao : agente.getRegiao()) {
                    Regiao region = null;

                    Optional<Regiao> regionOpt = regiaoRepository.verifyExistance(regiao.getSigla());

                    if(regionOpt.isPresent()){
                        region = regionOpt.get();
                    } else {
                        region = Regiao.builder()
                                .regiao(regiao.getSigla())
                                .build();
                        region = regiaoRepository.save(region);
                    }

                    if(regiao.getGeracao().getValor().size() == regiao.getCompra().getValor().size()){
                        for(int i = 0 ; i < regiao.getGeracao().getValor().size(); i++){
                            val.add(Valores.builder()
                                    .valorGeracao(regiao.getGeracao().getValor().get(i))
                                    .valorCompra(regiao.getCompra().getValor().get(i))
                                    .agenteId(agent)
                                    .regiaoId(region)
                                    .build());
                        }
                    }
                }
            }
            compraRepository.saveAll(val);

            log.info("Success");
        } catch (JsonProcessingException e) {
            log.error("Error processing the following payload: "+payload, e);
            throw new BadRequestException("Error processing the payload");
        }
    }

    public Map<String, List<ResultProgression>> getAllInfosAndConsolidate(){
        try {
        List<ResultProgression> result = agenteRepository.getAllDataInformation();
        Map<String, List<ResultProgression>> groupedByRegiao = result.stream()
                .collect(Collectors.groupingBy(ResultProgression::getRegiao));

            System.out.println(new ObjectMapper().writeValueAsString(groupedByRegiao));
            return groupedByRegiao;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
