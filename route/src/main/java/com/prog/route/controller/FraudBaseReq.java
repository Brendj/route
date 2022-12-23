package com.prog.route.controller;

import lombok.Data;

@Data
public class FraudBaseReq {
    private String name;
    private String textFraud;
    private String route;
}
