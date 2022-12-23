package com.prog.route.service;

import com.prog.route.dto.FraudDto;
import com.prog.route.model.Fraud;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FraudService {
    List<Fraud> findAll();
    FraudDto create(String name, String textFraud, MultipartFile file) throws IOException;
    FraudDto update(Long id, String name, String textFraud, MultipartFile file) throws IOException;

}
