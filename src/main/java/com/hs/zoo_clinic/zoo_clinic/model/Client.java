package com.hs.zoo_clinic.zoo_clinic.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "client")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name="password")
    private String password;
}

