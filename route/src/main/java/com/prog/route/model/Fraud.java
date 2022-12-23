package com.prog.route.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "app_fraud")
public class Fraud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String textFraud;
    private String route;
    private Long routeVersion;

}
