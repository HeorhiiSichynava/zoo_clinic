package com.hs.zoo_clinic.zoo_clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;

@Table(name = "client")
@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name="password")
    private String password;
    @OneToMany(mappedBy = "client")
    @Column(name = "pet")
    private HashSet<Animal> animalHashSet;
}


