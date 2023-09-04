package com.locuscode.servicebackend.controller;

import com.locuscode.servicebackend.projection.ResultProgression;
import com.locuscode.servicebackend.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProcessController extends AbstractController{

    @Autowired
    private ProcessService processService;

    @PostMapping("/receive-data")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> processXml(@RequestBody String payload) {
        processService.processData(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping (value = "/retrieve-data", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, List<ResultProgression>>> retrieveData() {
        return new ResponseEntity<>(processService.getAllInfosAndConsolidate(), HttpStatus.OK);
    }
}
