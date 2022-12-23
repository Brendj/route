package com.prog.route.service.impl;

import com.prog.route.converter.FraudConverter;
import com.prog.route.dto.FraudDto;
import com.prog.route.model.Fraud;
import com.prog.route.model.FraudHist;
import com.prog.route.repo.FraudHistRepo;
import com.prog.route.repo.FraudRepo;
import com.prog.route.service.FraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class FraudServiceImpl implements FraudService {

    public final FraudConverter converter;
    public final FraudRepo fraudRepo;
    public final FraudHistRepo histRepo;


    @Autowired
    public FraudServiceImpl(FraudConverter converter, FraudRepo fraudRepo, FraudHistRepo histRepo) {
        this.converter = converter;
        this.fraudRepo = fraudRepo;
        this.histRepo = histRepo;
    }

    @Override
    public List<Fraud> findAll() {
        return fraudRepo.findAll();
//                .stream()
//                .map(converter::mapToFraudDto)
//                .collect(Collectors.toList());
    }

    @Override
    public FraudDto create(String name, String textFraud, MultipartFile file) throws IOException {

        Fraud fraud = new Fraud();

        fraud.setName(name);
        fraud.setTextFraud(textFraud);
        fraud.setRoute(result(file).toString());
        fraud.setRouteVersion(1L);
        fraudRepo.save(fraud);
        return converter.mapToFraudDto(fraud);

    }

    @Override
    public FraudDto update(Long id, String name, String textFraud, MultipartFile file) throws IOException {
        Fraud fraud = fraudRepo.getById(id);
        if (file != null) {
            FraudHist fraudHist = new FraudHist();
            fraudHist.setRouteVersion(fraud.getRouteVersion());
            fraudHist.setTextFraud(fraud.getTextFraud());
            fraudHist.setName(fraud.getName());
            fraudHist.setRoute(fraud.getRoute());
            histRepo.save(fraudHist);
            fraud.setRoute(result(file).toString());
            fraud.setRouteVersion(fraud.getRouteVersion()+1L);
        }
        if (name != null) {
            fraud.setName(name);
        }
        if (textFraud != null) {
            fraud.setTextFraud(textFraud);
        }
        fraudRepo.save(fraud);
        return converter.mapToFraudDto(fraud);
    }

    public List<String> result(MultipartFile file) throws IOException {

        List<String> result = new ArrayList<>();
        File files = new File("src/main/resources/targetFile.txt");

        try (OutputStream os = new FileOutputStream(files)) {
            os.write(file.getBytes());
        }

        FileReader fr = new FileReader(files);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            if (line.contains("name=")) {
                Pattern p = Pattern.compile("name=\"([^\"]*)\"");
                Matcher m = p.matcher(line);
                while (m.find()) {
                    result.add(m.group(1));
                }
            }
            line = reader.readLine();
        }
        return result;

    }

    public Fraud getFraudById(Long id) {
        Fraud fraud = fraudRepo.getById(id);
        return fraud;
    }
}
