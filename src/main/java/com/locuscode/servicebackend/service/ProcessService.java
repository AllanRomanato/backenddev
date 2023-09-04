package com.locuscode.servicebackend.service;

import java.util.Map;

public interface ProcessService<T> {

    void processData(String payload);
    Map<String, T> getAllInfosAndConsolidate();
}
