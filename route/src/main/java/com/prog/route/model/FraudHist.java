package com.prog.route.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "app_fraud_hist")
public class FraudHist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String textFraud;
    private String route;
    private Long routeVersion;

}
