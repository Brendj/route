package com.prog.route.controller;

import com.prog.route.service.impl.FraudServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/fraud")
public class FraudController {

    public final FraudServiceImpl service;

    public FraudController(FraudServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String frauds(Model model) {
        model.addAttribute("frauds", service.findAll());
        return "frauds";
    }

    @GetMapping("/{id}")
    public String fraudInfo(@PathVariable Long id, Model model) {
        model.addAttribute("fraud", service.getFraudById(id));
        return "fraud-info";
    }

    @PostMapping("/create")
    public String createFraud(@RequestParam("file") MultipartFile file, String name, String textFraud) throws IOException {
        service.create(name, textFraud, file);
        return "redirect:/fraud/";
    }

    @PostMapping("/update")
    public String updateFraud(@RequestParam("file") MultipartFile file, Long id, String name, String textFraud) throws IOException {
        service.update(id, name, textFraud, file);
        return "redirect:/fraud/";
    }

}
