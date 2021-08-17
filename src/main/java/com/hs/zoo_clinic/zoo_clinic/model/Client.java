package com.hs.zoo_clinic.zoo_clinic.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "client")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
}

