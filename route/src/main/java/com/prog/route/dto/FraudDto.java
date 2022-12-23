package com.prog.route.dto;

import lombok.Data;

@Data
public class FraudDto {
    private String name;
    private String textFraud;
    private String route;
    private Long routeVersion;
}