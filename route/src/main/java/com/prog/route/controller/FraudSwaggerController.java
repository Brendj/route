package com.prog.route.controller;

import com.prog.route.dto.FraudDto;
import com.prog.route.model.Fraud;
import com.prog.route.service.impl.FraudServiceImpl;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class FraudSwaggerController {
    public final FraudServiceImpl service;

    public FraudSwaggerController(FraudServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Fraud> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FraudDto create(@RequestPart("Rout") @ApiParam(value = "File", required = true) MultipartFile file, String name, String textFraud) throws IOException {
        return service.create(name, textFraud, file);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FraudDto update(@RequestPart("Rout") @ApiParam(value = "File", required = true) MultipartFile file, Long id, String name, String textFraud) throws IOException {
        return service.update(id, name, textFraud, file);
    }
}
